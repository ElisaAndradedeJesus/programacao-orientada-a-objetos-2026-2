package banco;
import java.util.Scanner;


public class Gerente extends Pessoa {
    private String matricula;
    private String senha;

    Gerente(){
        super();
        Scanner s = Entrada.scanner;

        System.out.print("Digite a matrícula: ");
        this.matricula = s.nextLine();
        this.senha = "123456";
    }
    Gerente(String nome, String cpf, Data data, char sexo, String matricula, String senha) {
        super(nome, cpf, data, sexo);
        this.matricula = matricula;
        this.senha = senha;
    }

    public boolean validarAcesso(String senhaInformada) {
        return this.senha.equals(senhaInformada);
    }
    public boolean validarAcesso() {
        Scanner s = Entrada.scanner;
        System.out.print("Informe a Senha: ");
        String senhaInformada = s.nextLine();
        return this.validarAcesso(senhaInformada);
    }

    // Getters and Setters
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
  
    public void setSenha(String senhaAtual,String novaSenha) {
        if(this.validarAcesso(senhaAtual)){
            this.senha = novaSenha;
            System.out.println("Senha alterada com sucesso!");
        } else {
            System.out.println("Senha atual incorreta. A senha não foi alterada.");
        }
    }
}
