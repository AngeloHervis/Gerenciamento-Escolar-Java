package crud;

import java.util.ArrayList;
import java.util.List;
import models.OutroFuncionario;

public class OutroFuncionarioCrud {
    private List<OutroFuncionario> outrosFuncionarios = new ArrayList<>();

    public void cadastrarOutroFuncionario(OutroFuncionario funcionario) throws Exception {
        if (buscarOutroFuncionarioPorNome(funcionario.getNome()) != null) {
            throw new Exception("Funcionário com o nome " + funcionario.getNome() + " já está cadastrado.");
        }
        outrosFuncionarios.add(funcionario);
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
        }
    }

    public void deletarOutroFuncionario(int id) throws Exception {
        OutroFuncionario funcionario = buscarOutroFuncionarioPorId(id);
        if (funcionario != null) {
            outrosFuncionarios.remove(funcionario);
        }
    }
}
