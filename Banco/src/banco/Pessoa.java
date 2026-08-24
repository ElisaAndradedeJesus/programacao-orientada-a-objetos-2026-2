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

    int idade(Data hoje) {

        int diff = hoje.ano - this.dataNascimento.ano;

        if (this.dataNascimento.mes < hoje.mes ) {
            return diff;
        }
        if (this.dataNascimento.mes > hoje.mes) {
            return diff - 1;
        }
        if (this.dataNascimento.dia < hoje.dia) {
            return diff;
        }
        return diff - 1;
    }
}

