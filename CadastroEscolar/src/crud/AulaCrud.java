package crud;

import models.Aula;
import java.util.ArrayList;
import java.util.List;

public class AulaCrud {
    private List<Aula> aulas = new ArrayList<>();

    public void cadastrarAula(Aula aula) {
        aulas.add(aula);
    }

    public List<Aula> listarAulas() throws Exception {
        if (aulas.isEmpty()) {
            throw new Exception("Não há nenhuma aula cadastrada.");
        }
        return aulas;
    }

    public Aula buscarAulaPorId(int id) throws Exception {
        Aula aulaEncontrada = aulas.stream()
            .filter(a -> a.getId() == id)
            .findFirst()
            .orElse(null);
        if (aulaEncontrada == null) {
            throw new Exception("Aula com o id: " + id + " não foi encontrada.");
        }
        return aulaEncontrada;
    }

    public void atualizarAula(Aula aulaAtualizada) throws Exception {
        Aula aula = buscarAulaPorId(aulaAtualizada.getId());
        if (aula != null) {
            aula.setTurma(aulaAtualizada.getTurma());
            aula.setProfessor(aulaAtualizada.getProfessor());
            aula.setDiaDeAula(aulaAtualizada.getDiaDeAula());
            aula.setHorario(aulaAtualizada.getHorario());
            aula.setDescricao(aulaAtualizada.getDescricao());
        }
    }

    public void deletarAula(int id) throws Exception {
        Aula aula = buscarAulaPorId(id);
        if (aula != null) {
            aulas.remove(aula);
        }
    }
}
