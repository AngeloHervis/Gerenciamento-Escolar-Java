package views;

import models.Turma;
import controllers.TurmaController;
import java.util.List;

public class TurmaView {
    private TurmaController turmaController;

    public TurmaView(TurmaController turmaController) {
        this.turmaController = turmaController;
    }

    public void exibirDetalhesTurma(Turma turma) {
        System.out.println("Detalhes do Turma:");
        System.out.println("ID: " + turma.getId());
        System.out.println("Nome: " + turma.getNome());
        System.out.println("Nome: " + turma.getDescricao());
    }

    public void exibirListaTurmas(List<Turma> turmas) {
        System.out.println("Lista de Turmaes:");
        for (Turma Turma : turmas) {
            System.out.println("ID: " + Turma.getId() + ", Nome: " + Turma.getNome() + "Descrição: " + Turma.getDescricao());
        }
    }
}
