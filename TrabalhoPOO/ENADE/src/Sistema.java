public class Sistema {
    private Area[] areas;
    private Curso[] cursos;
    private Aluno[] alunos;

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


}
