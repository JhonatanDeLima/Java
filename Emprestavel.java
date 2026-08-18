/**
 * Contrato para itens que podem ser emprestados pela biblioteca.
 * Qualquer item "emprestável" precisa saber informar sua disponibilidade
 * e alternar entre disponível/emprestado.
 */
public interface Emprestavel {

    boolean isDisponivel();

    void marcarComoEmprestado();

    void marcarComoDisponivel();
}
