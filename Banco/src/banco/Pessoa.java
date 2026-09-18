package banco;
import java.util.Scanner;


public class Pessoa {
    String nome;
    String cpf;
    Data dataNascimento;
    char sexo;

    Pessoa() {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        this.nome = s.nextLine();
        System.out.print("Digite o CPF: ");
        this.cpf = s.nextLine();
        System.out.println("Digite a data de nascimento: ");
        this.dataNascimento = new Data();
        System.out.print("Digite o sexo: ");
        this.sexo = s.nextLine().charAt(0);
        System.out.println("Pessoa cadastrada com sucesso!"); 
    }

    Pessoa(String n, String c, Data d, char s) {
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
        if (his.dataNascimento.dia <= hoje.dia) {
            return diff;
        }
        return diff - 1;
    }
}

