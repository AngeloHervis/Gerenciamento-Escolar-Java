package crud;

import java.util.ArrayList;
import java.util.List;

import models.OutroFuncionario;

public class OutroFuncionarioCrud {
    private List<OutroFuncionario> outrosFuncionarios = new ArrayList<>();

    public void cadastrarOutroFuncionario(OutroFuncionario funcionario) {
        outrosFuncionarios.add(funcionario);
    }

    public List<OutroFuncionario> listarOutrosFuncionarios() {
        return outrosFuncionarios;
    }

    public OutroFuncionario buscarOutroFuncionarioPorId(int id) {
        for (OutroFuncionario funcionario : outrosFuncionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public void atualizarOutroFuncionario(OutroFuncionario outroFuncionarioAtualizado) {
        OutroFuncionario outrosFuncionarios = buscarOutroFuncionarioPorId(outroFuncionarioAtualizado.getId());
        if (outrosFuncionarios != null) {
            outrosFuncionarios.setNome(outroFuncionarioAtualizado.getNome());
        }
    }

    public void deletarOutroFuncionario(int id) {
        OutroFuncionario outroFuncionario = buscarOutroFuncionarioPorId(id);
        if (outrosFuncionarios != null) {
            outrosFuncionarios.remove(outroFuncionario);
        }
    }
}
