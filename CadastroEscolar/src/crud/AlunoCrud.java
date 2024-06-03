package crud;

import models.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoCrud {
    private List<Aluno> alunos = new ArrayList<>();

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    public Aluno buscarAlunoPorId(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    public void atualizarAluno(Aluno alunoAtualizado) {
        Aluno aluno = buscarAlunoPorId(alunoAtualizado.getId());
        if (aluno != null) {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setIdade(alunoAtualizado.getIdade());
            aluno.setMatricula(alunoAtualizado.getMatricula());
            aluno.setTurma(alunoAtualizado.getTurma());
        }
    }

    public void deletarAluno(int id) {
        Aluno aluno = buscarAlunoPorId(id);
        if (aluno != null) {
            alunos.remove(aluno);
        }
    }
}
