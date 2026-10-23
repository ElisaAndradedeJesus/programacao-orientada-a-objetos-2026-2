import java.util.ArrayList;
public class Gerente extends Funcionario {
    private String senha;
    private ArrayList<Funcionario> equipe;

    public Gerente(String nome, String cpf, double salario, Data dtNasc, Data dtContr, String senha) {
        super(nome, cpf, salario, dtNasc, dtContr);
        this.senha = senha;
        this.equipe = new ArrayList<>();
    
    }

    @Override
    public void listarDados() {
        super.listarDados();
        System.out.println("Equipe:");
        this.listarEquipe();
    }

    public boolean validarAcesso(String senha) {
        return this.senha.equals(senha);
    }
    public void alterarSenha(String senhaAtual, String novaSenha) {
        if (this.senha.equals(senhaAtual)) {
            this.senha = novaSenha;
            System.out.println("Senha alterada com sucesso!");
        } else {
            System.out.println("Senha atual incorreta. A senha não foi alterada.");
        }
    }
    public double custoEquipe() {
        double custoTotal = 0;
        for (Funcionario f : equipe) {
            custoTotal += f.salario;
        }
        return custoTotal;
    }
    public void listarEquipe() {
        for (Funcionario f : equipe) {
            System.out.println("- " + f.nome);
        }
    }
    public void inserirFuncEquipe(Funcionario f) {
        this.equipe.add(f);
    }
    
}
