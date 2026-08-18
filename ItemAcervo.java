/**
 * Classe base abstrata para qualquer item do acervo da biblioteca
 * (livros, revistas, etc.). Concentra os dados e comportamentos comuns
 * e implementa o contrato Emprestavel.
 */
public abstract class ItemAcervo implements Emprestavel {

    private final String titulo;
    private final String codigo;
    private boolean disponivel;

    protected ItemAcervo(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public void marcarComoEmprestado() {
        this.disponivel = false;
    }

    @Override
    public void marcarComoDisponivel() {
        this.disponivel = true;
    }

    /**
     * Cada tipo de item descreve a si mesmo de um jeito diferente
     * (polimorfismo) — é isso que o Livro e a Revista vão sobrescrever.
     */
    public abstract String descricao();
}
