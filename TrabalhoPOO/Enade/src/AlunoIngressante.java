public class AlunoIngressante extends Aluno {
    private int semIngresso;
    
    AlunoIngressante(String nome, String matricula, int semIngresso) {
        super(nome, matricula);
        this.semIngresso = semIngresso;
    }
    @Override 
    public String toString() {
        return super.toString() + " - INGRESSANTE";
    }
    
    // Getters e Setters=======================================================================================
    public int getSemIngresso() {
        return semIngresso;     
    }

}
