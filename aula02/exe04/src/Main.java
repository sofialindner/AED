import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        List<String> nomes = new LinkedList<>();
        Scanner teclado = new Scanner(System.in);

        char opcao = ' ';
        while (opcao != 'C') {
            System.out.println("Escolha uma opção: ");
            System.out.println("(A) - Cadastrar nome");
            System.out.println("(B) - Listar nomes");
            System.out.println("(C) - Finalizar");
            opcao = teclado.next().toUpperCase().charAt(0);
            
            switch (opcao) {
                case 'A':
                    System.out.println(cadastrar(teclado, nomes));
                    break;
                case 'B':
                    System.out.println(listar(nomes));
                    break;
                case 'C':
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }
        teclado.close();
    }

    private String cadastrar(Scanner teclado, List<String> nomes) {
        System.out.print("Nome: ");
        String nome = teclado.next();

        if (nomes.contains(nome))
            return "Desculpe, nome já cadastrado.\n";
        nomes.add(nome);
        return "Nome cadastrado com sucesso!\n";
    }

    private String listar(List<String> nomes) {
        String listaNomes = "";
        for (String n : nomes) {
            listaNomes += n + "\n";
        }
        
        if (listaNomes.isEmpty())
            return "Não há nomes cadastrados.\n";
        return "NOMES\n" + listaNomes;
    }
}
