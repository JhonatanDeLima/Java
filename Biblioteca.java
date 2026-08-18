import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {

    private final List<ItemAcervo> acervo = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarItem(ItemAcervo item) {
        acervo.add(item);
    }

    public Optional<ItemAcervo> buscarPorCodigo(String codigo) {
        return acervo.stream()
                .filter(item -> item.getCodigo().equals(codigo))
                .findFirst();
    }

    public Emprestimo emprestar(String codigoItem, Usuario usuario, LocalDate data)
            throws ItemIndisponivelException {

        ItemAcervo item = buscarPorCodigo(codigoItem)
                .orElseThrow(() -> new ItemIndisponivelException(
                        "Item com código " + codigoItem + " não encontrado."));

        if (!item.isDisponivel()) {
            throw new ItemIndisponivelException(
                    "\"" + item.getTitulo() + "\" já está emprestado no momento.");
        }

        item.marcarComoEmprestado();
        Emprestimo emprestimo = new Emprestimo(item, usuario, data);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public void devolver(String codigoItem, LocalDate data) {
        buscarPorCodigo(codigoItem).ifPresent(ItemAcervo::marcarComoDisponivel);

        emprestimos.stream()
                .filter(e -> e.getItem().getCodigo().equals(codigoItem) && !e.isDevolvido())
                .findFirst()
                .ifPresent(e -> e.registrarDevolucao(data));
    }

    public List<ItemAcervo> listarDisponiveis() {
        List<ItemAcervo> disponiveis = new ArrayList<>();
        for (ItemAcervo item : acervo) {
            if (item.isDisponivel()) {
                disponiveis.add(item);
            }
        }
        return disponiveis;
    }

    public List<Emprestimo> listarEmprestimosAbertos() {
        List<Emprestimo> abertos = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (!emprestimo.isDevolvido()) {
                abertos.add(emprestimo);
            }
        }
        return abertos;
    }

    public List<ItemAcervo> getAcervo() {
        return acervo;
    }
}
