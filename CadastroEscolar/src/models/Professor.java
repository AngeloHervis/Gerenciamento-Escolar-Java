package models;

public class Professor extends Pessoa {
    private Materia materia;

    // Construtor
    public Professor(int id, String nome, int idade, Materia materia) {
        super(id, nome, idade); // Chama o construtor da superclasse
        this.materia = materia;
    }

    // Getters e Setters
    public Materia getMateria() { return materia; }
    public void setMateria(Materia materia) { this.materia = materia; }
}
