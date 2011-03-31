package org.paulobichara.dberrorrecovery;

import java.util.*;

public class Subsistema {

    private ArrayList transacoes, variaveis;  // ArrayList que guarda as transações e variaveis criadas
    private int freqChkpt;                    // Frequencia de inserçao de CheckPoints
    private Log log;                          // Arquivo de Log
    private int contadorTS;                   // Variável que indica o proximo valor de TimeStamp a ser atribuido a uma transação criada
    private int contadorReg;                  // Variável que permite o controle de inserção de Checkpoints

    public Subsistema() {
        transacoes = new ArrayList();
        variaveis = new ArrayList();
        log = new Log();
        contadorReg = 0;
        contadorTS = 0;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setFreqChkpt(int f) {
        freqChkpt = f;
    }

    public void adicionaTransacao(String i) {
        Transacao t = new Transacao(i);
        transacoes.add(t);
    }

    public void adicionaVariavel(String i, int v) {
        Variavel var = new Variavel(i, v);
        variaveis.add(var);
    }

    public Transacao buscaTransacao(String t) {
        int i = 0;
        Transacao trans = null;

        do {
            trans = (Transacao)transacoes.get(i);
            i++;
        } while ((i < transacoes.size()) && (!trans.getId().equals(t)));
        return trans;
    }

    public String executaStart(String t) {
        Transacao trans = this.buscaTransacao(t);
        trans.setTimeStamp(contadorTS);
        String registro;
        contadorTS++;
        registro = log.insereStart(t);
        contadorReg++;
        if (contadorReg == freqChkpt) {
            registro = registro + log.insereCheckpoint();
            contadorReg = 0;
            this.salvarEmDisco();
        }
        return registro;
    }

    public String executaCommit(String t) {
        Transacao trans = this.buscaTransacao(t);
        String registro;
        registro = log.insereCommit(t);
        contadorReg++;
        if (contadorReg == freqChkpt) {
            registro = registro + log.insereCheckpoint();
            contadorReg = 0;
            this.salvarEmDisco();
        }
        return registro;
    }

/*    public boolean checaInserirChkpt() {
        boolean inserir = false;
        int i = log.getTamanhoLog();
        Registro reg = null;
        int cont = 0;
        do {
            reg = log.getRegistro(i);
            if (!reg.getRegistro().equals("<CHECKPOINT>")) {
                cont++;
            }
            i--;
        } while ((i > -1) && (!reg.getRegistro().equals("<CHECKPOINT>")));
        if (cont == freqChkpt) {
            inserir = true;
        }
        return inserir;
    }*/

    public Variavel buscaVariavel(String v) {
        int i = 0;
        Variavel var = null;

        do {
            var = (Variavel)variaveis.get(i);
            i++;
        } while ((i < variaveis.size()) && (!var.getId().equals(v)));
        return var;
    }


    public boolean checaOperacaoTS(String o, Transacao t, Variavel v) {
        Transacao trans = t;
        Variavel var = v;
        boolean aceita = false;
        if (o.equals("WRITE")) {
            if ((var.getControleRead() <= trans.getTimeStamp()) && (var.getControleWrite() <= trans.getTimeStamp())) {
                aceita = true;
            }
        } else {
            if (o.equals("READ")) {
                if (var.getControleWrite() <= trans.getTimeStamp()) {
                    aceita = true;
                }
            }
        }
        return aceita;
    }

    public String executaOperacao(String t, String o, String v) {
        Transacao trans = this.buscaTransacao(t);
        Variavel var = this.buscaVariavel(v);
        if (this.checaOperacaoTS(o, trans, var)) {
            if (var.getControleRead() < trans.getTimeStamp()) {
                var.setControleRead(trans.getTimeStamp());
            }
            return null;
        } else {
            return "Operação de leitura nao pode ser executada pois viola o protocolo de TimeStamps!";
        }

    }

    public String executaOperacao(String t, String o, String v, int valor) {
        Transacao trans = this.buscaTransacao(t);
        Variavel var = this.buscaVariavel(v);
        if (this.checaOperacaoTS(o, trans, var)) {
            String registro;
            var.setControleWrite(trans.getTimeStamp());
            registro = log.InsereOperacao(t, v, valor);
            contadorReg++;
            if (contadorReg == freqChkpt) {
                registro = registro + log.insereCheckpoint();
                this.salvarEmDisco();
                contadorReg = 0;
            }
            return registro;
        } else {
            return "Operação de escrita nao pode ser executada pois viola o protocolo de TimeStamps!";
        }
    }

    public void salvarEmDisco() {
        int i = log.getTamanhoLog() - 1 - freqChkpt;
        ArrayList transacoesCommit = new ArrayList();
        Registro reg = null;
        do {
            reg = log.getRegistro(i);
            if (reg.getTipo().equals("COMMIT")) {
                transacoesCommit.add(reg.getTransaçao());
            }
            i++;
        } while ((i < log.getTamanhoLog()));
        if (transacoesCommit.size() >= 1) {
            for (int j = 0; j < log.getTamanhoLog(); j++) {
                reg = log.getRegistro(j);
                if (transacoesCommit.contains(reg.getTransaçao())) {
                    if (reg.getTipo().equals("WRITE")) {
                        Variavel var = this.buscaVariavel(reg.getVariável());
                        var.setValor(reg.GetValorNovo());
                    }
                }
            }
        }
    }

    public String insereErro() {
        return log.insereErro();
    }

    public void refazerOperacao(String t) {
        int j = -1;
        int tam = log.getTamanhoLog();
        do {
            j++;
            Registro reg = log.getRegistro(j);
            if (reg.getTipo().equals("WRITE")) {
                if (reg.getTransaçao().equals(t)) {
                    Variavel var = this.buscaVariavel(reg.getVariável());
                    var.setValor(reg.GetValorNovo());
                }
            }
        } while (j < tam-1);
    }

    public String recuperacaoDeErro() {
        int i;
        Registro reg;
        String registro = new String();
        ArrayList transacoesREDO = new ArrayList();
        for (i = log.getTamanhoLog()-1; ((!log.getRegistro(i).getTipo().equals("CHECKPOINT")) & (i > 0)); i--) {
            reg = log.getRegistro(i);
            if (reg.getTipo().equals("COMMIT")) {
                transacoesREDO.add(reg.getTransaçao());
//                this.refazerOperacao(reg.getTransaçao());
            }
        }
        if (!log.getRegistro(i).getRegistro().equals("< CHECKPOINT >")) {
            transacoesREDO.clear();
        }
        for (i = 0; i < transacoesREDO.size(); i++) {
            this.refazerOperacao((String)transacoesREDO.get(i));
            Transacao trans = this.buscaTransacao((String)transacoesREDO.get(i));
            registro = registro + trans.getId() + "  " + trans.getTimeStamp() + "\n";
        }
        return registro;
    }

    public void resetarSubsistema() {
        transacoes.clear();
        variaveis.clear();
        freqChkpt = 0;
        contadorTS = 0;
        contadorReg = 0;
        log.resetarLog();
    }

    public int getTimeStamp(String t) {
        Transacao trans = this.buscaTransacao(t);
        return trans.getTimeStamp();
    }

    private void jbInit() throws Exception {
    }

}
