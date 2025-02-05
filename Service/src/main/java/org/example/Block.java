package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Block {
    int index;
    long timestamp;
    List<Transaction> transactions;
    String previousHash;
    String hash;

    public Block(int index, String previousHash) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.transactions = new ArrayList<>();
        this.hash = UUID.randomUUID().toString();  // Hash fictício (iremos mudar isso no PoW)
    }

    public void addTransaction(Transaction tx) {
        transactions.add(tx);
    }
}
