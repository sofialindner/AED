import java.text.DecimalFormat;

public class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        setNome(nome);
        setValor(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não deve ser vazio.");
        }
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser superior a zero.");
        }
        this.valor = valor;
    }

    public String toString() {
        DecimalFormat df_2 = new DecimalFormat("0.00");
        
        return nome + "  R$" + df_2.format(valor);
    }
}
