package org.paulobichara.dberrorrecovery;


public class Variavel {

    private String id;
    private int valor;
    private int controleRead, controleWrite;

    public Variavel(String i, int v) {
        id = i;
        valor = v;
        controleRead = 0;
        controleWrite = 0;
    }

    public void setValor(int v) {
        valor = v;
    }

    public String getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }

    public void setControleRead(int c) {
        controleRead = c;
    }

    public void setControleWrite(int c) {
        controleWrite = c;
    }

    public int getControleRead() {
        return controleRead;
    }

    public int getControleWrite() {
        return controleWrite;
    }

}
