package org.example;

class UTXO {
    String id;
    String owner;
    double amount;

    public UTXO(String id, String owner, double amount) {
        this.id = id;
        this.owner = owner;
        this.amount = amount;
    }
}
