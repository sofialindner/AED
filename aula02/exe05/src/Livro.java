public class Livro {
    private String nome;
    private int qtdPaginas;
    private int qtdPaginasLidas;

    public Livro(String nome, int qtdPaginas, int qtdPaginasLidas) {
        setNome(nome);
        setQtdPaginas(qtdPaginas);
        setQtdPaginasLidas(qtdPaginasLidas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty() || nome == null) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        if (qtdPaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
        }
        this.qtdPaginas = qtdPaginas;
    }

    public int getQtdPaginasLidas() {
        return qtdPaginasLidas;
    }

    public void setQtdPaginasLidas(int qtdPaginasLidas) {
        if (qtdPaginasLidas < 0) {
            throw new IllegalArgumentException("Número de páginas lidas deve ser maior que zero.");
        }
        this.qtdPaginasLidas = qtdPaginasLidas;
    }

    public String toString() {
        return getNome() + " (" + getQtdPaginasLidas() + "/" + getQtdPaginas() + ")";
    }
}
