package crud;

import java.util.ArrayList;
import java.util.List;
import models.Materia;
import util.Log; 

public class MateriaCrud {
    private List<Materia> materias = new ArrayList<>();

    public void cadastrarMateria(Materia materia) throws Exception {
        if (buscarMateriaPorNome(materia.getNome()) != null) {
            throw new Exception("Matéria com o nome " + materia.getNome() + " já está cadastrada.");
        }
        materias.add(materia);
        registrarLog("Matéria cadastrada: " + materia.getNome());
    }

    private Materia buscarMateriaPorNome(String nome) {
        return materias.stream()
            .filter(m -> m.getNome().trim().equalsIgnoreCase(nome.trim()))
            .findFirst()
            .orElse(null);
    }

    public List<Materia> listarMaterias() throws Exception {
        if (materias.isEmpty()) {
            throw new Exception("Não há nenhuma matéria cadastrada.");
        }
        return materias;
    }

    public Materia buscarMateriaPorId(int id) throws Exception {
        Materia materiaEncontrada = materias.stream()
            .filter(m -> m.getId() == id)
            .findFirst()
            .orElse(null);
        if (materiaEncontrada == null) {
            throw new Exception("Matéria com o id: " + id + " não foi encontrada.");
        }
        return materiaEncontrada;
    }

    public void atualizarMateria(Materia materiaAtualizada) throws Exception {
        Materia materia = buscarMateriaPorId(materiaAtualizada.getId());
        if (materia != null) {
            materia.setNome(materiaAtualizada.getNome());
            materia.setDescricao(materiaAtualizada.getDescricao());
            registrarLog("Matéria atualizada: " + materia.getNome());
        }
    }

    public void deletarMateria(int id) throws Exception {
        Materia materia = buscarMateriaPorId(id);
        if (materia != null) {
            materias.remove(materia);
            registrarLog("Matéria removida: " + materia.getNome());
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
