package crud;

import java.util.ArrayList;
import java.util.List;
import models.Materia;


public class MateriaCrud {
    private List<Materia> materias = new ArrayList<>();

    public void cadastrarMateria(Materia materia) throws Exception{
        if (buscarMateriaAdd(materia.getNome()) != null) {
            throw new Exception("Materia com o nome " + materia.getNome() + " já está cadastrada.");
        }
        materias.add(materia);
        
    }

    private Materia buscarMateriaAdd(String nome) throws Exception{
        return materias.stream()
        .filter(c -> c.getNome().trim().equalsIgnoreCase(nome.trim()))
        .findFirst()
        .orElse(null);
        
    }

    public List<Materia> listarMaterias() throws Exception {
        if (materias.isEmpty()) {
            throw new Exception("Não há nenhuma matéria cadastrada.");
        }
        return materias;
    }

    public Materia buscarMateriaId(int id) throws Exception{
        Materia materiaEncontrada = materias.stream().
        filter(c -> c.getId() == id).
        findFirst().
        orElse(null);
        if(materiaEncontrada == null){
            throw new Exception("Materia com o id: " + id + " não foi encontrada" );
        }
        return materiaEncontrada;
    }

    public void atualizarMateria(Materia materiaAtualizada) throws Exception{
        Materia materia = buscarMateriaId(materiaAtualizada.getId());
        if (materia != null) {
            materia.setNome(materiaAtualizada.getNome());
            materia.setDescricao(materiaAtualizada.getDescricao());
        }
    }

    public void deletarMateria(int id) throws Exception{
        Materia materia = buscarMateriaId(id);
        if (materia != null) {
            materias.remove(materia);
        }
    }
}

