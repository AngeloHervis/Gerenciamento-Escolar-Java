package views;

import models.Aluno;
import controllers.AlunoController;
import java.util.List;

public class AlunoView {
    private AlunoController alunoController;

    public AlunoView(AlunoController alunoController) {
        this.alunoController = alunoController;
    }

    public void exibirDetalhesAluno(Aluno aluno) {
        System.out.println("Detalhes do Aluno:");
        System.out.println("ID: " + aluno.getId());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Turma: " + aluno.getTurma());
    }

    public void exibirListaAlunos(List<Aluno> alunos) {
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getId() + ", Nome: " + aluno.getNome());
        }
    }
}
