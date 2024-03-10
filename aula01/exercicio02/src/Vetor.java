public class Vetor {
    private String[] vetor;
    private int indice; // Atributo de controle da próxima posição do vetor a ser preenchida

    public Vetor(int tamanho) {
        vetor = new String[tamanho];
        setIndice(0); // Registro de nomes parte da posição zero
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        if (indice < 0 || indice >= getVetor().length) {
            throw new IllegalArgumentException("Índice deve ser igual ou maior a zero e menor que a length.");
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
        getVetor()[indice] = nome;
        indice ++;
    }

    public void remover(int posicao) {
        // Índices a partir da posição do elemento removido pegam o conteúdo do da frente
        for (int i = posicao; i < getVetor().length - 1; i++) {
            getVetor()[i] = getVetor()[i+1];
        }
        // A posição removida torna-se nula e o valor do atributo índice também é alterado a fim de que seja utilizado no próximo registro
        indice --;
        getVetor()[indice] = null;
    }

    public void alterar(int posicao, String novoNome) {
        getVetor()[posicao] = novoNome;
    }

    public String listar() {
        if (getVetor()[0] == null) {
            return ("Não há nomes cadastrados.\n");
        }
        String retorno = "NOMES\n";
        for (int i = 0; i < getVetor().length && getVetor()[i] != null; i ++) {
            retorno += i + ". " + getVetor()[i] + "\n";
        }
        return retorno;
    }
}
