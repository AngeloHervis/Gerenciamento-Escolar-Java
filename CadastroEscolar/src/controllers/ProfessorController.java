package controllers;

import models.Professor;

import java.util.List;

import crud.ProfessorCrud;

public class ProfessorController{
    private ProfessorCrud professorCrud;

    public ProfessorController(ProfessorCrud professorCrud) {
        this.professorCrud = professorCrud;
    }

    public void cadastrarProfessor(Professor professor) {
        professorCrud.cadastrarProfessor(professor);
    }

    public void atualizarProfessor(Professor professor) {
        professorCrud.atualizarProfessor(professor);
    }

    public void deletarProfessor(int id) {
        professorCrud.deletarProfessor(id);
    }

    public Professor buscarProfessorPorId(int id) {
        return professorCrud.buscarProfessorPorId(id);
    }

    public List<Professor> listarProfessores(){
        return professorCrud.listarProfessores();
    }
}

