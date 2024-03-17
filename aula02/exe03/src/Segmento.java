import java.util.ArrayList;

public class Segmento {
    private String nome;
    private ArrayList<Produto> produtos;

    public Segmento(String nome) {
        setNome(nome);
        produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean cadastrar(Produto produto) {
        return getProdutos().add(produto);
    }
}
