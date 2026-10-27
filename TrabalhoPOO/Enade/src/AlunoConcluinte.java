public class AlunoConcluinte extends Aluno {
    private double notaFormacaoGeral;
    private double notaComponenteEspecifico;//conhecimento específico
    private boolean presente;

    AlunoConcluinte(String nome, String matricula){
        super(nome, matricula);
    }

    public void cadastrarProva(double n1, double n2) {
        this.notaFormacaoGeral = n1;
        this.notaComponenteEspecifico = n2; //conhecimento específico
        this.presente = true; // Marca o aluno como presente na prova
    }

    public double calcularNota() {
        return (notaFormacaoGeral*3 + notaComponenteEspecifico*7) / 10;
    }

    @Override
    public boolean regular() {
        
        return super.regular() && this.presente;
    }
    @Override 
    public String toString() {
        return super.toString() + " - CONCLUINTE";
    }

    // Getters e Setters=======================================================================================
    public boolean isPresente() {
        return this.presente;
    }

}
