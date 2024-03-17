public class Produto {
    private String nome;
    private int codigo;
    private double valor;

    public Produto(String nome, int codigo, double valor) {
        setNome(nome);
        setCodigo(codigo);
        setValor(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
