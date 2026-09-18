package banco;
import java.util.Scanner;


public class Gerente extends Pessoa {
    String matricula;
    String senha;

    Gerente(){
        super();
        Scanner s = new Scanner(System.in);

        System.out.print("Digite a matrícula: ");
        this.matricula = s.nextLine();
        System.out.print("Digite a senha: ");
        this.senha = s.nextLine();
    }
    Gerente(String nome, String cpf, Data data, char sexo, String matricula, String senha) {
        super(nome, cpf, data, sexo);
        this.matricula = matricula;
        this.senha = senha;
    }

    boolean validarSenha(String senhaInformada) {
        return this.senha.equals(senhaInformada);
    }
    boolean validarAcesso() {
        Scanner s = new Scanner(System.in);
        System.out.print("Informe a Senha: ");
        String senhaInformada = s.nextLine();
        return this.validarSenha(senhaInformada);
    }
}
