import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Scanner teclado = new Scanner(System.in);

        // Criação de um vetor estático do tipo String de tamanho fixo, que é passado como argumento
        Vetor nomes = new Vetor(10);

        char opcao = ' ';
        while (opcao != 'E') {
            System.out.println("Escolha uma opção: ");
            System.out.println("(A) Cadastrar nome");
            System.out.println("(B) Remover nome");
            System.out.println("(C) Alterar nome");
            System.out.println("(D) Listar nomes");
            System.out.println("(E) Sair");
            opcao = teclado.next().toUpperCase().charAt(0);

            switch (opcao) {
                case 'A':
                    cadastrar(teclado, nomes);
                    break;
                case 'B':
                    remover(teclado, nomes);
                    break;
                case 'C':
                    alterar(teclado, nomes);
                    break;
                case 'D':
                    System.out.println(nomes.listar());
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }
    }

    private void cadastrar(Scanner teclado, Vetor nomes) {
        System.out.print("Nome: ");
        String nome = teclado.next();

        while (nome.equals("")) {
            System.out.print("Digite um nome válido. \nNome: ");
            nome = teclado.next();
        }
        nomes.cadastrar(nome);
        System.out.println("Nome cadastrado com sucesso!\n");
    }

    private void remover(Scanner teclado, Vetor nomes) {
        // Verificação do conteúdo do vetor, para que o usuário não fique preso no loop em caso de um array vazio
        if (nomes.getVetor()[0] == null) {
            System.out.println("Desculpe, não há o que ser removido.\n");
        } else {
            System.out.print("Índice: ");
            int indice = teclado.nextInt();

            while (indice < 0 || indice >= nomes.getIndice()) {
                System.out.print("índice não encontrado.\nÍndice: ");
                indice = teclado.nextInt();
            }
            nomes.remover(indice);
            System.out.println("Nome de índice " + indice + " removido com sucesso!\n");
        }
    }

    private void alterar(Scanner teclado, Vetor nomes) {
        if (nomes.getVetor()[0] == null) {
            System.out.println("Desculpe, não há o que ser alterado.\n");
        } else {
            System.out.print("índice: ");
            int indice = teclado.nextInt();

            while (indice < 0 || indice >= nomes.getIndice()) {
                System.out.print("índice não encontrado.\nÍndice: ");
                indice = teclado.nextInt();
            }

            System.out.print("Novo nome: ");
            String nome = teclado.next();

            while (nome.equals("")) {
                System.out.print("Digite um nome válido.\nNome:");
                nome = teclado.next();
            }
            nomes.alterar(indice, nome);
            System.out.println("Nome alterado com sucesso!\n");
        }
    }
}
