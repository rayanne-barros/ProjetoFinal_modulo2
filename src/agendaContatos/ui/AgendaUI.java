package agendaContatos.ui;

import agendaContatos.controll.Agenda;

import java.util.Scanner;

public class AgendaUI {
    Agenda agenda = new Agenda();

    static final Scanner sc = new Scanner(System.in);
    private Integer tamanhoPagina;
    private Integer posicaoAtual;
    public void menuInicial() {
        System.out.println("Bem vindo(a) a sua agenda!");
        System.out.println("Digite uma das opções abaixo");
        System.out.println("1- Adicionar contato");
        System.out.println("2- Pesquisar contato");
        System.out.println("3- Excluir contato");
        System.out.println("4- Listar contato");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1" -> {
                this.adicionar();
            }
            case "2" -> {
                System.out.println("Pesquisou");
            }
            case "3" -> {
                System.out.println("Excluiu");
            }
            case "4" -> {
                tamanhoPagina = 2;
                posicaoAtual = 0;

                agenda.listar(posicaoAtual, tamanhoPagina).forEach(item -> {
                    System.out.println(item);
                });
            }
        }




    }

    public void adicionar() {
        System.out.println("Digite o nome do contato: ");
        String nomeContato = sc.nextLine();

        System.out.println("");
        System.out.println("Adicionou");
    }
}
