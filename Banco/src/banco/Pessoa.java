package banco;
import java.util.Scanner;


public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Data dataNascimento;
    protected char sexo;

    Pessoa() {
        Scanner s = Entrada.scanner;
        System.out.print("Digite o nome: ");
        this.nome = s.nextLine();
        System.out.print("Digite o CPF: ");
        this.cpf = s.nextLine();
        System.out.println("Digite a data de nascimento: ");
        this.dataNascimento = new Data();
        System.out.print("Digite o sexo: ");
        String sexoInformado = s.nextLine().trim();
        while (sexoInformado.isEmpty()) {
            System.out.print("Digite o sexo: ");
            sexoInformado = s.nextLine().trim();
        }
        this.sexo = sexoInformado.charAt(0);
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

        int diff = hoje.getAno() - this.dataNascimento.getAno();

        if (this.dataNascimento.getMes() < hoje.getMes() ) {
            return diff;
        }
        if (this.dataNascimento.getMes() > hoje.getMes()) {
            return diff - 1;
        }
        if (this.dataNascimento.getDia() <= hoje.getDia()) {
            return diff;
        }
        return diff - 1;
    }

    // Getters and Setters

    //Nome
    public String getNome() {
        return nome;        
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //CPF
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;     
    }

    //Data de Nascimento
    public Data getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;   
    }

    //Sexo
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}

