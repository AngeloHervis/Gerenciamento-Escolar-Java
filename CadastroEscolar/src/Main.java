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
import java.util.Scanner;
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

        boolean sair = false;
        Scanner scanner = new Scanner(System.in);

        while (!sair) {
            System.out.println("GERENCIAMENTO ESCOLAR");
            System.out.println("Digite o número da opção correspondente");
            System.out.println("1. Funcionários");
            System.out.println("2. Turmas");
            System.out.println("3. Alunos");
            System.out.println("4. Matérias");
            System.out.println("5. Professores");
            System.out.println("6. Aulas");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarFuncionarios(outroFuncionarioController, outroFuncionarioView, scanner);
                    break;
                case 2:
                    gerenciarTurmas(turmaController, turmaView, scanner);
                    break;
                case 7:
                    sair = true;
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
            }
        }

        scanner.close();
    }

    private static void gerenciarFuncionarios(OutroFuncionarioController funcionarioController, OutroFuncionarioView funcionarioView, Scanner scanner) {
        System.out.println("Menu de Funcionários");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Buscar Funcionário por ID");
        System.out.println("3. Atualizar Funcionário");
        System.out.println("4. Deletar Funcionário");
        System.out.println("5. Listar Funcionários");
        System.out.println("6. Voltar");

        int opcaoFuncionario = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoFuncionario) {
            case 1:
                System.out.println("Cadastro de Funcionário");
                System.out.print("Digite o ID do funcionário: ");
                int idFuncionario = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o nome do funcionário: ");
                String nomeFuncionario = scanner.nextLine();
                System.out.print("Digite a idade do funcionário: ");
                int idadeFuncionario = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o cargo do funcionário: ");
                String cargoFuncionario = scanner.nextLine();

                OutroFuncionario novoFuncionario = new OutroFuncionario(idFuncionario, nomeFuncionario, idadeFuncionario, cargoFuncionario);
                funcionarioController.cadastrarOutroFuncionario(novoFuncionario);
                System.out.println("Funcionário cadastrado com sucesso!");
                break;
            case 2:
                System.out.println("Buscar Funcionário por ID");
                System.out.print("Digite o ID do funcionário: ");
                int idBuscaFuncionario = scanner.nextInt();
                scanner.nextLine();

                OutroFuncionario funcionarioBuscado = funcionarioController.buscarOutroFuncionarioPorId(idBuscaFuncionario);

                if (funcionarioBuscado != null) {
                    funcionarioView.exibirDetalhesOutroFuncionario(funcionarioBuscado);
                } else {
                    System.out.println("Funcionário não encontrado!");
                }
                break;
            case 3:
                System.out.println("Atualizar Funcionário");
                System.out.print("Digite o ID do funcionário que deseja atualizar: ");
                int idAtualizarFuncionario = scanner.nextInt();
                scanner.nextLine();

                OutroFuncionario funcionarioAtualizado = funcionarioController.buscarOutroFuncionarioPorId(idAtualizarFuncionario);

                if (funcionarioAtualizado != null) {
                    System.out.print("Digite o novo nome do funcionário: ");
                    funcionarioAtualizado.setNome(scanner.nextLine());
                    System.out.print("Digite a nova idade do funcionário: ");
                    funcionarioAtualizado.setIdade(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Digite o novo cargo do funcionário: ");
                    funcionarioAtualizado.setCargo(scanner.nextLine());

                    funcionarioController.atualizarOutroFuncionario(funcionarioAtualizado);
                    System.out.println("Funcionário atualizado com sucesso!");
                } else {
                    System.out.println("Funcionário não encontrado!");
                }
                break;
            case 4:
                System.out.println("Deletar Funcionário");
                System.out.print("Digite o ID do funcionário que deseja deletar: ");
                int idDeletarFuncionario = scanner.nextInt();
                scanner.nextLine();

                funcionarioController.deletarOutroFuncionario(idDeletarFuncionario);
                System.out.println("Funcionário deletado com sucesso!");
                break;
            case 5:
                System.out.println("Listar Funcionários");
                for (OutroFuncionario funcionario : funcionarioController.listarOutrosFuncionarios()) {
                    funcionarioView.exibirDetalhesOutroFuncionario(funcionario);
                }
                break;
            case 6:
                break; 
            default:
                System.out.println("Digite uma opção válida!");
        }
    }

    private static void gerenciarTurmas(TurmaController turmaController, TurmaView turmaView, Scanner scanner) {
        System.out.println("Menu de Turmas");
        System.out.println("1. Cadastrar Turma");
        System.out.println("2. Buscar Turma por ID");
        System.out.println("3. Atualizar Turma");
        System.out.println("4. Deletar Turma");
        System.out.println("5. Listar Turmas");
        System.out.println("6. Voltar");

        int opcaoTurma = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoTurma) {
            case 1:
                System.out.println("Cadastro de Turma");
                System.out.print("Digite o ID da turma: ");
                int idTurma = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o nome da turma: ");
                String nomeTurma = scanner.nextLine();
                System.out.print("Digite a descrição da turma (opcional): ");
                String descricaoTurma = scanner.nextLine();

                Turma novaTurma = new Turma(idTurma, nomeTurma, descricaoTurma);
                turmaController.cadastrarTurma(novaTurma);
                System.out.println("Turma cadastrada com sucesso!");
                break;
            case 2:
                System.out.println("Buscar Turma por ID");
                System.out.print("Digite o ID da turma: ");
                int idBuscaTurma = scanner.nextInt();
                scanner.nextLine();

                Turma turmaBuscada = turmaController.buscarTurmaPorId(idBuscaTurma);

                if (turmaBuscada != null) {
                    turmaView.exibirDetalhesTurma(turmaBuscada);
                } else {
                    System.out.println("Turma não encontrada!");
                }
                break;
            case 3:
                System.out.println("Atualizar Turma");
                System.out.print("Digite o ID da turma que deseja atualizar: ");
                int idAtualizarTurma = scanner.nextInt();
                scanner.nextLine();

                Turma turmaAtualizada = turmaController.buscarTurmaPorId(idAtualizarTurma);

                if (turmaAtualizada != null) {
                    System.out.print("Digite o novo nome da turma: ");
                    turmaAtualizada.setNome(scanner.nextLine());
                    System.out.print("Digite a nova descrição da turma (opcional): ");
                    turmaAtualizada.setDescricao(scanner.nextLine());

                    turmaController.atualizarTurma(turmaAtualizada);
                    System.out.println("Turma atualizada com sucesso!");
                } else {
                    System.out.println("Turma não encontrada!");
                }
                break;
            case 4:
                System.out.println("Deletar Turma");
                System.out.print("Digite o ID da turma que deseja deletar: ");
                int idDeletarTurma = scanner.nextInt();
                scanner.nextLine();

                turmaController.deletarTurma(idDeletarTurma);
                System.out.println("Turma deletada com sucesso!");
                break;
            case 5:
                System.out.println("Listar Turmas");
                for (Turma turma : turmaController.listarTurma()) {
                    turmaView.exibirDetalhesTurma(turma);
                }
                break;
            case 6:
                break; // Voltar para o menu principal
            default:
                System.out.println("Digite uma opção válida!");
        }
    }

    // ... (métodos para gerenciar alunos, matérias, professores e aulas também devem ser implementados)

}
