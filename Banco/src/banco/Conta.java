package banco;

public class Conta {
    String numero;
    Pessoa titular;
    double saldo,limite;

    void extrato() {
        System.out.println("*** EXTRATO DA CONTA ***");
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Titular: " + this.titular.nome);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);    
        System.out.println("Valor disponívelpara saque: " + (this.saldo + this.limite));
        System.out.println("*************************");
    }

    }
