public class Livro extends ItemAcervo {

    private final String autor;
    private final int anoPublicacao;

    public Livro(String codigo, String titulo, String autor, int anoPublicacao) {
        super(codigo, titulo);
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public String descricao() {
        return String.format("Livro: \"%s\" — %s (%d)", getTitulo(), autor, anoPublicacao);
    }
}
