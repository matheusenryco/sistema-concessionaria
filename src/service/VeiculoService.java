package service;

import model.Veiculo;
import exception.EntidadeJaExisteException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class VeiculoService {
    private final List<Veiculo> veiculos;
    private final Scanner scanner;

    public VeiculoService() {
        this.veiculos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void cadastrar(String chassi, String nome, String cor, int numMarcha, int numPorta, String marca, int ano) {
        if (consultar(chassi) != null) {
            throw new EntidadeJaExisteException("Ja existe um veiculo cadastrado com o chassi: " + chassi);
        }

        Veiculo veiculo = new Veiculo(chassi, nome, cor, numMarcha, numPorta, marca, ano);
        veiculos.add(veiculo);
    }

    public Veiculo consultar(String chassi) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getChassi().equalsIgnoreCase(chassi)) {
                return veiculo;
            }
        }
        return null;
    }

    public void alterarChassi() {
        System.out.println("=== ALTERAR CHASSI ===");
        System.out.print("Digite o chassi do veiculo: ");
        String chassiVeiculo = scanner.nextLine();
        Veiculo veiculo = consultar(chassiVeiculo);

        if (veiculo != null) {
            System.out.println("Veiculo encontrado");
            System.out.print("Digite o novo chassi: ");

            String novoChassi = scanner.nextLine();
            veiculo.setChassi(novoChassi);

            System.out.println("Chassi alterado com sucesso");
        } else {
            System.out.println("Veiculo nao encontrado.");
        }
    }

    public void alterarNome() {
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
    public void relatorio() {
        int c;
        c = 0;
        for (Veiculo veiculo : veiculos) {
            c += 1;
            System.out.println("-----------");
            System.out.println(" Veiculo: " + c);
            System.out.println("-----------");
            System.out.println("Chassi: " + veiculo.getChassi());
            System.out.println("Nome: " + veiculo.getNome());
            System.out.println("Cor: " + veiculo.getCor());
            System.out.println("Numero de marchas: " + veiculo.getNumMarchas());
            System.out.println("Numero de portas: " + veiculo.getNumPortas());            
            System.out.println("Marca: " + veiculo.getMarca());
        }
    }
}
