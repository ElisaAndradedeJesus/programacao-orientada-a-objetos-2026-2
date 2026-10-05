package banco;

public class Poupanca extends Conta {

    public Poupanca(Gerente gerente) {
        super(gerente);
    }
    Poupanca(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        super(numero, titular, criacao, gerente);
    }

    @Override
    public void extrato() {
        System.out.println("*** EXTRATO DA POUPANÇA ***");
        super.extrato();
    }

    public void rendimentos(double juro) {
        this.saldo += this.saldo * juro / 100;
    }

    public void rendimento(double juro) {
        this.rendimentos(juro);
    }
}
