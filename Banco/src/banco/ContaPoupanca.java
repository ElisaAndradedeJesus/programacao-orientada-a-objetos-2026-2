package banco;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Gerente gerente) {
        super(gerente);
    }
    ContaPoupanca(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        super(numero, titular, criacao, gerente);
    }
    ContaPoupanca(Pessoa titular, Gerente gerente, Data criacao) {
        super(titular, gerente, criacao);
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
