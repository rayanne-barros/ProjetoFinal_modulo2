package agendaContatos.ui;

import agendaContatos.controll.AgendaController;
import agendaContatos.model.Contatos;
import agendaContatos.util.ConsoleUIHelper;

import java.util.Scanner;

public class AgendaUI {

    AgendaController controller = new AgendaController();
    static final Scanner sc = new Scanner(System.in);
    char pad = '#';
    int width = 85;
    private Integer tamanhoPagina;
    private Integer posicaoAtual;

    public void mostrarMenu() {
        Boolean continuar = true;

        do {
            ConsoleUIHelper.drawHeader("AGENDA", width);
            //ConsoleUIHelper.fillVSpace(0, width);
            ConsoleUIHelper.drawWithPadding("Olá! Bem vindo(a) a sua agenda!", width);
            ConsoleUIHelper.drawWithPadding("Escolha uma opção!", width);
            ConsoleUIHelper.fillVSpace(0, width);
            ConsoleUIHelper.drawWithPadding("1 - Adicionar Contato", width);
            ConsoleUIHelper.drawWithPadding("2 - Listar contatos", width);
            ConsoleUIHelper.drawWithPadding("3 - Buscar Contato", width);
            ConsoleUIHelper.drawWithPadding("4 - Remover todos os contatos", width);
            ConsoleUIHelper.drawWithPadding("0 - Sair do Programa ", width);
            ConsoleUIHelper.fillVSpace(0, width);
            ConsoleUIHelper.drawLine(width);

            System.out.print("Escolha uma opção:  ");


            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    adicionarContato();

                    break;
                case "2":
                    subMenu(listarContatos());
                    break;
                case "3":
                    subMenu(pesquisarContatos());
                    ConsoleUIHelper.drawLine(width);
                    break;
                case "4":
                    excluirTodosContatos();
                    mostrarMenu();
                    ConsoleUIHelper.drawLine(width);
                    break;
                case "0":
                    continuar = false;
                    break;
                default:  {
                    ConsoleUIHelper.drawWithPadding("Opção invalida!", width);

                    ConsoleUIHelper.drawLine(width);
                    System.out.println();
                }
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
        ConsoleUIHelper.drawHeader("SUBMENU", width);

        ConsoleUIHelper.drawWithPadding("1 - Excluir contato", width);
        ConsoleUIHelper.drawWithPadding("2 - Adicionar um telefone", width);
        ConsoleUIHelper.drawWithPadding("3 - Adicionar um endereço", width);
        ConsoleUIHelper.drawWithPadding("4 - Remover um telefone", width);
        ConsoleUIHelper.drawWithPadding("5 - Remover um endereço", width);
        ConsoleUIHelper.drawWithPadding("6 - Exibir todas as informações do contato", width);
        ConsoleUIHelper.drawWithPadding("7 - Listar todos os telefones do contato", width);
        ConsoleUIHelper.drawWithPadding("8 - Listar todos os endereços do contato", width);
        ConsoleUIHelper.drawWithPadding("9 - Exibir todas informações de um telefone", width);
        ConsoleUIHelper.drawWithPadding("10 - Exibir todas informações de um endereço", width);
        ConsoleUIHelper.drawWithPadding("0 - Voltar ao menu", width);
        ConsoleUIHelper.drawLine(width);

        System.out.println("Escolha uma opção para realizar no contato: " + contato.getNome() + " " + contato.getSobrenome() + ": ");
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
            case "9" -> exibirTodasInformacoesTelefone(contato);
            case "10" -> exibirTodasInformacoesEndereco(contato);
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

    public void exibirTodasInformacoesTelefone(Contatos contato){
        controller.exibirTodasInformacoesTelefone(contato);
    }
    public void exibirTodasInformacoesEndereco(Contatos contato){
        controller.exibirTodasInformacoesEndereco(contato);
    }

}

