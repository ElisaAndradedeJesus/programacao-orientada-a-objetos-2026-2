package banco;

public class Banco {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.nome = "Elisa";
        p1.cpf = "123.456.789-00";
        p1.idade = 25;
        p1.sexo = "Feminino";

        Pessoa p2 = new Pessoa();
        p2.nome = "João";
        p2.cpf = "987.654.321-00";
        p2.idade = 30;
        p2.sexo = "Masculino";

        Conta c1 = new Conta();
        c1.numero = "12345-6";
        c1.titular = p1;
        c1.saldo = 1000.0; 
        c1.limite = 500.0;

        Conta c2 = new Conta();
        c2.numero = "98765-4";
        c2.titular = p2;
        c2.saldo = 2000.0;
        c2.limite = 1000.0;

        System.out.println("O dono da conta " + c1.numero + " é: " + c1.titular.nome);
        c1.extrato();
        c2.extrato();
    }
}
