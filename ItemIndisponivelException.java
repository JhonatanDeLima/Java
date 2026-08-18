/**
 * Lançada quando alguém tenta emprestar um item que já está emprestado.
 */
public class ItemIndisponivelException extends Exception {

    public ItemIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
