package crud;

import java.util.ArrayList;
import java.util.List;

import models.Materia;

public class MateriaCrud {
    private List<Materia> materias = new ArrayList<>();

    public void cadastrarMateria(Materia materia) {
        materias.add(materia);
    }

    public List<Materia> listarMaterias() {
        return materias;
    }

    public Materia buscarMateriaPorId(int id) {
        for (Materia materia : materias) {
            if (materia.getId() == id) {
                return materia;
            }
        }
        return null;
    }

    public void atualizarMateria(Materia materiaAtualizada) {
        Materia materia = buscarMateriaPorId(materiaAtualizada.getId());
        if (materia != null) {
            materia.setNome(materiaAtualizada.getNome());
            materia.setDescricao(materiaAtualizada.getDescricao());
        }
    }

    public void deletarMateria(int id) {
        Materia materia = buscarMateriaPorId(id);
        if (materia != null) {
            materias.remove(materia);
        }
    }
}

