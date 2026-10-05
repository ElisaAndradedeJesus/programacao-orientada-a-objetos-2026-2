package banco;


public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(Gerente gerente) {
        super(gerente);
        this.limiteChequeEspecial = 200;
    }
    public ContaCorrente(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        super(numero, titular, criacao, gerente);
        this.limiteChequeEspecial = 200;
    }

    @Override
    protected double disponivel() {
        return this.saldo + this.limiteChequeEspecial;
    }

    @Override
    public void extrato() {
        System.out.println("*** EXTRATO DA CONTA CORRENTE ***");
        super.extrato();
    }

    public void chequeEspecial(double taxa) {
        if (this.saldo < 0) {
            this.saldo = this.saldo + (taxa * this.saldo) / 100;
        }
    }

    // Getters and Setters
    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
    public void alterarLimite(String senhaGerente, double novoLimite) {
        if (!this.getGerente().validarAcesso(senhaGerente)) {
            System.out.println("Senha incorreta. O limite não foi alterado.");
        } else if (!Double.isFinite(novoLimite) || novoLimite < 0) {
            System.out.println("Limite inválido.");
        } else {
            this.limiteChequeEspecial = novoLimite;
            System.out.println("Limite do cheque especial alterado com sucesso!");
        }
    }

    public void alterarLimite() {
        System.out.print("Digite a senha do gerente: ");
        String senha = Entrada.scanner.nextLine();
        double limite = Entrada.lerDecimal("Digite o novo limite: ");
        this.alterarLimite(senha, limite);
    }

    public void setLimiteChequeEspecial(String senhaGerente, double limite) {
        this.alterarLimite(senhaGerente, limite);
    }
}
