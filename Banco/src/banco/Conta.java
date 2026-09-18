package banco;
import java.util.Scanner;
 

public class Conta {
    String numero;
    Pessoa titular;
    double saldo;
    Data criacao;
    Gerente gerente;

    Conta(Gerente gerente) {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o número da conta: ");
        this.numero = s.nextLine();
        System.out.println("Digite os dados do titular: ");
        this.titular = new Pessoa();
        this.saldo = 0;
        this.criacao = new Data();
        this.gerente = gerente;
        System.out.println("Conta criada com sucesso!");
    }

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
