package controllers;

import java.util.List;

import crud.AulaCrud;
import models.Aula;

public class AulaController {
    private AulaCrud aulaCrud;

    public AulaController(AulaCrud aulaCrud) {
        this.aulaCrud = aulaCrud;
    }

    public void cadastrarAula(Aula aula) {
        aulaCrud.cadastrarAula(aula);
    }

    public void atualizarAula(Aula aula) {
        aulaCrud.atualizarAula(aula);
    }

    public void deletarAula(int id) {
        aulaCrud.deletarAula(id);
    }

    public Aula buscarAulaPorId(int id) {
        return aulaCrud.buscarAulaPorId(id);
    }

    public List<Aula> listarAulas(){
        return aulaCrud.listarAulas();
    }
}
