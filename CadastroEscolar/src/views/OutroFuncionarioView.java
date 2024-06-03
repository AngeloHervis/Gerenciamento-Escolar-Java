package views;

import java.util.List;

import controllers.OutroFuncionarioController;
import models.OutroFuncionario;

public class OutroFuncionarioView {
    private OutroFuncionarioController outroFuncionarioController;

    public OutroFuncionarioView(OutroFuncionarioController outroFuncionarioController) {
        this.outroFuncionarioController = outroFuncionarioController;
    }

    public void exibirDetalhesOutroFuncionario(OutroFuncionario outroFuncionario) {
        System.out.println("Detalhes do Funcionário");
        System.out.println("ID: " + outroFuncionario.getId());
        System.out.println("Nome: " + outroFuncionario.getNome());
        System.out.println("Cargo: " + outroFuncionario.getCargo());
    }

    public void exibirListaOutrosFuncionarios(List<OutroFuncionario> outrosFuncionarios) {
        System.out.println("Lista de Funcionários:");
        for (OutroFuncionario funcionario : outrosFuncionarios) {
            System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome() + "Cargo: " + funcionario.getCargo());
        }
    }
}
