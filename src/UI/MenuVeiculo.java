
package UI;

import java.util.Scanner;
import service.VeiculoService;

public class MenuVeiculo implements IMenu {
    private final Scanner scanner;
    private final VeiculoService veiculoService;

    public MenuVeiculo(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void cadastrar() {
        boolean continuarCadastro = true;
        
        do {
            System.out.println("=== Cadastro de veiculo ===");
            
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Cor: ");
            String cor = scanner.nextLine();
            
            System.out.print("Numero de marcha: ");
            int numMarcha = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Numero de portas: ");
            int numPortas = scanner.nextInt();
            scanner.nextLine();
                   
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            
            System.out.print("Ano: ");
            int ano = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("Cadastro de veiculo concluido");

            System.out.print("\nDeseja continuar cadastro? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();
            
            veiculoService.cadastrar(nome, cor, numMarcha, numPortas, marca, ano);

            if (!resposta.equals("s")) {
                continuarCadastro = false;
            }
            if (!resposta.equals("n")) {
                continuarCadastro = true;
            }
            if (!resposta.equals("s") && !resposta.equals("n")) {
                while(!resposta.equals("s") && !resposta.equals("n")) {
                    
                    System.out.println("Resposta invalida");
                    System.out.print("\nDeseja cadastrar outro veiculo? (s/n): ");
                    resposta = scanner.nextLine().toLowerCase();
                    
                }
                
                
            }
        } while (continuarCadastro);
    }

    @Override
    public void consultar(){
        System.out.println("=== Consultar Veículo ===");
        System.out.print("Digite o nome do veiculo: ");
        String nome = scanner.nextLine();
        veiculoService.consultar(nome);
    }

    /*
    @Override
    public void alterar() {
        // TODO: Implementar alteração de cliente
    }
    */
}
