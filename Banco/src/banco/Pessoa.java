package banco;

public class Pessoa {
    String nome;
    String cpf;
    Data dataNascimento;
    String sexo;

    Pessoa() {
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    Pessoa(String n, String c, Data d, String s) {
        this.nome = n;
        this.cpf = c;
        this.dataNascimento = d;
        this.sexo = s;
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    int idade() {
        int anoAtual = 2024; // Substitua pelo ano atual
        return anoAtual - this.dataNascimento.ano;
    }
}

