package service;

import model.Cliente;

import java.util.List;
import java.util.ArrayList;

public class ClienteService {
    private List<Cliente> clientes;

    public ClienteService() {
        this.clientes = new ArrayList<>();
    }

    public void cadastrar(String nome, String telefone, String email, String rg, String cpf) {
        Cliente cliente = new Cliente(nome, telefone, email, rg, cpf);
        clientes.add(cliente);
    }
}