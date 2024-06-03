import models.Aluno;
import models.Aula;
import models.Professor;
import models.Turma;
import models.Materia;
import models.OutroFuncionario;
import crud.AlunoCrud;
import crud.MateriaCrud;
import crud.ProfessorCrud;
import crud.TurmaCrud;
import crud.OutroFuncionarioCrud;
import crud.AulaCrud;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import controllers.AlunoController;
import controllers.AulaController;
import controllers.MateriaController;
import controllers.ProfessorController;
import controllers.OutroFuncionarioController;
import controllers.TurmaController;
import views.AlunoView;
import views.MateriaView;
import views.ProfessorView;
import views.TurmaView;
import views.OutroFuncionarioView;
import views.AulaView;


public class Main {
    public static void main(String[] args) {
        AlunoCrud alunoCRUD = new AlunoCrud();
        ProfessorCrud professorCRUD = new ProfessorCrud();
        TurmaCrud turmaCRUD = new TurmaCrud();
        MateriaCrud materiaCrud = new MateriaCrud();
        OutroFuncionarioCrud outroFuncionarioCrud = new OutroFuncionarioCrud();
        AulaCrud aulaCrud = new AulaCrud();
        AlunoController alunoController = new AlunoController(alunoCRUD);
        AlunoView alunoView = new AlunoView(alunoController);
        ProfessorController professorController = new ProfessorController(professorCRUD);
        ProfessorView professorView = new ProfessorView(professorController);
        TurmaController turmaController = new TurmaController(turmaCRUD);
        TurmaView turmaView = new TurmaView(turmaController);
        MateriaController materiaController = new MateriaController(materiaCrud);
        MateriaView materiaView = new MateriaView(materiaController);
        OutroFuncionarioController outroFuncionarioController = new OutroFuncionarioController(outroFuncionarioCrud);
        OutroFuncionarioView outroFuncionarioView = new OutroFuncionarioView(outroFuncionarioController);
        AulaController aulaController = new AulaController(aulaCrud);
        AulaView aulaView = new AulaView(aulaController);


        // Criar e adicionar alguns funcionários
        outroFuncionarioController.cadastrarOutroFuncionario(new OutroFuncionario(1, "Diogo", 40, "Diretor"));
        outroFuncionarioController.cadastrarOutroFuncionario(new OutroFuncionario(2, "Zeca", 25, "Segurança"));
        
        OutroFuncionario outroFuncionario = outroFuncionarioController.buscarOutroFuncionarioPorId(1);
        outroFuncionarioView.exibirDetalhesOutroFuncionario(outroFuncionario);

        // Atualizar Funcionário
        OutroFuncionario outroFuncionarioAtualizado = new OutroFuncionario(1, "Pablo", 56, "Diretor");
        outroFuncionarioController.atualizarOutroFuncionario(outroFuncionarioAtualizado);

        // Exibir detalhes do funcionário atualizado
        outroFuncionario = outroFuncionarioController.buscarOutroFuncionarioPorId(2);
        outroFuncionarioView.exibirDetalhesOutroFuncionario(outroFuncionario);

        // Deletar turma
        outroFuncionarioController.deletarOutroFuncionario(2);


        // Criar e adicionar algumas turmas
        turmaController.cadastrarTurma(new Turma(1, "Turma A", "Turma do Terceiro ano"));
        turmaController.cadastrarTurma(new Turma(2, "Turma B", "Turma do Quarto ano"));
        
        Turma turma = turmaController.buscarTurmaPorId(1);
        turmaView.exibirDetalhesTurma(turma);

        // Atualizar turma
        Turma turmaAtualizada = new Turma(2, "Turma B", "Turma do Quinto ano");
        turmaController.atualizarTurma(turmaAtualizada);

        // Exibir detalhes do aluno atualizado
        turma = turmaController.buscarTurmaPorId(2);
        turmaView.exibirDetalhesTurma(turma);

        // Deletar turma
        turmaController.deletarTurma(2);

       

        // Listar turmas
        System.out.println("Lista de Turmas:");
        for (Turma turmas : turmaCRUD.listarTurmas()) {
            System.out.println(turmas.getNome());
        }


        //Cadastrando alunos
        alunoController.cadastrarAluno(new Aluno(1, "João", 20, "2024001", turma));
        alunoController.cadastrarAluno(new Aluno(2, "Maria", 22, "2024002", turmaAtualizada));


        // Buscar aluno por ID e exibir detalhes
        Aluno aluno = alunoController.buscarAlunoPorId(1);
        alunoView.exibirDetalhesAluno(aluno);

        // Atualizar aluno
        Aluno alunoAtualizado = new Aluno(1, "João Silva", 21, "2024001", turma);
        alunoController.atualizarAluno(alunoAtualizado);

        // Exibir detalhes do aluno atualizado
        aluno = alunoController.buscarAlunoPorId(1);
        alunoView.exibirDetalhesAluno(aluno);

        // Deletar aluno
        alunoController.deletarAluno(2);

        // Criar e adicionar algumas materias
        materiaController.cadastrarMateria(new Materia(1, "Ciências", "Matéria de Ciências"));
        materiaController.cadastrarMateria(new Materia(2, "Matemática", "Matéria de Matemática"));
        
        Materia materia = materiaController.buscarMateriaPorId(1);
        materiaView.exibirDetalhesMateria(materia);

        // Atualizar matéria
        Materia materiaAtualizada = new Materia(1, "Geografia", "Matéria de Geografia");
        materiaController.atualizarMateria(materiaAtualizada);

        // Exibir detalhes da matéria atualizada
        materia = materiaController.buscarMateriaPorId(2);
        materiaView.exibirDetalhesMateria(materia);

        // Deletar matéria
        materiaController.deletarMateria(2);

         // Criar e adicionar alguns professores
        professorController.cadastrarProfessor(new Professor(1, "Carlos", 20, materia));
        professorController.cadastrarProfessor(new Professor(2, "Tereza", 75, materia));

        // Buscar professor por ID e exibir detalhes
        Professor professor = professorController.buscarProfessorPorId(1);
        professorView.exibirDetalhesProfessor(professor);
         
        // Atualizar professor
        Professor professorAtualizado = new Professor(2, "Sonia", 42, materia);
        professorController.atualizarProfessor(professorAtualizado);

        // Exibir detalhes do professor atualizado
        professor = professorController.buscarProfessorPorId(2);
        professorView.exibirDetalhesProfessor(professor);

        // Deletar professor
        professorController.deletarProfessor(2);

        String dataString = "2023-03-23";
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ISO_LOCAL_DATE);
        // Criar e adicionar algumas aulas
        aulaController.cadastrarAula(new Aula(1, turmaAtualizada, materiaAtualizada, professorAtualizado, data, "Aula 1"));
        aulaController.cadastrarAula(new Aula(2, turma, materia, professor, data, "Aula 2"));
       
        Aula aula = aulaController.buscarAulaPorId(1);
        aulaView.exibirDetalhesAula(aula);

        // Atualizar matéria
        Aula aulaAtualizada = new Aula(1, turma, materia, professor, data, "Aula Atualizada");
        aulaController.atualizarAula(aulaAtualizada);

        // Exibir detalhes da matéria atualizada
        aula = aulaController.buscarAulaPorId(2);
        aulaView.exibirDetalhesAula(aula);

        // Deletar turma
        aulaController.deletarAula(2);
    }
}
