package UI;

import java.time.LocalDateTime;
import model.Vendas;
import model.Cliente;
import model.Veiculo;
import model.Funcionario;
import service.VeiculoService;
import service.ClienteService;
import service.FuncionarioService;
import service.VendasService;

import java.util.Scanner;

public class MenuVendas implements IMenu {
    private final Scanner scanner;
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;
    private final VeiculoService veiculoService;
    private final VendasService vendasService;
    
    public MenuVendas(ClienteService clienteService, FuncionarioService funcionarioService, VeiculoService veiculoService, VendasService vendasService) {
        this.scanner = new Scanner(System.in);
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
        this.veiculoService = veiculoService;
        this.vendasService = vendasService;
    }

    @Override
    public void cadastrar() {
        boolean continuarCadastro = true;
        
        do{
            System.out.println("=== Cadastro de Vendas ===");

            System.out.println("Data da venda: ");
            String data = scanner.nextLine();
            
            System.out.println("Valor da venda: ");
            double valor = scanner.nextDouble();
            
            System.out.println("Nome do cliente: ");
            String nome = scanner.nextLine();
            
            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();
            
            System.out.println("Email: ");
            String email = scanner.nextLine();

            //REVER LÓGICA DE VENDAS: vendasService.cadastrar(data, valor, ...);

            System.out.println("Venda cadastrada com sucesso!");

            System.out.print("\nDeseja continuar cadastro? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();

            if (!resposta.equals("s")) {
                continuarCadastro = false;
            }
            if (!resposta.equals("n")) {
                continuarCadastro = true;
            }
            if (!resposta.equals("s") && !resposta.equals("n")) {
                while (!resposta.equals("s") && !resposta.equals("n")) {
                    System.out.println("Resposta invalida");
                    System.out.print("\nDeseja continuar cadastro? (s/n): ");
                    resposta = scanner.nextLine().toLowerCase();
                }
            }
        } while(continuarCadastro);
    }

    @Override
    public void consultar() {
    }
}

