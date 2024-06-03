package models;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int id;
    private String nome;
    private String descricao;
    private List <Aluno> alunos;

    // Construtor
    public Turma(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.alunos = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Aluno> getAlunos() {return alunos;}

    public void setAlunos(List<Aluno> alunos) {this.alunos = alunos;}
}
