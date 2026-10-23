
public class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;
    protected Data dtNasc;
    protected Data dtContr;


    // CONSTRUTORES
    Funcionario(String nome, String cpf, double salario, Data dtNasc, Data dtContr) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dtNasc = dtNasc;
        this.dtContr = dtContr;
    }

    //METODOS



    public void listarDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Salário: " + this.salario);
        System.out.println("Data de Nascimento: " + this.dtNasc);
        System.out.println("Data de Contratação: " + this.dtContr);
    }

}