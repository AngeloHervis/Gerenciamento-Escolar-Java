package views;

import java.util.List;

import controllers.AulaController;
import models.Aula;

public class AulaView {
    private AulaController aulaController;

    public AulaView(AulaController aulaController) {
        this.aulaController = aulaController;
    }

    public void exibirDetalhesAula(Aula aula) {
        System.out.println("Detalhes da aula:");
        System.out.println("ID: " + aula.getId());
        System.out.println("Professor: " + aula.getProfessor());
        System.out.println("Matéria : " + aula.getMateria());
        System.out.println("Turma" + aula.getTurma());
        System.out.println("Horário : " + aula.getHorario());
    }

    public void exibirListaAulas(List<Aula> aulas) {
        System.out.println("Lista de aulas:");
        for (Aula aula : aulas) {
        System.out.println("ID: " + aula.getId());
        System.out.println("Professor: " + aula.getProfessor());
        System.out.println("Matéria : " + aula.getMateria());
        System.out.println("Turma" + aula.getTurma());
        System.out.println("Horário : " + aula.getHorario());
        }
    }
}
