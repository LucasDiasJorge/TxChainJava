# TxChainJava - Simulador de Blockchain com UTXO

## Sobre o Projeto
TxChainJava é um projeto simples em Java que simula uma **blockchain baseada no modelo UTXO** (Unspent Transaction Output). Ele permite realizar **transações entre usuários**, registrar essas transações em blocos e verificar o saldo baseado nos UTXOs disponíveis.

## Como Funciona o Modelo UTXO?
No modelo tradicional de contabilidade (contas e saldos), cada usuário tem um saldo armazenado em um banco de dados. No entanto, no modelo **UTXO**, os saldos são derivados da soma das saídas de transações não gastas (**Unspent Transaction Outputs**). Cada transação segue estas etapas:

1. O remetente seleciona um ou mais **UTXOs** existentes como **inputs**.
2. O total dos inputs é verificado para garantir que seja suficiente para a transação.
3. O sistema cria novos **UTXOs** como **outputs**, destinando fundos ao destinatário e, se houver troco, devolvendo ao remetente.
4. Os UTXOs gastos são removidos da lista de ativos.

Este modelo é utilizado no **Bitcoin** e em outras criptomoedas baseadas em UTXO.

## Estrutura da Blockchain
A blockchain do projeto segue uma estrutura simples:

- **Blocos**: Contêm transações e apontam para o hash do bloco anterior.
- **Transações**: Movem valores entre usuários utilizando o modelo **UTXO**.
- **UTXOs**: Representam saídas de transação que ainda podem ser usadas como entrada para novas transações.
- **Bloco Gênesis**: Primeiro bloco da blockchain, criado com UTXOs iniciais para os primeiros participantes.

## Funcionalidades
* Criar e registrar transações na blockchain.  
* Calcular saldo de um usuário com base nos UTXOs.  
* Armazenar transações em blocos encadeados.  
* Implementação modular para expansão futura.

## Futuras Melhorias
* **Proof of Work (PoW)**: Implementação de um mecanismo de mineração que exige um cálculo computacional para adicionar blocos.  
* **Chaves Criptográficas**: Uso de assinaturas digitais para autenticar transações.  
* **Rede P2P**: Permitir comunicação entre múltiplos nós simulados.  
* **Interface Gráfica ou API**: Criar uma API REST para interação com a blockchain.
