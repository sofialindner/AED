public class Tarefa {
    private String descricao;
    private String importancia;

    public Tarefa(String descricao, String importancia) {
        setDescricao(descricao);
        setImportancia(importancia);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao.isEmpty() || descricao == null) {
            throw new IllegalArgumentException("Descrição não pode ser vazio ou nula.");
        }
        this.descricao = descricao;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        if (importancia.isEmpty() || importancia == null) {
            throw new IllegalArgumentException("Importância não pode ser vazio ou nula.");
        }
        this.importancia = importancia;
    }

    public String toString() {
        return descricao + "  (" + importancia + ")";
    }
}
