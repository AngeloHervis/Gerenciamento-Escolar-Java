package models;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private int id;
    private int proximoId = 1;
    private String nome;
    private String descricao;
    private List <Professor> professores;
    
    public Materia(int id, String nome, String descricao) {
        this.id = proximoId++;
        this.nome = nome;
        this.descricao = descricao;
        this.professores = new ArrayList<>();
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public List<Professor> getprofessores() {return professores;}

    public void setprofessores(List<Professor> professores) {this.professores = professores;}
}
