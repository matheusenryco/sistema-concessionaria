
package UI;

import service.FuncionarioService;
import java.util.Scanner;

public class MenuFuncionario {
    private final Scanner scanner;
    private final FuncionarioService funcionarioService;
    
     
     
    public MenuFuncionario(FuncionarioService funcionarioService) {
   
        this.scanner = new Scanner(System.in);
        this.funcionarioService = funcionarioService;
 }
    
    public void cadastrar() {
        boolean continuarCadastro = true;
        
        do{
            
            System.out.println("=== Cadastro de funcionario ===");
        
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Numero de matricula: ");
            int numMatricula = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Qualificacao: ");
            String qualificacao = scanner.nextLine();

            System.out.print("Descricao de funcao: ");
            String funcao = scanner.nextLine();

            System.out.print("Carga horaria semanal: ");
            int cargaHoraria = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("Funcionario cadastrado com sucesso");

            System.out.print("Deseja cadastrar outro funcionario [s/n]: ");
            String resposta = scanner.nextLine().toLowerCase();
              
            
            funcionarioService.cadastrar(nome, numMatricula, qualificacao, funcao, cargaHoraria);
        
            if (!resposta.equals("s")){
                continuarCadastro = false;
        }
        
        } while (continuarCadastro);
        
        System.out.println("Acabou");
        
        
    }
     
    
     
    
}
