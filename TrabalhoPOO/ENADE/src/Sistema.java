import java.util.ArrayList;

public class Sistema {
    private ArrayList<Area> areas = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();

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
        for (Curso curso : cursos) {
            if (curso.getConceito() == conceito) {
                System.out.println("Curso: " + curso.getNome() + ", Área: " + curso.getArea().getNome());
            }
    }
}
