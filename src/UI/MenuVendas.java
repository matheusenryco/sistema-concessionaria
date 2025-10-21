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
        boolean continuarCadastro;

        do {
            System.out.println("=== Cadastro de Vendas ===");

            System.out.println("Data da venda: ");
            String data = scanner.nextLine();

            System.out.println("Valor da venda: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();


            System.out.println("Venda cadastrada com sucesso!");

            String resposta;
            do {
                System.out.print("\nDeseja cadastrar outra venda? (s/n): ");
                resposta = scanner.nextLine().toLowerCase();
                if (!resposta.equals("s") && !resposta.equals("n")) {
                    System.out.println("Resposta invalida");
                }
            } while (!resposta.equals("s") && !resposta.equals("n"));

            continuarCadastro = resposta.equals("s");
        } while (continuarCadastro);
    }

    @Override
    public void consultar() {
    }

    @Override
    public void alterar() {
    }
}