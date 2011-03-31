package org.paulobichara.dberrorrecovery;

public class Transacao {

    private int timestamp;
    private String id;

    public Transacao(String i) {
        id = i;
    }

    public void setTimeStamp(int t) {
        timestamp = t;
    }

    public String getId() {
        return id;
    }

    public int getTimeStamp() {
        return timestamp;
    }
}
