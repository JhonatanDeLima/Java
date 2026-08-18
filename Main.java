import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final Biblioteca biblioteca = new Biblioteca();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        popularAcervoDeExemplo();

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("Encerrando o sistema. Até mais!");
    }

    private static void popularAcervoDeExemplo() {
        biblioteca.adicionarItem(new Livro("L001", "Clean Code", "Robert C. Martin", 2008));
        biblioteca.adicionarItem(new Livro("L002", "Efetive Java", "Joshua Bloch", 2018));
        biblioteca.adicionarItem(new Revista("R001", "Java Magazine", 145));
    }

    private static void exibirMenu() {
        System.out.println("\n===== Sistema de Biblioteca =====");
        System.out.println("1 - Listar itens disponíveis");
        System.out.println("2 - Emprestar item");
        System.out.println("3 - Devolver item");
        System.out.println("4 - Listar empréstimos em aberto");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> listarDisponiveis();
            case 2 -> realizarEmprestimo();
            case 3 -> realizarDevolucao();
            case 4 -> listarEmprestimosAbertos();
            case 0 -> { /* sai do loop */ }
            default -> System.out.println("Opção inválida, tente novamente.");
        }
    }

    private static void listarDisponiveis() {
        System.out.println("\n-- Itens disponíveis --");
        for (ItemAcervo item : biblioteca.listarDisponiveis()) {
            System.out.println("[" + item.getCodigo() + "] " + item.descricao());
        }
    }

    private static void realizarEmprestimo() {
        System.out.print("Código do item: ");
        String codigo = scanner.nextLine().trim();
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine().trim();

        Usuario usuario = new Usuario(nome, matricula);

        try {
            Emprestimo emprestimo = biblioteca.emprestar(codigo, usuario, LocalDate.now());
            System.out.println("Empréstimo realizado: " + emprestimo);
        } catch (ItemIndisponivelException e) {
            System.out.println("Não foi possível emprestar: " + e.getMessage());
        }
    }

    private static void realizarDevolucao() {
        System.out.print("Código do item a devolver: ");
        String codigo = scanner.nextLine().trim();
        biblioteca.devolver(codigo, LocalDate.now());
        System.out.println("Devolução registrada (se havia empréstimo em aberto para esse item).");
    }

    private static void listarEmprestimosAbertos() {
        System.out.println("\n-- Empréstimos em aberto --");
        for (Emprestimo emprestimo : biblioteca.listarEmprestimosAbertos()) {
            System.out.println(emprestimo);
        }
    }
}
