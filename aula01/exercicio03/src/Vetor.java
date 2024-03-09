public class Vetor {
    private Produto[] vetor;

    public Vetor() {
        vetor = new Produto[0];
    }

    public Produto[] getVetor() {
        return vetor;
    }

    public void setVetor(Produto[] vetor) {
        this.vetor = vetor;
    }

    public void cadastrar(Produto produto) {
        int tamanho = getVetor().length;

        Produto[] temporario = new Produto[tamanho + 1];

        for (int i = 0; i < getVetor().length; i++) {
            temporario[i] = getVetor()[i];
        }

        temporario[tamanho] = produto;
        setVetor(temporario);
    }

    public void remover(int posicao) {
        int tamanho = getVetor().length;

        Produto[] temporario = new Produto[tamanho - 1];

        for (int i = 0; i < vetor.length - 1; i++) {
            if (i >= posicao) {
                temporario[i] = getVetor()[i + 1];
            } else {
                temporario[i] = getVetor()[i];
            }
        }
        setVetor(temporario);
    }

    public void alterar(int posicao, String nome, double valor) {
        getVetor()[posicao].setNome(nome);
        getVetor()[posicao].setValor(valor);
    }

    public String listar() {
        if (getVetor()[0] == null) {
            return "\nNão há produtos cadastrados.\n";
        }
        
        String retorno = "\nPRODUTOS\n";
        for (int i = 0; i < getVetor().length && getVetor()[i] != null; i ++) {
            retorno += getVetor()[i].toString() + "\n";
        }
        return retorno;
    }

    public int getByName(String nome) {
        for (int i = 0; i < getVetor().length && getVetor()[i] != null; i ++) {
            if (getVetor()[i].getNome().trim().toUpperCase().equals(nome.toUpperCase())) {
                return i;
            } // Pertencendo ao vetor, método retorna índice do produto procurado
        }
        // Caso não pertença ao vetor, retorna -1, que é um índice inválido qualquer equivalente a um False para o resultado da busca
        return -1;
    }

    public String contains(String termo) {
        boolean contemTermo = false;
        String retorno = "\nPRODUTOS QUE CONTÊM: \"" + termo.toUpperCase() + "\"\n"; 
        for (int i = 0; i < getVetor().length; i ++) {
            if (getVetor()[i].getNome().toUpperCase().contains(termo.trim().toUpperCase())) {
                retorno += getVetor()[i].toString() + "\n";
                contemTermo = true;
            }
        }

        if (contemTermo) {
            return retorno;
        } else {
            return retorno + "Desculpe, não há produtos com o termo pesquisado.";
        }
    }
}
