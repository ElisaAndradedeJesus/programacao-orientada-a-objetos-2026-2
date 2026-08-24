package banco;

public class Conta {
    String numero;
    Pessoa titular;
    double saldo;
    Data criacao;
    Gerente gerente;

    Conta(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.criacao = criacao;
        this.gerente = gerente;
        System.out.println("Conta criada com sucesso!");
    }

    void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        System.out.println("Novo saldo: R$ " + this.saldo);
    }


   
    
}
