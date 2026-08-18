import java.time.LocalDate;

public class Emprestimo {

    private final ItemAcervo item;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(ItemAcervo item, Usuario usuario, LocalDate dataEmprestimo) {
        this.item = item;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
    }

    public ItemAcervo getItem() {
        return item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public boolean isDevolvido() {
        return dataDevolucao != null;
    }

    public void registrarDevolucao(LocalDate data) {
        this.dataDevolucao = data;
    }

    @Override
    public String toString() {
        String status = isDevolvido() ? "devolvido em " + dataDevolucao : "em aberto";
        return String.format("%s -> %s | emprestado em %s | %s",
                usuario.getNome(), item.getTitulo(), dataEmprestimo, status);
    }
}
