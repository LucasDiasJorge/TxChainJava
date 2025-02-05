package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        System.out.println("💰 Saldo inicial de Alice: " + blockchain.getBalance("Alice"));
        System.out.println("💰 Saldo inicial de Bob: " + blockchain.getBalance("Bob"));

        // Alice envia 3 BTC para Bob
        List<UTXO> aliceUTXOs = blockchain.getUserUTXOs("Alice");
        Transaction tx1 = new Transaction("Alice", "Bob", 3.0, aliceUTXOs.subList(0, 1));

        blockchain.processTransaction(tx1);

        System.out.println("💰 Saldo de Alice após transação: " + blockchain.getBalance("Alice"));
        System.out.println("💰 Saldo de Bob após transação: " + blockchain.getBalance("Bob"));

        // Bob envia 2 BTC para Alice
        List<UTXO> bobUTXOs = blockchain.getUserUTXOs("Bob");
        Transaction tx2 = new Transaction("Bob", "Alice", 2.0, bobUTXOs.subList(0, 1));

        blockchain.processTransaction(tx2);

        System.out.println("💰 Saldo final de Alice: " + blockchain.getBalance("Alice"));
        System.out.println("💰 Saldo final de Bob: " + blockchain.getBalance("Bob"));
    }
}
