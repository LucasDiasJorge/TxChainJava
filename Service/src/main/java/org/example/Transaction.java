package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Transaction {
    String sender;
    String recipient;
    double amount;
    List<UTXO> inputs;
    List<UTXO> outputs;

    public Transaction(String sender, String recipient, double amount, List<UTXO> inputs) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.inputs = inputs;
        this.outputs = new ArrayList<>();

        // Criar novo UTXO para destinatário
        outputs.add(new UTXO(UUID.randomUUID().toString(), recipient, amount));

        // Calcular troco e criar novo UTXO para remetente
        double totalInput = inputs.stream().mapToDouble(utxo -> utxo.amount).sum();
        if (totalInput > amount) {
            outputs.add(new UTXO(UUID.randomUUID().toString(), sender, totalInput - amount));
        }
    }
}
