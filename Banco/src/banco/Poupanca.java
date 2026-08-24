package banco;

public class Poupanca extends Conta {

    Poupanca(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        super(numero, titular, criacao, gerente);
    }

    double saldoDisponivel() {
        return this.saldo;
    }

    void rendimento(double juro){
        this.saldo += juro;
    }
    
}
