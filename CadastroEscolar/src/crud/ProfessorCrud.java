package crud;

import models.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorCrud{
    private List<Professor> professores = new ArrayList<>();

    public void cadastrarProfessor(Professor professor) {
        professores.add(professor);
    }

    public List<Professor> listarProfessores() {
        return professores;
    }

    public Professor buscarProfessorPorId(int id) {
        for (Professor professor : professores) {
            if (professor.getId() == id) {
                return professor;
            }
        }
        return null;
    }

    public void atualizarProfessor(Professor professorAtualizado) {
        Professor professor = buscarProfessorPorId(professorAtualizado.getId());
        if (professor != null) {
            professor.setNome(professorAtualizado.getNome());
            professor.setIdade(professorAtualizado.getIdade());
            professor.setMateria(professorAtualizado.getMateria());
        }
    }

    public void deletarProfessor(int id) {
        Professor professor = buscarProfessorPorId(id);
        if (professor != null) {
            professores.remove(professor);
        }
    }
}
