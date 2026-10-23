import java.util.ArrayList;
public class Empresa {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Gerente> gerentes;

    // CONSTRUTOR
    public Empresa() {
        this.funcionarios = new ArrayList<>();
        this.gerentes = new ArrayList<>();
    }

    //METODOS
    public void folhaPagamento() {
        //A fazer
    }

    public void inserirFuncionario(){
        //a fazer
    }
    public void InserirGerente(){
        //a fazer
    }
    public Funcionario funcionarioMaisAntigo() {
        return null;
    }

    public Funcionario funcionarioMaisVelho(){
        return null;
    }
    public Funcionario localizarFuncionario(String cpf){
        return null;
    } 
    public Gerente localizarGerente(String cpf){
        return null;
    }
    public void atribuirFuncGer(Gerente gerente, Funcionario funcionario){
        //a fazer
    }

}
