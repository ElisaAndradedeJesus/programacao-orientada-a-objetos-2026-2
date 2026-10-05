package banco;
import java.util.Scanner;
 

public class Conta {
    protected String numero;
    protected Pessoa titular;
    protected double saldo;
    protected Data criacao;
    protected Gerente gerente;

    Conta(Gerente gerente) {
        Scanner s = Entrada.scanner;
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

    protected double disponivel() {
        return this.saldo;
    }

    public void depositar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) {
            System.out.println("O depósito deve ter um valor positivo.");
            return;
        }
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        System.out.println("Novo saldo: R$ " + this.saldo);
    }

    public void extrato() {
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Titular: " + this.titular.getNome() + " (CPF: " + this.titular.getCpf() + ")");
        System.out.println("Saldo disponível para saque: R$ " + this.disponivel());
        this.criacao.exibirData();
    }

    public boolean sacar(double valor) {
        if (Double.isFinite(valor) && valor > 0 && valor <= this.disponivel()) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + this.saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque de R$ " + valor);
            return false;
        }
    }

    public boolean transferir(double valor, Conta destino) {
        if (destino == null || destino == this) {
            System.out.println("Conta de destino inválida.");
            return false;
        }
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
            return true;
        }
        return false;
    }

    // Mantém compatibilidade com as chamadas anteriores do projeto.
    public boolean transferir(Conta destino, double valor) {
        return this.transferir(valor, destino);
    }

    // Getters and Setters
    public String getNumero() {
        return numero;      
    }   
    public Pessoa getTitular() {
        return titular;
    }
    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }


    public Data getDataCriacao() {
        return criacao;
    }
   public Gerente getGerente() {
        return gerente;
    }
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
}
