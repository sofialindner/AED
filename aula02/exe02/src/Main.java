import java.util.Scanner;
import java.util.Vector;

public class Main {
    Vector<String> vetor;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Scanner teclado = new Scanner(System.in);
        vetor = new Vector<>();
        
        char opcao = ' ';
        while (opcao != 'F') {
            System.out.println("Escolha uma opção: ");
            System.out.println("(A) - Cadastrar nome");
            System.out.println("(B) - Listar nomes");
            System.out.println("(C) - Pesquisar nome");
            System.out.println("(D) - Alterar nome");
            System.out.println("(E) - Remover nome");
            System.out.println("(F) - Finalizar");
            opcao = teclado.next().toUpperCase().charAt(0);

            switch (opcao) {
                case 'A':
                    System.out.println(cadastrar(teclado));
                    break;
                case 'B':
                    System.out.println(listar());
                    break;
                case 'C':
                    System.out.println(pesquisar(teclado));
                    break;
                case 'D':
                    System.out.println(alterar(teclado));
                    break;
                case 'E':
                    System.out.println(remover(teclado));
                    break;
                case 'F':
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }
        teclado.close();
    }

    public int getByName(String nome) {
        for (int i = 0; i < vetor.size() && vetor.get(i) != null; i++) {
            if (vetor.get(i).trim().toUpperCase().equals(nome.toUpperCase().trim())) {
                return i;
            } 
        }
        return -1;
    }
    
    private String cadastrar(Scanner teclado) {
        System.out.print("Nome: ");
        String nome = teclado.next();

        if (vetor.contains(nome)) {
            return "Desculpe, nome " + nome + " já consta na lista.\n";
        }
        vetor.add(nome);
        return "Nome adicionado com sucesso!\n";
    }

    private String listar() {
        String listagem = "NOMES\n";
        for (String nome : vetor) {
            listagem += nome + "\n";
        }
        return listagem;
    }

    private String pesquisar(Scanner teclado) {
        System.out.print("Termo de pesquisa: ");
        String termo = teclado.next();

        String nomesResultado = "";
        for (String nome : vetor) {
            if (nome.trim().toUpperCase().contains(termo.trim().toUpperCase())) {
                nomesResultado += nome + "\n";
            }
        }
        boolean noResults = nomesResultado.isEmpty();
        nomesResultado = "\nNOMES QUE CONTÊM: " + termo.toUpperCase() + "\n" + nomesResultado;

        if (noResults) {
            nomesResultado += "Não há nomes que correspondam à pesquisa.\n";
        }
        return nomesResultado;
    }

    private String alterar(Scanner teclado) {
        System.out.print("Nome a ser alterado: ");
        String nome = teclado.next();

        if (!vetor.contains(nome)) {
            return "Desculpe, nome não encontrado.\n";
        }
        int indice = getByName(nome);

        System.out.print("Novo nome: ");
        String novo = teclado.next().trim();

        char mesmoNome = ' ';
        while (vetor.contains(novo) && mesmoNome != 'S') {
            if (novo.equalsIgnoreCase(nome)) {
                System.out.print("Deseja manter o mesmo nome? [S]im  [N]ão\n");
                mesmoNome = teclado.next().toUpperCase().charAt(0);

                if (mesmoNome != 'S') {
                    System.out.print("Novo nome: ");
                    novo = teclado.next();
                }
            } else {
                return "Desculpe, o novo nome " + novo + " já pertence ao vetor.\n";
            }
        }
        vetor.set(indice, novo);
        return "Nome " + novo + " alterado com sucesso!";
    }

    private String remover(Scanner teclado) {
        System.out.println("Nome a ser removido: ");
        String nome = teclado.next();

        if (!vetor.contains(nome)) {
            return "Desculpe, nome não encontrado.\n";
        }
        vetor.remove(vetor.get(getByName(nome)));
        return "Nome " + nome + " removido com sucesso!\n";
    }
}