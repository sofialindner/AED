public class Vetor {
    private String[] vetor;
    private int indice;

    public Vetor(int tamanho) {
        setIndice(0);
        vetor = new String[tamanho];
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        if (indice < 0) {
            throw new IllegalArgumentException("Índice deve ser igual ou maior que zero.");
        }
        this.indice = indice;
    }

    public String[] getVetor() {
        return vetor;
    }

    public void setVetor(String[] vetor) {
        this.vetor = vetor;
    }

    public void cadastrar(String nome) {
        vetor[indice] = nome;
        indice ++;
    }

    public void remover(int posicao) {
        for (int i = posicao; i < vetor.length - 1; i++) {
            vetor[i] = vetor[i+1];
        }
        indice --;
        vetor[indice] = null;
    }

    public void alterar(int posicao, String novoNome) {
        vetor[posicao] = novoNome;
    }

    public String listar() {
        if (getVetor()[0] == null) {
            return ("Não há nomes cadastrados.\n");
        }
        String retorno = "NOMES\n";
        for (int i = 0; i < vetor.length && vetor[i] != null; i ++) {
            retorno += i + ". " + vetor[i] + "\n";
        }
        return retorno;
    }
}
