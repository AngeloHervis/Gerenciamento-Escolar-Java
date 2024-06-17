package models;

public class Professor extends Pessoa {
    private Materia materia;

    public Professor(String nome, int idade, Materia materia) {
        super(nome, idade); 
        this.materia = materia;
    }


    public Materia getMateria() { return materia; }
    public void setMateria(Materia materia) { this.materia = materia; }
}
