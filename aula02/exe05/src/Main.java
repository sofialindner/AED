import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    Map<String, Livro> livros;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        livros = new HashMap<>();
        Scanner teclado = new Scanner(System.in);

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("Escolha uma opção: ");
            System.out.println("(1) - Cadastrar livro");
            System.out.println("(2) - Alterar livro");
            System.out.println("(3) - Remover Livro");
            System.out.println("(4) - Listar livros");
            System.out.println("(5) - Finalizar");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(cadastrar(teclado));
                    break;
                case 2:
                    System.out.println(alterar(teclado));
                    break;
                case 3:
                    System.out.println(remover(teclado));
                    break;
                case 4:
                    System.out.println(listar());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }
        teclado.close();
    }

    private String cadastrar(Scanner teclado) {
        System.out.print("Nome: ");
        String nome = teclado.next();

        if (livros.containsKey(nome)) 
            return "Desculpe, já há um livro de nome " + nome + " cadastrado.\n";
        
        System.out.print("Número de páginas: ");
        int qtdPaginas = teclado.nextInt();

        while (qtdPaginas <= 0) {
            System.out.print("Número de páginas inválido.\nNúmero de páginas: ");
            qtdPaginas = teclado.nextInt();
        }

        System.out.print("Número de páginas lidas: ");
        int qtdPaginasLidas = teclado.nextInt();

        while (qtdPaginasLidas < 0 || qtdPaginasLidas > qtdPaginas) {
            System.out.println("Número de páginas lidas inválido.\nNúmero de páginas lidas: ");
            qtdPaginasLidas = teclado.nextInt();
        }
        livros.put(nome, new Livro(nome, qtdPaginas, qtdPaginasLidas));
        return "Livro cadastrado com sucesso!\n";
    }

    private String alterar(Scanner teclado) {
        System.out.print("Nome: ");
        String nome = teclado.next();

        if (!livros.containsKey(nome))
            return "Desculpe, livro não encontrado.\n";
        
        System.out.println("Novo nome: ");
        String novoNome = teclado.next();

        while (livros.containsKey(nome)) {
            System.out.print("Livro já cadastrado.\nNovo nome: ");
            novoNome = teclado.next();
        }

        System.out.print("Novo número de páginas: ");
        int qtdPaginas = teclado.nextInt();

        while (qtdPaginas <= 0) {
            System.out.print("Número de páginas inválido.\nNovo número de páginas: ");
            qtdPaginas = teclado.nextInt();
        }

        System.out.print("Novo número de páginas lidas: ");
        int qtdPaginasLidas = teclado.nextInt();

        while (qtdPaginasLidas < 0 || qtdPaginasLidas > qtdPaginas) {
            System.out.print("Número de páginas lidas inválido.\nNovo número de páginas lidas: ");
            qtdPaginasLidas = teclado.nextInt();
        }
        Livro alterado = livros.get(nome);
        alterado.setNome(novoNome);
        alterado.setQtdPaginas(qtdPaginas);
        alterado.setQtdPaginasLidas(qtdPaginasLidas);
        return "Livro alterado com sucesso!\n";
    }

    private String remover(Scanner teclado) {
        System.out.println("Nome: ");
        String nome = teclado.next();

        if (!livros.containsKey(nome)) 
            return "Desculpe, livro não encontrado.\n";
        
        livros.remove(nome);
        return "Livro removido com sucesso!\n";
    }

    private String listar() {
        String naoComecados = "";
        String emAndamento = "";
        String concluidos = "";

        for (Livro l : livros.values()) {
            if (l.getQtdPaginasLidas() == 0) {
                naoComecados += l.toString() + "\n";
            } else if (l.getQtdPaginasLidas() == l.getQtdPaginas()) {
                concluidos += l.toString() + "\n";
            } else {
                emAndamento += l.toString() + "\n";
            }
        }
        if (naoComecados.isEmpty() && emAndamento.isEmpty() && concluidos.isEmpty())
            return "Não há livros cadastrados.";
            
        String retorno = "";
        if (!naoComecados.isEmpty())
            retorno += "\nNÃO COMEÇADOS\n" + naoComecados;
        if (!emAndamento.isEmpty()) 
            retorno += "\nEM ANDAMENTO\n" + emAndamento;
        if (!concluidos.isEmpty()) 
            retorno += "\nCONCLUÍDOS\n" + concluidos;
        return retorno;
    }
}
