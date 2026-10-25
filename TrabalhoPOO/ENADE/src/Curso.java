import java.util.ArrayList;

public class Curso {
    private String codigo;
    private String nome;
    private ArrayList<Aluno> alunos;

    Curso(String nome, String codigo) {
        this.codigo = codigo;
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }


    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    @Override 
    public String toString(){
        return this.nome + " - " + this.codigo;
    }

    public double calcularMedia() {
        double soma = 0;
        int quantidade = 0;

        for (Aluno aluno : this.alunos) {
            if (aluno instanceof AlunoConcluinte concluinte) {
                soma += concluinte.calcularNota();
                quantidade++;
            }
        }

        if (quantidade == 0) {
            return 0.0;
        }
        return soma / quantidade;
    }
    
    public int calcularConceito() {
        // Lógica para calcular o conceito da área com base nas notas dos alunos
        return 1;
    }
    public AlunoIngressante[] ingressantes() {
        // Lógica para retornar um array de alunos ingressantes da área
        return null;
    }
    public AlunoIngressante[] ingressantes(int semestre) {
        
        return null;
    }

    // Getters e Setters=======================================================================================
    public String getCodigo() {
        return codigo;  
    }
    public String getNome() {
        return nome;  
    }
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    
}
