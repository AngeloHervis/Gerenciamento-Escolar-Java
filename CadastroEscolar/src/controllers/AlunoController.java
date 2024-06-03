package controllers;

import models.Aluno;
import crud.AlunoCrud;

public class AlunoController {
    private AlunoCrud alunoCrud;

    public AlunoController(AlunoCrud alunoCrud) {
        this.alunoCrud = alunoCrud;
    }

    public void cadastrarAluno(Aluno aluno) {
        alunoCrud.cadastrarAluno(aluno);
    }

    public void atualizarAluno(Aluno aluno) {
        alunoCrud.atualizarAluno(aluno);
    }

    public void deletarAluno(int id) {
        alunoCrud.deletarAluno(id);
    }

    public Aluno buscarAlunoPorId(int id) {
        return alunoCrud.buscarAlunoPorId(id);
    }
}
