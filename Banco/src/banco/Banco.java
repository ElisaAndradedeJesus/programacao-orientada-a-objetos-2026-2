package banco;

public class Banco {
    public static void main(String[] args) {
        Data data1 = new Data(15, 3, 1990);
        Data data2 = new Data(20, 7, 1985);
        
        Pessoa p1 = new Pessoa("Elisa", "123.456.789-00", data1, "F");
        Pessoa p2 = new Pessoa("João", "987.654.321-00", data2, "M");

        Conta c1 = new Conta("12345-6", p1, 500.0);
        Conta c2 = new Conta("98765-4", p2, 1000.0);

        System.out.println("Data de nascimento de " + p1.nome + ": ");
        data1.exibirData();

        System.out.println("Data de nascimento de " + p2.nome + ": ");
        data2.exibirData();

    //     System.out.println("O dono da conta " + c1.numero + " é: " + c1.titular.nome);
    //     c1.extrato();
    //     c2.extrato();

    //     c1.sacar(150);
    //     c1.transferir(c2, 100);
    //     c1.sacar(100);
    //     c1.depositar(100);
    //     c1.transferir(c2, 0);

    //     c1.sacar(800);
    //     for(int i = 1; i < 31; i++) {
    //         c1.chequeEspecial(0.5);
    //         System.out.println("Saldo após " + i + " dias: R$ " + c1.saldo);
    //     }
    }
}
