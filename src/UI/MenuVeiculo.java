
package UI;

import java.util.Scanner;
import service.VeiculoService;

public class MenuVeiculo {
    private final Scanner scanner;
    private final VeiculoService veiculoService;
    
    
    public MenuVeiculo(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
        this.scanner = new Scanner(System.in);
        
        
    }
    
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
            
            System.out.println("Deseja continuar cadastro[s/n]: ");
            String resposta = scanner.nextLine().toLowerCase();
            
            veiculoService.cadastrar(nome, cor, numMarcha, numPortas, marca, ano);
            
            
            
            if (!resposta.equals("s")) {
                continuarCadastro = false;
            }
            
        } while (continuarCadastro);
    }
    
    
}
