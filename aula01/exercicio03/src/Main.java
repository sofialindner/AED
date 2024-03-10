import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Scanner teclado = new Scanner(System.in);

        // Criação de um vetor dinâmico, inicializado com tamanho 0, do tipo Produto
        Vetor produtos = new Vetor();

        char opcao = ' ';
        while (opcao != 'F') {
            System.out.println("Escolha uma opção: ");
            System.out.println("(A) Cadastrar produto");
            System.out.println("(B) Listar todos os produtos");
            System.out.println("(C) Pesquisar produto");
            System.out.println("(D) Alterar produto");
            System.out.println("(E) Remover produto");
            System.out.println("(F) Sair");
            opcao = teclado.next().toUpperCase().charAt(0);

            switch (opcao) {
                case 'A':
                    cadastrar(teclado, produtos);
                    break;
                case 'B':
                    System.out.println(produtos.listar());
                    break;
                case 'C':
                    System.out.print("Termo: ");
                    String termo = validarNome(teclado, produtos);
                    System.out.println(produtos.contains(termo));
                    break;
                case 'D':
                    alterar(teclado, produtos);
                    break;
                case 'E':
                    remover(teclado, produtos);
                    break;
                case 'F':
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }
    }

    private String validarNome(Scanner teclado, Vetor produtos) {
        String nome = teclado.next();

        while (nome.equals("")) {
            System.out.print("Digite um nome válido. \nNome do produto: ");
            nome = teclado.next();
        }
        return nome;
    }

    private double validarValor(Scanner teclado) {
        double valor = teclado.nextDouble();

        while (valor <= 0) {
            System.out.print("Digite um valor válido. \nValor (R$): ");
            valor = teclado.nextDouble();
        }
        return valor;
    }

    private void cadastrar(Scanner teclado, Vetor produtos) {
        System.out.print("Nome do produto: ");
        String nome = validarNome(teclado, produtos);

        while (produtos.getByName(nome) != -1) {
            System.out.print("Desculpe, produto de nome " + nome + " já cadastrado. \nNome do produto: ");
            nome = teclado.next();
        }

        System.out.print("Valor (R$): ");
        double valor = validarValor(teclado);

        Produto umProduto = new Produto(nome, valor);
        produtos.cadastrar(umProduto);
        System.out.println("Produto cadastrado com sucesso!\n");
    }

    private void remover(Scanner teclado, Vetor produtos) {
        System.out.print("Nome do produto a ser removido: ");
        String nome = validarNome(teclado, produtos);

        int indiceRemovido = produtos.getByName(nome);

        if (indiceRemovido == -1) {
            System.out.println("Item " + nome + " não encontrado.\n");
        } else {
            produtos.remover(indiceRemovido);
            System.out.println("Produto " + nome + " removido com sucesso!\n");
        }
    }

    private void alterar(Scanner teclado, Vetor produtos) {
        System.out.print("Nome do produto a ser alterado: ");
        String nome = validarNome(teclado, produtos);

        int indiceAlterado = produtos.getByName(nome);

        if (indiceAlterado == -1) {
            System.out.println("Item " + nome + " não encontrado.\n");

        } else {
            System.out.print("Novo nome: ");
            nome = validarNome(teclado, produtos);

            // Se o novo nome já pertencer ao vetor e não for o elemento alterado, este é solicitado novamente
            while (produtos.getByName(nome) != -1) {
                if (indiceAlterado == produtos.getByName(nome)) {
                    System.out.print("Deseja manter o mesmo nome? "); // Em caso de alterações apenas no valor
                    String resposta = teclado.next();

                    if (resposta.trim().equalsIgnoreCase("Sim")) {
                        break;
                    }
                } else {
                    System.out.print("Desculpe, produto de nome " + nome + " já cadastrado.\n");
                }
                System.out.print("\nNovo nome: ");
                nome = teclado.next();
            }
            System.out.print("Novo valor (R$): ");
            double valor = validarValor(teclado);

            produtos.alterar(indiceAlterado, nome, valor);
            System.out.println("Produto " + nome + " alterado com sucesso!\n");
        }
    }
}

