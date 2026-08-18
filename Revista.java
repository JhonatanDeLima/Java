public class Revista extends ItemAcervo {

    private final int edicao;

    public Revista(String codigo, String titulo, int edicao) {
        super(codigo, titulo);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public String descricao() {
        return String.format("Revista: \"%s\" — edição %d", getTitulo(), edicao);
    }
}
