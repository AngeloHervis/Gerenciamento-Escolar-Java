package crud;

import models.OutroFuncionario;
import util.Log;

import java.util.ArrayList;
import java.util.List;

public class OutroFuncionarioCrud {
    private List<OutroFuncionario> outrosFuncionarios = new ArrayList<>();

    public void cadastrarOutroFuncionario(OutroFuncionario funcionario) throws Exception {
        if (buscarOutroFuncionarioPorNome(funcionario.getNome()) != null) {
            throw new Exception("Funcionário com o nome " + funcionario.getNome() + " já está cadastrado.");
        }
        outrosFuncionarios.add(funcionario);
        registrarLog("Funcionário cadastrado: " + funcionario.getNome());
    }

    private OutroFuncionario buscarOutroFuncionarioPorNome(String nome) {
        return outrosFuncionarios.stream()
            .filter(c -> c.getNome().trim().equalsIgnoreCase(nome.trim()))
            .findFirst()
            .orElse(null);
    }

    public List<OutroFuncionario> listarOutrosFuncionarios() throws Exception {
        if (outrosFuncionarios.isEmpty()) {
            throw new Exception("Não há nenhum funcionário cadastrado.");
        }
        return outrosFuncionarios;
    }

    public OutroFuncionario buscarOutroFuncionarioPorId(int id) throws Exception {
        OutroFuncionario funcionarioEncontrado = outrosFuncionarios.stream()
            .filter(c -> c.getId() == id)
            .findFirst()
            .orElse(null);
        if (funcionarioEncontrado == null) {
            throw new Exception("Funcionário com o id: " + id + " não foi encontrado.");
        }
        return funcionarioEncontrado;
    }

    public void atualizarOutroFuncionario(OutroFuncionario outroFuncionarioAtualizado) throws Exception {
        OutroFuncionario funcionario = buscarOutroFuncionarioPorId(outroFuncionarioAtualizado.getId());
        if (funcionario != null) {
            funcionario.setNome(outroFuncionarioAtualizado.getNome());
            registrarLog("Funcionário atualizado: " + funcionario.getNome());
        }
    }

    public void deletarOutroFuncionario(int id) throws Exception {
        OutroFuncionario funcionario = buscarOutroFuncionarioPorId(id);
        if (funcionario != null) {
            outrosFuncionarios.remove(funcionario);
            registrarLog("Funcionário removido: " + funcionario.getNome());
        }
    }

    private void registrarLog(String mensagem) {
        try {
            List<String> logs = new ArrayList<>();
            logs.add(mensagem);
            Log.salvar(logs, "log");
        } catch (Exception e) {
            System.err.println("Erro ao salvar log: " + e.getMessage());
        }
    }
}
