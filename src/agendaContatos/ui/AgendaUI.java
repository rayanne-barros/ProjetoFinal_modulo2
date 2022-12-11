package agendaContatos.ui;

import agendaContatos.controll.AgendaController;
import agendaContatos.enums.TipoContato;
import agendaContatos.enums.TipoEndereco;
import agendaContatos.enums.TipoTelefone;
import agendaContatos.model.Agenda;
import agendaContatos.model.Contatos;
import agendaContatos.model.Endereco;
import agendaContatos.model.Telefone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AgendaUI {
    AgendaController controller = new AgendaController();

    static final Scanner sc = new Scanner(System.in);
    private Integer tamanhoPagina;
    private Integer posicaoAtual;
    public void mostrarMenu() {
        Boolean continuar = true;

        do {
            System.out.println("Bem vindo(a) a sua agenda!");
            System.out.println("Olá! Digite a opção que você deseja: ");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar Contato");
            System.out.println("4 - Remover  contato");
            System.out.println("5 - Adicionar telefone para contato");
            System.out.println("6 - Adicionar um endereço a um contato");
            System.out.println("7 - Remover um telefone de um contato da agenda");
            System.out.println("8 - Remover um endereço de um contato da agenda");
            System.out.println("9 - Exibir todas as informações de um contato da agenda");
            System.out.println("10 - Listar todos os telefones de um contato da agenda");
            System.out.println("11 - Listar todos os endereços de um contato da agenda");
            System.out.println("12 - Exibir todas as informações de um telefone de um contato da agenda");
            System.out.println("13 - Exibir todas as informações de um endereço de um contato da agenda");
            System.out.println("0 - Sair do Programa ");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1" : adicionarContato(); break;
                case "2" : listarContatos(); break;
                case "3" : pesquisarContatos(); break;
                case "4" : subMenuExcluir(); break;
                case "10" : listarTodosTelefonesContato(); break;
                case "11" : listarTodosEnderecosContato(); break;
                case "0" : continuar = false; break;
            }

        }while (continuar);
    }

        public List<Endereco> mostrarMenuCadastroEndereco(){

            Boolean continuar = true;

            List <Endereco> enderecos = new ArrayList<>();

            do {
                System.out.println("\nDESEJA ADCIONAR ENDEREÇO? \n");
                System.out.println("Digite uma das opções abaixo: ");
                System.out.println("1-  SIM");
                System.out.println("0 - NÃO");

                System.out.print("DIGITE SUA OPÇÃO: ");

                String opcao = sc.nextLine();

                if (opcao.equals("0")){
                    break;
                }

                Endereco endereco = new Endereco("","","","","","","","", TipoEndereco.RESIDENCIAL);

                System.out.print("\nDIGITE O PAÍS: ");
                endereco.setPais(sc.nextLine().trim());

                System.out.print("DIGITE O CEP: ");
                endereco.setCep(sc.nextLine().trim());

                System.out.print("DIGITE O LOGRADOURO: ");
                endereco.setLogradouro(sc.nextLine().trim());

                System.out.print("DIGITE O NUMERO DA CASA: ");
                endereco.setNumero(sc.nextLine().trim());

                System.out.print("DIGITE O BAIRRO: ");
                endereco.setBairro(sc.nextLine().trim());

                System.out.print("DIGITE A CIDADE: ");
                endereco.setCidade(sc.nextLine().trim());

                System.out.print("DIGITE O ESTADO: ");
                endereco.setEstado(sc.nextLine().trim());

                System.out.print("DIGITE O COMPLEMENTO: ");
                endereco.setComplemento(sc.nextLine().trim());

                System.out.println("TIPO DE ENDERECO: " + "(COMERCIAL, RESIDENCIAL, VIZINHO)");
                endereco.setTipo(sc.nextLine().toUpperCase().trim());

                enderecos.add(endereco);

            }while (continuar);
            return enderecos;
        }
        public List<Telefone> mostrarMenuCadastroTelefone(){
            Boolean continuar = true;
            List <Telefone> telefones = new ArrayList<>();

            do {

                System.out.println("\nDESEJA ADCIONAR TELEFONE? ");
                System.out.println("Digite uma das opções abaixo");
                System.out.println("1-  SIM");
                System.out.println("0 - NÃO");

                System.out.print("DIGITE SUA OPÇÃO: ");

                String opcao = sc.nextLine();

                if (opcao.equals("0")){ break;}

                Telefone telefone = new Telefone("","","","","",TipoTelefone.CELULAR);

                System.out.print("\nDIGITE O DDI: ");
                telefone.setDdi(sc.nextLine().trim());

                System.out.print("DIGITE O DDD: ");
                telefone.setDdd(sc.nextLine().trim());

                System.out.print("DIGITE O NUMERO: ");
                telefone.setNumero(sc.nextLine().trim());

                System.out.print("DIGITE O RAMAL: ");
                telefone.setRamal(sc.nextLine().trim());

//                System.out.print("DIGITE O NOME DO CONTATO: ");
//                telefone.setContato(sc.nextLine().trim());

                System.out.println("TIPO DE TELEFONE:  " + "(CELULAR, COMERCIAL, RESIDENCIAL)");
                telefone.setTipo(sc.nextLine().toUpperCase().trim());

                telefones.add(telefone);

            }while (continuar);

            return telefones;
        }
        private void adicionarContato() {

            Contatos contato = new Contatos("","","", TipoContato.PESSOAL);

            System.out.print("\nDIGITE O NOME DO CONTATO: ");
            contato.setNome(sc.nextLine().trim().toUpperCase());

            System.out.print("DIGITE O SOBRENOME DO CONTATO: ");
            contato.setSobrenome(sc.nextLine().trim().toUpperCase());

            System.out.print("DIGITE O EMAIL DO CONTATO: ");
            contato.setEmail(sc.nextLine().trim().toLowerCase());

            System.out.println("DIGITE O TIPO DO CONTATO: " + "(PESSOAL, PROFISSIONAL)");
            contato.setTipo(sc.nextLine().toUpperCase().trim());

            /* System.out.println("DIGITE O DATA DE NASCIMENTO DO CANTATO");
            LocalDate dataDeNasciment = LocalDate.parse(sc.nextLine());*/

            contato.setEnderecos(mostrarMenuCadastroEndereco());
            contato.setTelefones(mostrarMenuCadastroTelefone());

            controller.adicionarContato(contato);
            mostrarContato(contato);
        }

        private void listarContatos() {
            System.out.println("Contatos cadastrados: ");
            List<Contatos> lstContatosCadastrados = controller.listarContatos();
            for (Contatos contato : lstContatosCadastrados) {
                System.out.println("\nNOME Completo: " + contato.getNome().toUpperCase() + " " + contato.getSobrenome().toUpperCase());
                System.out.println("E-MAIL: " + contato.getEmail().toLowerCase());
                System.out.println("TIPO DE CONTATO: " + contato.getTipo());

            }
        }



        public void mostrarContato(Contatos contato){


            System.out.println("\nNOME: " + contato.getNome().toUpperCase() + " " + contato.getSobrenome().toUpperCase());
            System.out.println("E-MAIL: " + contato.getEmail().toLowerCase());
            System.out.println("TIPO DE CONTATO: " + contato.getTipo());

            System.out.println("\nTelefones: \n");

            contato.getTelefones().stream().forEach(telefone -> {
                Integer id = contato.getTelefones().indexOf(telefone);
                System.out.println("\nIDENTIFICADOR: " + id);
                System.out.println("TELEFONE: " + telefone.getDdi() + " " + telefone.getDdd() + " " + telefone.getNumero() );
                System.out.println("RAMAL: " + telefone.getRamal());
                System.out.println("TIPO DE TELEFONE: " + telefone.getTipo());


            });

            System.out.println("\nEndereços: \n");
            contato.getEnderecos().stream().forEach(endereco -> {
                Integer id = contato.getEnderecos().indexOf(endereco);
                System.out.println("\nIDENTIFICADOR: " + id);
                System.out.println("PAIS: " + endereco.getPais());
                System.out.println("RUA: " + endereco.getLogradouro());
                System.out.println("NÚMERO: " + endereco.getNumero());
                System.out.println("BAIRRO: " + endereco.getBairro());
                System.out.println("CEP: " + endereco.getCep());
                System.out.println("MUNICIPIO: " + endereco.getCidade() + " - " + endereco.getEstado());
                System.out.println("COMPLEMENTO: " + endereco.getComplemento());
                System.out.println("TIPO DE ENDEREÇO: " + endereco.getTipo());
                System.out.println();

            });

        }
        private void pesquisarContatos() {

        }

    private void excluirContato() {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

        listarContatos();

        System.out.println("Digite o nome do contato a ser excluído.");
        String nome = sc.nextLine().toUpperCase();

        //pesquisarContato;
        List<Contatos> contatosEncontrados = new ArrayList<>();
        for (int i = 0; i < agenda.getContatos().size(); i++) {
            if(agenda.getContatos().get(i).getNome().contains(nome)){
                contatosEncontrados.add(agenda.getContatos().get(i));
            }
        }

        for (int i = 0; i < contatosEncontrados.size(); i++) {
            System.out.println(i + ". NOME Completo: " + contatosEncontrados.get(i).getNome().toUpperCase() + " " + contatosEncontrados.get(i).getSobrenome().toUpperCase());
        }

        System.out.println("Digite o índice do contato a ser excluído.");
        String opcaoEscolhida = sc.nextLine();
        String opcaoEscolhida1 = validarOpcoes(contatosEncontrados.size(), opcaoEscolhida, "Digite o índice a ser digitado novamente");

        System.out.println("Você tem certeza que deseja excluir a opção " + opcaoEscolhida1 + ". "
                + contatosEncontrados.get(Integer.valueOf(opcaoEscolhida1))
                +  "? (0 - Não / 1 - Sim");
        String opcaoNaoSim = sc.nextLine();
        String opcaoEscolhida2 = validarOpcoes(2, opcaoNaoSim, "Você tem certeza que deseja excluir a opção "
                + opcaoEscolhida1 + "? Digite 0 caso 'Não' e 1 caso 'Sim'.");

        if (opcaoEscolhida2.equals("0")) {
            subMenuExcluir();
        } else if (opcaoEscolhida2.equals("1")) {
            agenda.removerContato(contatosEncontrados.get(Integer.valueOf(opcaoEscolhida1)));
            System.out.println("O contato foi excluído.");
            subMenuExcluir();
        }

    }

    private void excluirTodosContatos() {
        Scanner sc = new Scanner (System.in);
        Agenda agenda = new Agenda();

        System.out.println("Você tem certeza que deseja excluir todos os contatos? (0 - Não / 1 - Sim");
        String opcaoNaoSim = sc.nextLine();
        String opcaoEscolhida1 = validarOpcoes(2, opcaoNaoSim, "Você tem certeza que deseja excluir todos os contatos?" +
                " Digite 0 caso 'Não' e 1 caso 'Sim'.");

        if (opcaoEscolhida1.equals("0")) {
            subMenuExcluir();
        } else if (opcaoEscolhida1.equals("1")) {
            agenda.removerTodosContatos();
            System.out.println("Todos os contatos foram excluídos!");
            mostrarMenu();
        }
    }

    public void subMenuExcluir() {
        Scanner sc = new Scanner (System.in);
        boolean continuar = true;
        String subMenu = "";

        while (continuar) {
            System.out.println("Escolha uma opção:" +
                    "\n1 - Excluir um contato." +
                    "\n2 - Excluir todos os contatos." +
                    "\n3 - Voltar ao menu ");
            subMenu = sc.nextLine();

            switch (subMenu) {
                case "1" -> {
                    System.out.println("Excluir um contato.");
                    continuar = false;
                    excluirContato();
                }
                case "2" -> {
                    System.out.println("Excluir todos os contatos.");
                    continuar = false;
                    excluirTodosContatos();
                }
                case "3" -> {
                    System.out.println("Voltar ao menu.");
                    mostrarMenu();
                    continuar = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public static String validarOpcoes (Integer quantidadeOpcoes, String opcaoEscolhida, String mensagem) {
        Scanner sc = new Scanner (System.in);
        boolean continuar = true;

        while (continuar) {
            for (int i = 0; i < quantidadeOpcoes; i++) {
                if (opcaoEscolhida.equals(Integer.toString(i))) {
                    return opcaoEscolhida;
                }
            }
            System.out.println("Opção inválida.");
            System.out.println(mensagem);
            opcaoEscolhida = sc.nextLine();
        }
        return "Erro. Inicie o programa novamente.";
    }


    public void listarTodosTelefonesContato() {

        String contato = controller.pegaContato();
        List<Contatos> contatosEncontrados = controller.encontrarContato(contato) ;
        Contatos contatoSelecionado = controller.escolherContato(contatosEncontrados);
        controller.mostrarTelefonesParaContato(contatoSelecionado);
    }

    public void listarTodosEnderecosContato() {
        String contato = controller.pegaContato();
        List<Contatos> contatosEncontrados = controller.encontrarContato(contato) ;
        Contatos contatoSelecionado = controller.escolherContato(contatosEncontrados);
        controller.mostrarEnderecosParaContato(contatoSelecionado);

    }

}