package crud;

import java.util.ArrayList;
import java.util.List;

import models.Aula;

public class AulaCrud {
    private List<Aula> aulas = new ArrayList<>();

    public void cadastrarAula(Aula aula) {
        aulas.add(aula);
    }

    public List<Aula> listarAulas() {
        return aulas;
    }

    public Aula buscarAulaPorId(int id) {
        for (Aula Aula : aulas) {
            if (Aula.getId() == id) {
                return Aula;
            }
        }
        return null;
    }

    public void atualizarAula(Aula aulaAtualizada) {
        Aula Aula = buscarAulaPorId(aulaAtualizada.getId());
        if (Aula != null) {
            Aula.setDescricao(aulaAtualizada.getDescricao());
        }
    }

    public void deletarAula(int id) {
        Aula Aula = buscarAulaPorId(id);
        if (Aula != null) {
            aulas.remove(Aula);
        }
    }
}
