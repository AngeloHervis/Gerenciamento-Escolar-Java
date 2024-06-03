package controllers;

import crud.OutroFuncionarioCrud;
import models.OutroFuncionario;

public class OutroFuncionarioController {
    private OutroFuncionarioCrud outroFuncionarioCrud;

    public OutroFuncionarioController(OutroFuncionarioCrud outroFuncionarioCrud) {
        this.outroFuncionarioCrud = outroFuncionarioCrud;
    }

    public void cadastrarOutroFuncionario(OutroFuncionario outroFuncionario) {
        outroFuncionarioCrud.cadastrarOutroFuncionario(outroFuncionario);
    }

    public void atualizarOutroFuncionario(OutroFuncionario outroFuncionario) {
        outroFuncionarioCrud.atualizarOutroFuncionario(outroFuncionario);
    }

    public void deletarOutroFuncionario(int id) {
        outroFuncionarioCrud.deletarOutroFuncionario(id);
    }

    public OutroFuncionario buscarOutroFuncionarioPorId(int id) {
        return outroFuncionarioCrud.buscarOutroFuncionarioPorId(id);
    }
}
