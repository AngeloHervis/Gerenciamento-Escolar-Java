package crud;

import models.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoCrud {
    private List<Aluno> alunos = new ArrayList<>();

    public void cadastrarAluno(Aluno aluno) throws Exception {
        if (buscarAlunoPorNome(aluno.getNome()) != null) {
            throw new Exception("Aluno com o nome " + aluno.getNome() + " já está cadastrado.");
        }
        alunos.add(aluno);
    }

    private Aluno buscarAlunoPorNome(String nome) {
        return alunos.stream()
            .filter(a -> a.getNome().trim().equalsIgnoreCase(nome.trim()))
            .findFirst()
            .orElse(null);
    }

    public List<Aluno> listarAlunos() throws Exception {
        if (alunos.isEmpty()) {
            throw new Exception("Não há nenhum aluno cadastrado.");
        }
        return alunos;
    }

    public Aluno buscarAlunoPorId(int id) throws Exception {
        Aluno alunoEncontrado = alunos.stream()
            .filter(a -> a.getId() == id)
            .findFirst()
            .orElse(null);
        if (alunoEncontrado == null) {
            throw new Exception("Aluno com o id: " + id + " não foi encontrado.");
        }
        return alunoEncontrado;
    }

    public void atualizarAluno(Aluno alunoAtualizado) throws Exception {
        Aluno aluno = buscarAlunoPorId(alunoAtualizado.getId());
        if (aluno != null) {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setIdade(alunoAtualizado.getIdade());
            aluno.setMatricula(alunoAtualizado.getMatricula());
            aluno.setTurma(alunoAtualizado.getTurma());
        }
    }

    public void deletarAluno(int id) throws Exception {
        Aluno aluno = buscarAlunoPorId(id);
        if (aluno != null) {
            alunos.remove(aluno);
        }
    }
}
