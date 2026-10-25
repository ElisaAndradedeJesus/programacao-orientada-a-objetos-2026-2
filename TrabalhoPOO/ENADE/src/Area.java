import java.util.ArrayList;

public class Area {
    private String codigo;
    private String nome;
    private ArrayList<Curso> cursos;

    Area(String nome,String codigo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cursos = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public String toString() {
        return this.nome + " - " + this.codigo;
    }

    // Getters e Setters=======================================================================================
    public String getCodigo() {
        return codigo;  
    }
    public String getNome() {
        return nome;  
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    
}
