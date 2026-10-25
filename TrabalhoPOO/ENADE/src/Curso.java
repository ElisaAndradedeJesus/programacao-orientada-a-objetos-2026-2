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
        double media = calcularMedia();

        if (media < 2.0) return 1;
        if (media < 4.0) return 2;
        if (media < 6.0) return 3;
        if (media < 8.0) return 4;
        return 5;
    }


    public AlunoIngressante[] ingressantes() {
        ArrayList<AlunoIngressante> resultado = new ArrayList<>();

        for (Aluno aluno : this.alunos) {
            if (aluno instanceof AlunoIngressante ingressante) {
                resultado.add(ingressante);
            }
        }

        return resultado.toArray(new AlunoIngressante[0]);
    }

    public AlunoIngressante[] ingressantes(int semestre) {
        ArrayList<AlunoIngressante> resultado = new ArrayList<>();

        for (AlunoIngressante ingressante : ingressantes()) {
            if (ingressante.getSemIngresso() == semestre) {
                resultado.add(ingressante);
            }
        }

        return resultado.toArray(new AlunoIngressante[0]);
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
