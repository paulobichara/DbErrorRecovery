package org.paulobichara.dberrorrecovery;

import java.util.*;

public class Log {

    private ArrayList historico;

    public Log() {
        historico = new ArrayList();
    }

    public String InsereOperacao(String t, String var, int val) {
        Registro reg = new Registro(t, var, val);
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public String insereErro() {
        Registro reg = new Registro("ERRO");
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public String insereCommit(String t) {
        Registro reg = new Registro(t, "COMMIT");
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public String insereCheckpoint() {
        Registro reg = new Registro("CHECKPOINT");
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public String insereStart(String t) {
        Registro reg = new Registro(t, "START");
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public int getTamanhoLog() {
        return historico.size();
    }

    public Registro getRegistro(int i) {
        return (Registro)historico.get(i);
    }

    public void resetarLog() {
        historico.clear();
    }

}
