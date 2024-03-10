/*  Tendo em vista o contexto do problema, que requer o cadastro e remoção dos elementos na ordem
    em que foram adicionados (ordem de atendimento conforme hora de chegada), a Fila apresenta-se
    como a estrutura de dados mais apropriada para o cenário, uma vez que seu método remove() realiza
    sempre a remoção do último registro.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Scanner teclado = new Scanner(System.in);

        // Criação de uma estrutura de dados tipo Fila para registro das pessoas atendidas
        Queue<String> atendimentos = new LinkedList();

        char opcao = ' ';
        while (opcao != 'D') {
            System.out.println("Escolha uma opção: ");
            System.out.println("(A) Cadastrar atendimento");
            System.out.println("(B) Remover");
            System.out.println("(C) Exibir fila");
            System.out.println("(D) Finalizar");
            opcao = teclado.next().toUpperCase().charAt(0);

            switch (opcao) {
                case 'A':
                    cadastrar(teclado, atendimentos);
                    break;
                case 'B':
                    atendimentos.remove();
                    System.out.println();
                    break;
                case 'C':
                    System.out.println( listar(teclado, atendimentos));
                    break;
                case 'D':
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        }
    }

    private void cadastrar(Scanner teclado, Queue<String> atendimentos) {
        System.out.print("Pessoa atendida: ");
        String nome = teclado.next();

        if (verificarRegistro(nome, atendimentos)) {
            System.out.println(nome + " já em fila de atendimento.\n");
        } else {
            atendimentos.add(nome);
            System.out.println("Atendimento cadastrado!\n");
        }
    }

    private String listar(Scanner teclado, Queue<String> atendimentos) {
        int contador = 0;
        String filaToString = "";
        for (String a : atendimentos) {
            contador ++;
            filaToString += contador + ". " + a + "\n";
        }

        if (filaToString.isEmpty()) {
            return "Nenhum atendimento cadastrado.\n";
        }
        return "ATENDIMENTOS\n" + filaToString;
    }

    private boolean verificarRegistro(String atendimento, Queue<String> atendimentos) {
        if (atendimentos.contains(atendimento)) {
            return true;
        }
        return false;
    }
}
