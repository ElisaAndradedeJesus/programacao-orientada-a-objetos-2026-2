import java.util.ArrayList;

public class Sistema {
    private ArrayList<Area> areas;
    private ArrayList<Curso> cursos;
    private ArrayList<Aluno> alunos ;

    public void cadastrarArea(Area area) {
        this.areas.add(area);
    }

    public void cadastrarCurso(Curso curso, Area area) {
        area.adicionarCurso(curso);
        this.cursos.add(curso);
    }

    public void cadastrarAluno(Aluno aluno, Curso curso) {
        curso.adicionarAluno(aluno);
        this.alunos.add(aluno);
    }

    public void listarResultados(int conceito){
        System.out.println("Cursos com conceito " + conceito + ":");
        //fazendo esse trem
    }
}
