package banco;

public class Banco {
    public static void main(String[] args) {
        System.out.println("Cadastre os dois gerentes (senha inicial: 123456).");
        Gerente gerente1 = new Gerente();
        Gerente gerente2 = new Gerente();

        // Cada conta solicita os dados de um novo titular: quatro pessoas.
        System.out.println("Cadastre as duas contas correntes.");
        ContaCorrente c1 = new ContaCorrente(gerente1);
        ContaCorrente c2 = new ContaCorrente(gerente2);
        System.out.println("Cadastre as duas poupanças.");
        Poupanca p1 = new Poupanca(gerente1);
        Poupanca p2 = new Poupanca(gerente2);

        c1.depositar(100);
        c2.depositar(200);
        p1.depositar(300);
        p2.depositar(400);

        c1.sacar(150); // Usa parte do cheque especial.
        c2.sacar(50);
        p1.sacar(50);
        p2.sacar(50);

        c1.transferir(25, p1);
        c2.transferir(25, p2);
        p1.transferir(25, c1);
        p2.transferir(25, c2);

        c1.sacar(1000); // Deve recusar: ultrapassa o limite.
        p1.sacar(1000); // Deve recusar: poupança não tem limite.
        c1.alterarLimite("incorreta", 500); // Deve manter o limite em 200.
        c1.alterarLimite("123456", 300);

        c1.extrato();
        c2.extrato();
        p1.extrato();
        p2.extrato();
    }
}
