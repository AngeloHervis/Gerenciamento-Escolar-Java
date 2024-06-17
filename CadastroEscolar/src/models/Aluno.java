package models;

public class Aluno extends Pessoa {
    private String matricula;
    private Turma turma;


    public Aluno(String nome, int idade, String matricula, Turma turma) {
        super(nome, idade); 
        this.matricula = matricula;
        this.turma = turma;
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + "\nMatrícula: " + matricula + "\nTurma: " + turma.getNome();
    }
}
