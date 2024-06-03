package controllers;

import models.Turma;
import crud.TurmaCrud;

public class TurmaController{
    private TurmaCrud turmaCrud;

    public TurmaController(TurmaCrud turmaCrud) {
        this.turmaCrud = turmaCrud;
    }

    public void cadastrarTurma(Turma turma) {
        turmaCrud.cadastrarTurma(turma);
    }

    public void atualizarTurma(Turma turma) {
        turmaCrud.atualizarTurma(turma);
    }

    public void deletarTurma(int id) {
        turmaCrud.deletarTurma(id);
    }

    public Turma buscarTurmaPorId(int id) {
        return turmaCrud.buscarTurmaPorId(id);
    }
}

