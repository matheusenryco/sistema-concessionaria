package service;

import model.Veiculo;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class VeiculoService {
    private final List<Veiculo> veiculos;

    public VeiculoService() {
        this.veiculos = new ArrayList<>();
    }

    public void cadastrar(String nome, String cor, int numMarcha, int numPorta, String marca, int ano) {
        Veiculo veiculo = new Veiculo(nome, cor, numMarcha, numPorta, marca, ano);
        veiculos.add(veiculo);
    }

    public Veiculo consultar(String nome) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getNome().equalsIgnoreCase(nome)) {
                return veiculo;
            }
        }
        return null;
    }

    public void alterarNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR NOME ===");
        System.out.print("Digite o nome do veiculo: ");
        String nomeVeiculo = scanner.nextLine();
        Veiculo veiculo = consultar(nomeVeiculo);

        if (veiculo != null) {
            System.out.println("Veiculo encontrado");
            System.out.print("Digite o novo nome: ");

            String novoNome = scanner.nextLine();
            veiculo.setNome(novoNome);

            System.out.println("Nome alterado com sucesso");
        } else {
            System.out.println("Veiculo nao encontrado.");
        }
    }

    public void alterarCor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR COR ===");
        System.out.print("Digite o nome do veiculo: ");
        String nomeVeiculo = scanner.nextLine();
        Veiculo veiculo = consultar(nomeVeiculo);

        if (veiculo != null) {
            System.out.println("Veiculo encontrado");
            System.out.print("Digite a nova cor: ");

            String novaCor = scanner.nextLine();
            veiculo.setCor(novaCor);

            System.out.println("Cor alterada com sucesso");
        } else {
            System.out.println("Veiculo nao encontrado.");
        }
    }

    public void alterarNumMarcha() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR NUMERO DE MARCHA ===");
        System.out.print("Digite o nome do veiculo: ");
        String nomeVeiculo = scanner.nextLine();
        Veiculo veiculo = consultar(nomeVeiculo);

        if (veiculo != null) {
            System.out.println("Veiculo encontrado");
            System.out.print("Digite o novo numero de marcha: ");

            int novoNumMarcha = scanner.nextInt();
            veiculo.setNumMarchas(novoNumMarcha);

            System.out.println("Numero de marcha alterado com sucesso");
        } else {
            System.out.println("Veiculo nao encontrado.");
        }
    }

    public void alterarNumPorta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR NUMERO DE PORTAS ===");
        System.out.print("Digite o nome do veiculo: ");
        String nomeVeiculo = scanner.nextLine();
        Veiculo veiculo = consultar(nomeVeiculo);

        if (veiculo != null) {
            System.out.println("Veiculo encontrado");
            System.out.print("Digite o novo numero de portas: ");

            int novoNumPortas = scanner.nextInt();
            veiculo.setNumPortas(novoNumPortas);

            System.out.println("Numero de portas alterado com sucesso");
        } else {
            System.out.println("Veiculo nao encontrado.");
        }
    }

    public void alterarMarca() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR MARCA ===");
        System.out.print("Digite o nome do veiculo: ");
        String nomeVeiculo = scanner.nextLine();
        Veiculo veiculo = consultar(nomeVeiculo);

        if (veiculo != null) {
            System.out.println("Veiculo encontrado");
            System.out.print("Digite a nova marca: ");

            String novaMarca = scanner.nextLine();
            veiculo.setMarca(novaMarca);

            System.out.println("Marca alterada com sucesso");
        } else {
            System.out.println("Veiculo nao encontrado.");
        }
    }

    public void alterarAno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR ANO ===");
        System.out.print("Digite o nome do veiculo: ");
        String nomeVeiculo = scanner.nextLine();
        Veiculo veiculo = consultar(nomeVeiculo);

        if (veiculo != null) {
            System.out.println("Veiculo encontrado");
            System.out.print("Digite o novo ano: ");

            int novoAno = scanner.nextInt();
            veiculo.setAno(novoAno);

            System.out.println("Ano alterado com sucesso");
        } else {
            System.out.println("Veiculo nao encontrado.");
        }
    }
    
    public void remover(Veiculo veiculo) {
        veiculos.remove(veiculo);
        System.out.println("Veiculo removido com sucesso");
    }
}
