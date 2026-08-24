package banco;

public class Conta {
    String numero;
    Pessoa titular;
    double saldo,limite;

    Conta(String n, Pessoa t) {
        this.numero = n;
        this.titular = t;
        System.out.println("Conta criada com sucesso!");
    }
    Conta(String n, Pessoa t, double l) {
        this.numero = n;
        this.titular = t;
        this.saldo = 0;
        this.limite = l;
        System.out.println("Conta criada com sucesso!");
    }

    double saldoDisponivel() {
        return this.saldo + this.limite;
    }

    void extrato() {
        System.out.println("*** EXTRATO DA CONTA ***");
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Titular: " + this.titular.nome);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);    
        System.out.println("Valor disponívelpara saque: " + this.saldoDisponivel());
        System.out.println("*************************");
    }

    void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        System.out.println("Novo saldo: R$ " + this.saldo);
    }

    boolean sacar(double valor) {
        if (valor <= this.saldoDisponivel()) {
            this.saldo -= valor;
            System.out.println("Saque na conta " + this.numero + " realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + this.saldo);
            return true;
        } else {
            System.out.println("ERRO: Saque na conta " + this.numero + " não realizado. Saldo disponível: R$ " + this.saldoDisponivel());
            return false;
        }
    }

    boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " da conta " + this.numero + " para a conta " + destino.numero + " realizada com sucesso!");
            return true;
        } else {
            System.out.println("ERRO: Transferência de R$ " + valor + " da conta " + this.numero + " para a conta " + destino.numero + " não realizada. Saldo disponível: R$ " + this.saldoDisponivel());
            return false;
        }
    }
    void chequeEspecial(double juros) {
        if (this.saldo >= 0) {
            return;
        } else {

            this.saldo = this.saldo + (juros + this.saldo)/100;
            // System.out.println("Juros de R$ " + juros + " cobrados na conta " + this.numero + ". Novo saldo: R$ " + this.saldo);
        }
    }
}
