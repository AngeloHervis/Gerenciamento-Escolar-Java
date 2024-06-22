package crud;

import models.Turma;
import util.Log;

import java.util.ArrayList;
import java.util.List;

public class TurmaCrud {
    private List<Turma> turmas = new ArrayList<>();

    public void cadastrarTurma(Turma turma) throws Exception {
        if (buscarTurmaPorNome(turma.getNome()) != null) {
            throw new Exception("Turma com o nome " + turma.getNome() + " já está cadastrada.");
        }
        turmas.add(turma);
        registrarLog("Turma cadastrada: " + turma.getNome());
    }

    private Turma buscarTurmaPorNome(String nome) {
        return turmas.stream()
                .filter(t -> t.getNome().trim().equalsIgnoreCase(nome.trim()))
                .findFirst()
                .orElse(null);
    }

    public List<Turma> listarTurmas() throws Exception {
        if (turmas.isEmpty()) {
            throw new Exception("Não há nenhuma turma cadastrada.");
        }
        return turmas;
    }

    public Turma buscarTurmaPorId(int id) throws Exception {
        Turma turmaEncontrada = turmas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
        if (turmaEncontrada == null) {
            throw new Exception("Turma com o id: " + id + " não foi encontrada.");
        }
        return turmaEncontrada;
    }

    public void atualizarTurma(Turma turmaAtualizada) throws Exception {
        Turma turma = buscarTurmaPorId(turmaAtualizada.getId());
        if (turma != null) {
            turma.setNome(turmaAtualizada.getNome());
            turma.setDescricao(turmaAtualizada.getDescricao());
            registrarLog("Turma atualizada: " + turma.getNome());
        }
    }

    public void deletarTurma(int id) throws Exception {
        Turma turma = buscarTurmaPorId(id);
        if (turma != null) {
            turmas.remove(turma);
            registrarLog("Turma removida: " + turma.getNome());
        }
    }

    private void registrarLog(String mensagem) {
        try {
            List<String> logs = new ArrayList<>();
            logs.add(mensagem);
            Log.salvar(logs, "log");
        } catch (Exception e) {
            System.err.println("Erro ao salvar log: " + e.getMessage());
        }
    }
}
