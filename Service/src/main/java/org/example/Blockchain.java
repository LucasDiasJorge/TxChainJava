package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Blockchain {
    List<Block> chain;
    List<UTXO> utxos;

    public Blockchain() {
        this.chain = new ArrayList<>();
        this.utxos = new ArrayList<>();
        createGenesisBlock();
    }

    private void createGenesisBlock() {
        Block genesisBlock = new Block(0, "0");
        chain.add(genesisBlock);

        // Criar UTXO inicial (dinheiro inicial do sistema)
        utxos.add(new UTXO(UUID.randomUUID().toString(), "Alice", 10.0));
        utxos.add(new UTXO(UUID.randomUUID().toString(), "Bob", 5.0));
    }

    public void addBlock(Block block) {
        chain.add(block);
    }

    public boolean processTransaction(Transaction tx) {
        // Verificar se remetente tem UTXOs suficientes
        double balance = getBalance(tx.sender);
        if (balance < tx.amount) {
            System.out.println("❌ Saldo insuficiente para " + tx.sender);
            return false;
        }

        // Remover UTXOs gastos
        utxos.removeAll(tx.inputs);

        // Adicionar novos UTXOs
        utxos.addAll(tx.outputs);

        // Criar novo bloco para armazenar a transação
        Block newBlock = new Block(chain.size(), chain.get(chain.size() - 1).hash);
        newBlock.addTransaction(tx);
        addBlock(newBlock);

        System.out.println("✅ Transação registrada no bloco " + newBlock.index);
        return true;
    }

    public double getBalance(String owner) {
        return utxos.stream()
                .filter(utxo -> utxo.owner.equals(owner))
                .mapToDouble(utxo -> utxo.amount)
                .sum();
    }

    public List<UTXO> getUserUTXOs(String owner) {
        List<UTXO> userUTXOs = new ArrayList<>();
        for (UTXO utxo : utxos) {
            if (utxo.owner.equals(owner)) {
                userUTXOs.add(utxo);
            }
        }
        return userUTXOs;
    }
}
