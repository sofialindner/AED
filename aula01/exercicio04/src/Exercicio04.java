/*  Tendo em vista o contexto do problema, que requer o cadastro e remoção dos elementos na ordem
    em que foram adicionados (ordem de atendimento conforme ordem de chegada), a Fila apresenta-se
    como a estrutura de dados mais apropriada para o cenário, uma vez que seu método remove() realiza
    sempre a remoção do último registro.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        new Exercicio04();
    }

    public Exercicio04() {
        Scanner teclado = new Scanner(System.in);

        // Criação de uma estrutura de dados tipo Fila para registro das pessoas atendidas
        Queue<String> atendimentos = new LinkedList();

        char opcao = ' ';
        while (opcao != 'D') {
            System.out.println("\nEscolha uma opção: ");
            System.out.println("(A) Cadastrar atendimento");
            System.out.println("(B) Remover");
            System.out.println("(C) Exibir fila");
            System.out.println("(D) Finalizar");
            opcao = teclado.next().toUpperCase().charAt(0);

            switch (opcao) {
                case 'A':
                    System.out.print("Pessoa atendida: ");
                    String nome = teclado.next();
                    atendimentos.add(nome);
                    break;
                case 'B':
                    atendimentos.remove();
                    break;
                case 'C':
                    int contador = 0;
                    for (String a : atendimentos) {
                        contador ++;
                        System.out.println(contador + ". " + a);
                    }
                    break;
                case 'D':
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        }
    }

    private boolean verificar(String atendimento) {
        return true;
    }
}
