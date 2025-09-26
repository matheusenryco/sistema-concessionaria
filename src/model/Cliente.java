package model;

public class Cliente extends Pessoa {
    private String telefone;
    private String email;
    private String rg;
    private String cpf;

    public Cliente(String nome, String telefone, String email, String rg, String cpf) {
        super(nome);
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String toString() {
        return "Nome: " + getNome() + ", Telefone: " + telefone + ", Email: " + email + ", RG: " + rg + ", CPF: " + cpf;
    }
}
