package models;

public class OutroFuncionario extends Pessoa {
    private String cargo;

    public OutroFuncionario(int id, String nome, int idade, String cargo) {
        super(id, nome, idade);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
