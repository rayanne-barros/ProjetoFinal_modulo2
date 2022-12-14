package agendaContatos.ui;

import agendaContatos.controll.AgendaController;
import agendaContatos.model.Contatos;

import java.util.Scanner;

public class AgendaUI {
    AgendaController controller = new AgendaController();
    static final Scanner sc = new Scanner(System.in);
    private Integer tamanhoPagina;
    private Integer posicaoAtual;

    public void mostrarMenu() {
        Boolean continuar = true;

        do {
            System.out.print("""
                    Digite a opção que você deseja: 
                    
                    1 - Adicionar Contato
                    2 - Listar contatos
                    3 - Buscar Contato
                    4 - Remover todos os contatos
                    0 - Sair do Programa                    
                    """);

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    adicionarContato();
                    mostrarMenu();
                    break;
                case "2":
                    subMenu(listarContatos());
                    break;
                case "3":
                    subMenu(pesquisarContatos());
                    break;
                case "4":
                    excluirTodosContatos();
                    mostrarMenu();
                    break;
                case "0":
                    continuar = false;
                    break;
            }

        } while (continuar);
    }

    private void adicionarContato() {
        controller.adicionarContato();

    }

    public Contatos listarContatos() {
        return controller.listarContatos();
    }

    public Contatos pesquisarContatos() {
        return controller.pesquisarContatos();
    }

    private void excluirTodosContatos() {
        controller.excluirTodosContatos();
    }

    public void subMenu(Contatos contato) {

        System.out.print("Escolha uma opção para realizar no contato " + contato.getNome() + " " + contato.getSobrenome() + ": ");
        System.out.println("""                
                                
                1 - Excluir contato
                2 - Adicionar um telefone
                3 - Adicionar um endereço
                4 - Remover um telefone
                5 - Remover um endereço
                6 - Exibir todas as informações do contato
                7 - Listar todos os telefones do contato
                8 - Listar todos os endereços do contato
                0 - Voltar ao menu
                """);


      /*

      "Exibir todas as informações de telefone e endereço" não é uma escolha no menu. Motivo: ao listar o telefone já mostrar todos os índices,
      o usuário vai somente escolher o índice que ele quer e automaticamente todas as informações daquele telefone aparecerão.
      Mesma coisa para endereço.

      System.out.println("1 - Exibir todas as informações de um telefone de um contato da agenda");
      System.out.println("2 - Exibir todas as informações de um endereço de um contato da agenda");

       */
        String escolha = sc.nextLine();

        switch (escolha) {
            case "1" -> excluirContato(contato);
            case "2" -> adicionarTelefoneContato(contato);
            case "3" -> adicionarEnderecoContato(contato);
            case "4" -> removerTelefoneContato(contato);
            case "5" -> removerEnderecoContato(contato);
            case "6" -> exibirInformacoesContato(contato);
            case "7" -> listarTodosTelefonesContato(contato);
            case "8" -> listarTodosEnderecosContato(contato);
            case "0" -> mostrarMenu();
        }
    }

    private void excluirContato(Contatos contato) {
        controller.excluirContato(contato);
    }

    public void adicionarTelefoneContato(Contatos contato) {
        controller.adicionarTelefoneEmContatoExistente(contato);
    }

    public void adicionarEnderecoContato(Contatos contato) {
        controller.adicionarEnderecoContatoExistente(contato);
    }

  /*  public void adicionarTelefoneContato(Contatos contato) {
        controller.adicionarTelefoneContato(contato);
    }


    public void adicionarEnderecoContato(Contatos contato) {
        controller.adicionarEnderecoContato(contato);
    }*/

    public void removerTelefoneContato(Contatos contato) {
        controller.removerTelefoneContato(contato);
    }

    public void removerEnderecoContato(Contatos contato) {
        controller.removerEnderecoContato(contato);
    }


    public void exibirInformacoesContato(Contatos contato) {
        controller.exibirTodasInformacoesContato(contato);
    }


    public void listarTodosTelefonesContato(Contatos contato) {
        controller.listarTodosTelefonesContato(contato);
    }

    public void listarTodosEnderecosContato(Contatos contato) {
        controller.listarTodosEnderecosContato(contato);
    }

}

