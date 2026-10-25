public class Aluno {
    private String nome;
    private String matricula;
    private boolean questionarioRespondido;

    Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.questionarioRespondido = false; // Inicialmente, o questionário não foi respondido
    }

    public boolean regular(){
        return questionarioRespondido;
    }

    public void cadastrarResposta(){
        this.questionarioRespondido = true;
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.matricula + ")";
    }

    // Getters e Setters=======================================================================================
    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }
}
