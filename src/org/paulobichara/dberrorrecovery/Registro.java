package org.paulobichara.dberrorrecovery;

public class Registro {

    private String transacao;
    private String variavel;
    private int valorNovo;
    String tipo = new String();
    private String registro;

    public Registro(String t, String var, int val) {
        transacao = t;
        variavel = var;
        valorNovo = val;
        registro = "< "+"WRITE"+": "+transacao+", "+variavel+", "+valorNovo+" >";
        tipo = "WRITE";
    }

    public Registro(String r) {
        registro = "< "+r+" >";
        tipo = r;
    }

    public Registro (String t, String r) {
        transacao = t;
        registro = "< "+r+": "+transacao+" >";
        tipo = r;
    }

    public String getTransaçao() {
        return transacao;
    }

    public String getVariável() {
        return variavel;
    }

    public int GetValorNovo() {
        return valorNovo;
    }

    public String getRegistro() {
        return registro;
    }

    public String getTipo() {
        return tipo;
    }
}
