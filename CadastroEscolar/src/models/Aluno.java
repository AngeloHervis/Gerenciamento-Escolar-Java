package models;

public class Aluno extends Pessoa {
    private int matricula;
    private Turma turma;


    public Aluno(String nome, int idade, int matricula, Turma turma) {
        super(nome, idade); 
        this.matricula = matricula;
        this.turma = turma;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
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
        return "ID: " + id +
               "\nNome: " + nome +
               "\nIdade: " + idade +
               "\nMatrícula: " + matricula +
               "\nTurma: " + (turma != null ? turma.getNome() : "Não associada");
    }
}
