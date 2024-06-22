package crud;

import models.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorCrud {
    private List<Professor> professores = new ArrayList<>();

    public void cadastrarProfessor(Professor professor) throws Exception {
        if (buscarProfessorPorNome(professor.getNome()) != null) {
            throw new Exception("Professor com o nome " + professor.getNome() + " já está cadastrado.");
        }
        professores.add(professor);
    }

    private Professor buscarProfessorPorNome(String nome) {
        return professores.stream()
            .filter(p -> p.getNome().trim().equalsIgnoreCase(nome.trim()))
            .findFirst()
            .orElse(null);
    }

    public List<Professor> listarProfessores() throws Exception {
        if (professores.isEmpty()) {
            throw new Exception("Não há nenhum professor cadastrado.");
        }
        return professores;
    }

    public Professor buscarProfessorPorId(int id) throws Exception {
        Professor professorEncontrado = professores.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);
        if (professorEncontrado == null) {
            throw new Exception("Professor com o id: " + id + " não foi encontrado.");
        }
        return professorEncontrado;
    }

    public void atualizarProfessor(Professor professorAtualizado) throws Exception {
        Professor professor = buscarProfessorPorId(professorAtualizado.getId());
        if (professor != null) {
            professor.setNome(professorAtualizado.getNome());
            professor.setIdade(professorAtualizado.getIdade());
            professor.setMateria(professorAtualizado.getMateria());
        }
    }

    public void deletarProfessor(int id) throws Exception {
        Professor professor = buscarProfessorPorId(id);
        if (professor != null) {
            professores.remove(professor);
        }
    }
}
