package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import controllers.AulaController;
import controllers.MateriaController;
import controllers.ProfessorController;
import controllers.TurmaController;
import models.Aula;
import models.Materia;
import models.Professor;
import models.Turma;

public class AulaView {
    private AulaController aulaController;

    public AulaView(AulaController aulaController) {
        this.aulaController = aulaController;
    }

    public void exibirDetalhesAula(Aula aula) {
        System.out.println("Detalhes da aula:");
        System.out.println("ID: " + aula.getId());
        System.out.println("Professor: " + aula.getProfessor().getNome());
        System.out.println("Matéria que dá aula : " + aula.getTurma().getNome());
        System.out.println("Horário : " + aula.getHorario());
    }

    public void exibirListaAulas(List<Aula> aulas) {
        System.out.println("Lista de aulas:");
        for (Aula aula : aulas) {
        System.out.println("ID: " + aula.getId());
        System.out.println("Professor: " + aula.getProfessor());
        System.out.println("Turma" + aula.getTurma());
        System.out.println("Horário : " + aula.getHorario());
        }
    }

    public void menuAulas(AulaController aulaController, AulaView aulaView, ProfessorController professorController, ProfessorView professorView, TurmaController turmaController, TurmaView turmaView, Scanner scanner) {
        System.out.println("Menu de Aulas");
        System.out.println("1. Cadastrar aula");
        System.out.println("2. Buscar aula por ID");
        System.out.println("3. Atualizar aula");
        System.out.println("4. Deletar aula");
        System.out.println("5. Listar aulas");
        System.out.println("6. Voltar");

        int opcaoAulas = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoAulas) {
            case 1:
                System.out.println("Cadastro de Aula");
                System.out.println("Selecione um professor:");
                for (Professor professor : professorController.listarProfessores()) {
                    professorView.exibirDetalhesProfessor(professor);
                }
                System.out.print("Digite o ID do professor: ");
                int idProfessor = scanner.nextInt();
                scanner.nextLine();

                Professor professorSelecionado = professorController.buscarProfessorPorId(idProfessor);
                if (professorSelecionado == null) {
                    System.out.println("Professor não encontrado! Aula não cadastrada.");
                    break;
                }
                System.out.println("Selecione uma turma:");
                for (Turma turma : turmaController.listarTurma()) {
                    turmaView.exibirDetalhesTurma(turma);
                }
                System.out.print("Digite o ID da turma: ");
                int idTurma = scanner.nextInt();
                scanner.nextLine();

                Turma turmaSelecionada = turmaController.buscarTurmaPorId(idTurma);
                if (turmaSelecionada == null) {
                    System.out.println("Turma não encontrada! Aula não cadastrada.");
                    break;
                }
                System.out.print("Digite a data da aula (formato dd/MM/yyyy): ");
                String dataAulaString = scanner.nextLine();
                LocalDate dataAula;
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    dataAula = LocalDate.parse(dataAulaString, formatter);
                } catch (Exception e) {
                    System.out.println("Data informada em formato inválido! Aula não cadastrada.");
                    return;
                }
                System.out.print("Digite a descrição da aula: ");
                String descricao = scanner.nextLine();

                Aula novaAula = new Aula(turmaSelecionada, professorSelecionado, dataAula, descricao);
                aulaController.cadastrarAula(novaAula);
                System.out.println("Aula cadastrada com sucesso!");
                break;
            case 2:
                System.out.println("Buscar Aula por ID");
                System.out.print("Digite o ID da Aula: ");
                int idBuscaAulas = scanner.nextInt();
                scanner.nextLine();

                Aula aulaBuscada = aulaController.buscarAulaPorId(idBuscaAulas);

                if (aulaBuscada != null) {
                    aulaView.exibirDetalhesAula(aulaBuscada);
                } else {
                    System.out.println("Aula não encontrada!");
                }
                break;
            case 3:
            System.out.println("Atualizar Aula");
            System.out.print("Digite o ID da aula que deseja atualizar: ");
            int idAtualizarAula = scanner.nextInt();
            scanner.nextLine();
    
            Aula aulaAtualizada = aulaController.buscarAulaPorId(idAtualizarAula);
    
            if (aulaAtualizada != null) {
                System.out.println("Aula encontrada:");
                exibirDetalhesAula(aulaAtualizada);
    
                System.out.println("Selecione um novo professor:");
                for (Professor professor : professorController.listarProfessores()) {
                    professorView.exibirDetalhesProfessor(professor);
                }
                System.out.print("Digite o ID do novo professor: ");
                int novoIdProfessor = scanner.nextInt();
                scanner.nextLine();
    
                Professor novoProfessor = professorController.buscarProfessorPorId(novoIdProfessor);
                if (novoProfessor == null) {
                    System.out.println("Professor não encontrado! Aula não atualizada.");
                    return;
                }

                System.out.println("Selecione uma nova turma:");
                for (Turma turma : turmaController.listarTurma()) {
                    turmaView.exibirDetalhesTurma(turma);
                }
                System.out.println("Digite o ID da nova turma: ");
                int novoIdTurma = scanner.nextInt();
                scanner.nextLine();
    
                Turma novaTurma = turmaController.buscarTurmaPorId(novoIdTurma);
                if (novaTurma == null) {
                    System.out.println("Turma não encontrada! Aula não atualizada.");
                    return;
                }
    
    
                System.out.print("Digite a nova data da aula (formato dd/MM/yyyy): ");
                String novaDataAulaString = scanner.nextLine();
                LocalDate novaDataAula;
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    novaDataAula = LocalDate.parse(novaDataAulaString, formatter);
                } catch (Exception e) {
                    System.out.println("Data informada em formato inválido! Aula não atualizada.");
                    return;
                }
    
                System.out.print("Digite a nova descrição da aula: ");
                String novaDescricao = scanner.nextLine();
                aulaAtualizada.setTurma(novaTurma);
                aulaAtualizada.setProfessor(novoProfessor);
                aulaAtualizada.setHorario(novaDataAula);
                aulaAtualizada.setDescricao(novaDescricao);
    
                aulaController.atualizarAula(aulaAtualizada);
                System.out.println("Aula atualizada com sucesso!");
            } else {
                System.out.println("Aula não encontrada!");
            }
                break;
            case 4:
                System.out.println("Deletar Aula");
                System.out.print("Digite o ID da aula que deseja deletar: ");
                int idDeletarAula = scanner.nextInt();
                scanner.nextLine();

                aulaController.deletarAula(idDeletarAula);
                System.out.println("Aula deletado com sucesso!");
                break;
            case 5:
                System.out.println("Listar Aula");
                for (Aula aula : aulaController.listarAulas()) {
                    aulaView.exibirDetalhesAula(aula);
                }
                break;
            case 6:
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }
    }
}
