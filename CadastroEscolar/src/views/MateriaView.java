package views;

import java.util.List;

import controllers.MateriaController;
import models.Materia;

public class MateriaView {
    private MateriaController materiaController;

    public MateriaView(MateriaController materiaController) {
        this.materiaController = materiaController;
    }

    public void exibirDetalhesMateria(Materia materia) {
        System.out.println("Detalhes do Materia:");
        System.out.println("ID: " + materia.getId());
        System.out.println("Nome: " + materia.getNome());
        System.out.println("Descrição: " + materia.getDescricao());
        System.out.println("Professores : " + materia.getprofessores());

    }

    public void exibirListaMaterias(List<Materia> materias) {
        System.out.println("Lista de Materiaes:");
        for (Materia materia : materias) {
            System.out.println("ID: " + materia.getId() + ", Nome: " + materia.getNome());
        }
    }
}
