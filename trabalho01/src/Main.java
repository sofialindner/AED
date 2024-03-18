import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private Queue<Tarefa> tarefas;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        tarefas = new LinkedList<>();
        Scanner teclado = new Scanner(System.in);

        int opcao = ' ';
        while (opcao != 5) {
            System.out.println("Escolha uma opção: ");
            System.out.println("(1) - Adicionar tarefa");
            System.out.println("(2) - Concluir tarefa");
            System.out.println("(3) - Visualizar próxima tarefa");
            System.out.println("(4) - Visualizar tarefas");
            System.out.println("(5) - Finalizar");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(adicionar(teclado));
                    break;
                case 2:
                    concluir();
                    break;
                case 3:
                    System.out.println(exibirProxima());
                    break;
                case 4:
                    System.out.println(exibirTarefas());
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

    // Método de cadastro de uma nova tarefa (única), com sua respectiva descrição e importância
    private String adicionar(Scanner teclado) {
        System.out.print("Descrição: ");
        String descricao = teclado.next();

        if (tarefaCadastrada(descricao)) 
            return "Desculpe, tarefa já adicionada.\n";

        System.out.println("Importância:\n(!) - Baixa\n(!!) - Média\n(!!!) - Alta");
        String importancia = teclado.next();
        
        while (!importancia.trim().equals("!") &&
             !importancia.trim().equals("!!") &&
             !importancia.trim().equals("!!!")) {
            System.out.println("Informe uma importância válida.\nImportância:\n(!) - Baixa\n(!!) - Média\n(!!!) - Alta");
            importancia = teclado.next();
        }
        tarefas.add(new Tarefa(descricao, importancia));
        return "Tarefa adicionada com sucesso!\n";
    }

    // Método de conclusão de uma tarefa (registro mais antigo)
    private void concluir() {
        tarefas.remove();
        System.out.println("Tarefa concluída!\n");
    }

    // Método de exibição da próxima tarefa (registro mais antigo)
    private String exibirProxima() {
        return "\nPRÓXIMA TAREFA:\n" + tarefas.peek().toString() + "\n";
    }

    // Método de listagem de todas as tarefas
    private String exibirTarefas() {
        String listaTarefas = "";
        for (Tarefa t : tarefas) {
            listaTarefas += "- " + t.toString() + "\n";
        }

        if (listaTarefas.isEmpty())
            return "Não há tarefas a serem concluídas.\n";
        return "TO-DO LIST\n" + listaTarefas;
    }

    // Método de verificação de existência de uma tarefa na lista
    private boolean tarefaCadastrada(String novaTarefa) {
        for (Tarefa t : tarefas) {
            if (t.getDescricao().trim().equalsIgnoreCase(novaTarefa)) {
                return true;
            }
        }
        return false;
    }
}
