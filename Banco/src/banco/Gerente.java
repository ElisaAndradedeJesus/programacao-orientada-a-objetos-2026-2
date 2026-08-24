package banco;

public class Gerente extends Pessoa {
    String matricula;
    String senha;

    Gerente(String nome, String cpf, Data data, String sexo, String matricula, String senha) {
        super(nome, cpf, data, sexo);
        this.matricula = matricula;
        this.senha = senha;
    }

    boolean validarAcesso(String senha) {
        return this.senha.equals(senha);
    }
}
