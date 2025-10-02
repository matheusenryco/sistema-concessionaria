package UI;

import java.util.Scanner;

public class MenuCadastro {
    private final Scanner scanner;

    public MenuCadastro() {
        this.scanner = new Scanner(System.in);
    }

    public static void iniciarSistema(Scanner scanner) {
        boolean executando = true;

        do {
            System.out.println("============================");
            System.out.println("[1] - Cliente");
            System.out.println("[2] - Funcionario");
            System.out.println("[3] - Veiculo");
            System.out.println("[4] - Venda");
            System.out.println("[5] - Voltar ao menu principal");
            System.out.println("[6] - Sair");
            System.out.println("============================\n");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> new MenuCliente().cadastrar();
                // TODO case "2" -> MenuFuncionario.cadastrar(scanner);
                // TODO case "3" -> MenuVeiculo.cadastrar(scanner);
                // TODO case "4" -> MenuVenda.cadastrar(scanner);
                case "5" -> { return; }
                case "6" -> System.exit(0);
                default -> System.out.println(">> Opção inválida!");
            }
        } while (executando);
    }
}