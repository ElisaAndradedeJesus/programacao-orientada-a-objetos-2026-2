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

    public ArrayList<Curso> listarResultados(int conceito) {
        ArrayList<Curso> resultado = new ArrayList<>();

        for (Curso curso : cursos) {
            if (curso.calcularConceito() == conceito) {
                resultado.add(curso);
            }
        }

        return resultado;
    }

    public ArrayList<Curso> listarResultados(String nomeArea){
        ArrayList<Curso> resultado = new ArrayList<>();

        for (Area area : areas) {
            if (area.getNome().equalsIgnoreCase(nomeArea)) {
                resultado.addAll(area.getCursos());
            }
        }

        return resultado;
    }
}
