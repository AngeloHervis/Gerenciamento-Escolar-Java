package models;

import java.time.LocalDate;

public class Aula {
    private int id;
    private Turma turma;
    private Materia materia;
    private Professor professor;
    private LocalDate horario;
    private String descricao;
    
    public Aula(int id, Turma turma, Materia materia, Professor professor, LocalDate horario, String descricao) {
        this.id = id;
        this.turma = turma;
        this.materia = materia;
        this.professor = professor;
        this.horario = horario;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
