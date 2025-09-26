import java.util.Scanner;

public class menuClientes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String opcao = "";

        do {
            System.out.println("============================");
            System.out.println("[1] - Clientes");
            System.out.println("[2] - Funcionarios");
            System.out.println("[3] - Carros");
            System.out.println("[4] - Vendas");
            System.out.println("[5] - Sair");
            System.out.println("============================\n");

            System.out.print("O que deseja fazer: ");
            opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                System.out.println(">> Opção de cadastro selecionada");
            }

            else if (opcao.equals("2")) {
                System.out.println(">> Opção de consulta selecionada");
            }

            else if (opcao.equals("3")) {
                System.out.println(">> Opção de alteração selecionada");
            }

            else if (opcao.equals("4")) {
                System.out.println(">> Opção de remoção selecionada");
            }

            else if (opcao.equals("5")) {
                System.out.println("Saindo do sistema...");
            }

        } while(!opcao.equals("5"));

        scanner.close();
    }
}
