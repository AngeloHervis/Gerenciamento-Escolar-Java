package controllers;

import crud.MateriaCrud;
import models.Materia;

public class MateriaController {
     private MateriaCrud materiaCrud;

    public MateriaController(MateriaCrud materiaCrud) {
        this.materiaCrud = materiaCrud;
    }

    public void cadastrarMateria(Materia materia) {
        materiaCrud.cadastrarMateria(materia);
    }

    public void atualizarMateria(Materia materia) {
        materiaCrud.atualizarMateria(materia);
    }

    public void deletarMateria(int id) {
        materiaCrud.deletarMateria(id);
    }

    public Materia buscarMateriaPorId(int id) {
        return materiaCrud.buscarMateriaPorId(id);
    }
}
