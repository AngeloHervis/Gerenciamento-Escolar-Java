package crud;

import models.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaCrud {
    private List<Turma> turmas = new ArrayList<>();

    public void cadastrarTurma(Turma turma) {
        turmas.add(turma);
    }

    public List<Turma> listarTurmas() {
        return turmas;
    }

    public Turma buscarTurmaPorId(int id) {
        for (Turma turma : turmas) {
            if (turma.getId() == id) {
                return turma;
            }
        }
        return null;
    }

    public void atualizarTurma(Turma turmaAtualizada) {
        Turma turma = buscarTurmaPorId(turmaAtualizada.getId());
        if (turma != null) {
            turma.setNome(turmaAtualizada.getNome());
            turma.setDescricao(turmaAtualizada.getDescricao());
        }
    }

    public void deletarTurma(int id) {
        Turma turma = buscarTurmaPorId(id);
        if (turma != null) {
            turmas.remove(turma);
        }
    }
}
