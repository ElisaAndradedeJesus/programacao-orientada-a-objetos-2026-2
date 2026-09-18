package banco;

import java.util.Scanner;

public class ContaCorrente extends Conta {
    double limiteChequeEspecial;

    ContaCorrente(Gerente gerente) {
        super(gerente);
        this.limiteChequeEspecial = 200;
    }
    ContaCorrente(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        super(numero, titular, criacao, gerente);
        this.limiteChequeEspecial = 200;
    }

    double saldoDisponivel() {
        return this.saldo + this.limiteChequeEspecial;
    }

    void extrato() {
        System.out.println("*** EXTRATO DA CONTA ***");
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Titular: " + this.titular.nome);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limiteChequeEspecial);    
        System.out.println("Valor disponívelpara saque: " + this.saldoDisponivel());
        System.out.println("*************************");
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

    void chequeEspecial(double taxa) {
        if (this.saldo < 0) {
            this.saldo = this.saldo + (taxa * this.saldo) / 100;
        }
    }

}