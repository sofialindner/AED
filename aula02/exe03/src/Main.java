import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Segmento> segmentos;
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Scanner teclado = new Scanner(System.in);
        segmentos = new ArrayList<>();
        segmentos.add(new Segmento("Eletrônicos e Tecnologia"));
        segmentos.add(new Segmento("Beleza e Higiene"));
        segmentos.add(new Segmento("Mercearia"));
        segmentos.add(new Segmento("Frios e Congelados"));
        segmentos.add(new Segmento("Hortifruti"));

        char operacao = ' ';
        while (operacao != 'D') {        
            System.out.println("Escolha uma operação: ");
            System.out.println("(A) - Cadastrar");
            System.out.println("(B) - Listar");
            System.out.println("(C) - Remover");
            System.out.println("(D) - Finalizar");
            operacao = teclado.next().toUpperCase().charAt(0);

            if (operacao != 'D') {
                System.out.println("\nEscolha o objeto: ");
                System.out.println("(S) - Segmento");
                System.out.println("(P) - Produto");
                char objeto = teclado.next().toUpperCase().charAt(0);

                switch (objeto) {
                    case 'S':
                        switch (operacao) {
                            case 'A':
                                System.out.println(cadastrarSegmento(teclado));
                                break;
                            case 'B':
                                System.out.println("\nSEGMENTOS\n" + listarSegmentos());
                                break;
                            case 'C':
                                System.out.println(removerSegmento(teclado));
                                break;
                            default:
                                System.out.println("Operação inválida.\n");
                        }
                        break;
                    case 'P':
                        switch (operacao) {
                            case 'A':
                                System.out.println(cadastrarProduto(teclado));
                                break;
                            case 'B':
                                System.out.println(listarProdutos());
                                break;
                            case 'C':
                                System.out.println(removerProduto(teclado));
                                break;
                            default:
                                System.out.println("Operação inválida.\n");
                        }
                        break;
                    default:
                        System.out.println("Opção de objeto inválida.\n");
                        break;
                }
            }
        }
        teclado.close();
    }

    private String cadastrarSegmento(Scanner teclado) {
        System.out.print("Nome do segmento: ");
        String nome = teclado.next();

        for (Segmento s : segmentos) {
            if (s.getNome().trim().equalsIgnoreCase(nome.trim())) {
                return "Desculpe, segmento já cadastrado.\n";
            }
        }
        segmentos.add(new Segmento(nome));
        return "Segmento cadastrado com sucesso!\n";
    }

    private String listarSegmentos() {
        String menuSegmentos = "";
        for (int i = 0; i < segmentos.size(); i++) {
            menuSegmentos += i + " - " + segmentos.get(i).getNome() + "\n";
        }
        
        if (menuSegmentos.isEmpty()) {
            return "Não há segmentos cadastrados.";
        }
        return menuSegmentos;
    }

    private String removerSegmento(Scanner teclado) {
        System.out.println("SEGMENTOS\n" + listarSegmentos());
        int indice = teclado.nextInt();

        if (indice < 0 || indice >= segmentos.size()) {
            return "Desculpe, opção de segmento inválida.\n";
        }
        segmentos.remove(indice);
        return "Segmento removido com sucesso!\n";
    }

    private String cadastrarProduto(Scanner teclado) {
        System.out.print("\nEscolha o segmento:\n" + listarSegmentos());
        int indiceSegmento = teclado.nextInt();

        while (indiceSegmento < 0 || indiceSegmento >= segmentos.size()) {
            System.out.println("Desculpe, opção de segmento inválida.\n");
            System.out.println("\nEscolha o segmento:\n" + listarSegmentos());
            indiceSegmento = teclado.nextInt();
        }

        System.out.print("Nome do produto: ");
        String nome = teclado.next();

        if (produtoCadastrado(nome))
            return "Desculpe, já existe um produto sob o nome " + nome + ".\n";

        System.out.print("Código: ");
        int codigo = teclado.nextInt();

        if (produtoCadastrado(Integer.toString(codigo)))
            return "Desculpe, já existe um produto sob o código " + codigo + ".\n";

        System.out.print("Valor (R$): ");
        double valor = teclado.nextDouble();

        segmentos.get(indiceSegmento).cadastrar(new Produto(nome, codigo, valor));
        return "Produto cadastrado com sucesso!\n";
    }

    private boolean produtoCadastrado(String id) {
        boolean isCodigo = id.matches("[0-9*]");
        
        for (Segmento s : segmentos) {
            for (Produto p : s.getProdutos()) {
                if (isCodigo) {
                    if (p.getCodigo() == Integer.parseInt(id))
                        return true;
                } else {
                    if (p.getNome().trim().equalsIgnoreCase(id.trim()))
                        return true;
                }
            }
        }
        return false;
    }

    private String listarProdutos() {
        String listaProdutos = "";
        for (Segmento s : segmentos) {
            if (!s.getProdutos().isEmpty())
                listaProdutos += "\n" + s.getNome().toUpperCase() + "\n";

            for (Produto p : s.getProdutos()) {
                listaProdutos += p.getNome() + "\n";
            }
        }

        if (listaProdutos.trim().isEmpty())
            return "Não há produtos cadastrados.\n";
        return listaProdutos;
    }

    private String removerProduto(Scanner teclado) {
        System.out.println("Nome ou código do produto: ");
        String id = teclado.next();

        Produto removido = null;
        for (Segmento s : segmentos) {
            for (int i = 0; i < s.getProdutos().size(); i++) {
                if (s.getProdutos().get(i).getNome().trim().equalsIgnoreCase(id.trim()) ||
                    s.getProdutos().get(i).getCodigo() == Integer.parseInt(id)) {
                    removido = s.getProdutos().remove(i);
                }
            }
        }
        if (removido == null)
            return "Desculpe, produto " + id + " não encontrado.\n";
        return "Produto removido com sucesso!\n";
    }
}
