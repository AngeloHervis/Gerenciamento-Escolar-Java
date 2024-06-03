package models;

public class Aluno extends Pessoa {
    private String matricula;
    private Turma turma;

    // Construtor
    public Aluno(int id, String nome, int idade, String matricula, Turma turma) {
        super(id, nome, idade); // Chama o construtor da superclasse
        this.matricula = matricula;
        this.turma = turma;
    }

    // Getters e Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }
}
