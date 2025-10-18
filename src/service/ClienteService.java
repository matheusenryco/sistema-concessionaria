package service;

import model.Cliente;

import java.util.Set;
import java.util.HashSet;

public class ClienteService {
    private final Set<Cliente> clientes = new HashSet<>();

    public void cadastrar(String nome, String telefone, String email, String rg, String cpf) {
        if (buscaPorCpf(cpf) != null) {
            throw new IllegalArgumentException("Cliente com CPF " + cpf + " ja cadastrado.");
        }
        else {
            Cliente cliente = new Cliente(nome, telefone, email, rg, cpf);
            clientes.add(cliente);
        }
    }

    public Cliente buscaPorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}