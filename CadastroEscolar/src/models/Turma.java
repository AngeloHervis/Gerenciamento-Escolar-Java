package models;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int id;
    private String nome;
    private String descricao;
    private List<Aluno> alunos;

    public Turma(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.alunos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void adicionarAlunos(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }

    public void adicionarAlunos(Aluno... alunos) {
        for (Aluno aluno : alunos) {
            this.alunos.add(aluno);
        }
    }

    public boolean removerAluno(Aluno aluno) {
        return this.alunos.remove(aluno);
    }

    public boolean removerAlunoPorId(int alunoId) {
        return this.alunos.removeIf(aluno -> aluno.getId() == alunoId);
    }
}
