package views;

import models.Professor;
import controllers.ProfessorController;
import java.util.List;

public class ProfessorView {
    private ProfessorController professorController;

    public ProfessorView(ProfessorController professorController) {
        this.professorController = professorController;
    }

    public void exibirDetalhesProfessor(Professor professor) {
        System.out.println("Detalhes do professor:");
        System.out.println("ID: " + professor.getId());
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Idade: " + professor.getIdade());
        System.out.println("Matéria que dá aula : " + professor.getMateria());

    }

    public void exibirListaprofessors(List<Professor> professores) {
        System.out.println("Lista de professores:");
        for (Professor professor : professores) {
            System.out.println("ID: " + professor.getId() + ", Nome: " + professor.getNome());
        }
    }
}
