☕ Sistema de Gerenciamento de Biblioteca

Sistema em Java, via console, para gerenciar o acervo e os empréstimos de uma biblioteca. Projeto desenvolvido para praticar Programação Orientada a Objetos.

📚 Conceitos de POO aplicados
Herança — Livro e Revista herdam de ItemAcervo
Classe abstrata — ItemAcervo define o comportamento comum e obriga as subclasses a implementar descricao()
Interface — Emprestavel define o contrato de disponibilidade
Polimorfismo — cada item descreve a si mesmo de forma diferente (descricao())
Encapsulamento — atributos privados com acesso controlado por getters
Tratamento de exceções — ItemIndisponivelException (exceção customizada) impede empréstimo de item já emprestado
Coleções — uso de List, Optional e streams para gerenciar acervo e empréstimos
🗂️ Estrutura
src/
├── Main.java                     # menu de console
├── Biblioteca.java                # serviço principal (acervo + empréstimos)
├── ItemAcervo.java                # classe abstrata
├── Livro.java                     # subclasse
├── Revista.java                   # subclasse
├── Emprestavel.java                # interface
├── Usuario.java
├── Emprestimo.java
└── ItemIndisponivelException.java # exceção customizada
▶️ Como executar

Com o JDK instalado:

bash
cd src
javac *.java
java Main
🖥️ Funcionalidades
Listar itens disponíveis
Emprestar um item (bloqueia se já estiver emprestado)
Devolver um item
Listar empréstimos em aberto
👤 Autor

Jhonatan de Lima Alves dos Santos — Estudante de Ciência da Computação
