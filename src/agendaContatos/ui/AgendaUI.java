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
            System.out.println("4 - Remover contato");
            System.out.println("5 - Remover todos os contato");
            System.out.println("6 - Adicionar um endereço a um contato");
       System.out.println("7 - Remover um telefone de um contato da agenda");
       System.out.println("8 - Remover um endereço de um contato da agenda");
            /*System.out.println("9 - Exibir todas as informações de um contato da agenda");*/
            System.out.println("10 - Listar todos os telefones de um contato da agenda");
            System.out.println("11 - Listar todos os endereços de um contato da agenda");
      /* System.out.println("12 - Exibir todas as informações de um telefone de um contato da agenda");
       System.out.println("13 - Exibir todas as informações de um endereço de um contato da agenda");*/
            System.out.println("0 - Sair do Programa ");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1" : adicionarContato(); break;
                case "2" : listarContatos(); break;
                case "3" : pesquisarContatos(); break;
                case "4" : excluirContato(); break;
                case "5" : excluirTodosContatos(); break;
                case "7" : controller.apagaTelefoneContato(); break;
                case "8" : controller.apagaEnderecoContato(); break;
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

                System.out.println("1-  SIM");
                System.out.println("0 - NÃO");

                System.out.print("DIGITE SUA OPÇÃO: ");

                String opcao = sc.nextLine();

                if (opcao.equals("0")){
                    break;
                }

                Endereco endereco = new Endereco("","","","","",TipoEndereco.RESIDENCIAL);

                System.out.print("DIGITE A CIDADE: ");
                endereco.setCidade(sc.nextLine().trim());

                System.out.print("DIGITE O CEP: ");
                endereco.setCep(sc.nextLine().trim());

                System.out.print("DIGITE O LOGRADOURO: ");
                endereco.setLogradouro(sc.nextLine().trim());

                System.out.print("DIGITE O NUMERO DA CASA: ");
                endereco.setNumero(sc.nextLine().trim());

                System.out.print("DIGITE O ESTADO: ");
                endereco.setEstado(sc.nextLine().trim());

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

                System.out.println("1-  SIM");
                System.out.println("0 - NÃO");

                System.out.print("DIGITE SUA OPÇÃO: ");

                String opcao = sc.nextLine();

                if (opcao.equals("0")){ break;}

                Telefone telefone = new Telefone("","",TipoTelefone.CELULAR);

                System.out.print("DIGITE O DDD: ");
                telefone.setDdd(sc.nextLine().trim());

                System.out.print("DIGITE O NUMERO: ");
                telefone.setNumero(sc.nextLine().trim());

                System.out.println("TIPO DE TELEFONE:  " + "(CELULAR, COMERCIAL, RESIDENCIAL)");
                telefone.setTipo(sc.nextLine().toUpperCase().trim());

                telefones.add(telefone);

            }while (continuar);

            return telefones;
        }
        private void adicionarContato() {

            Contatos contato = new Contatos("","", TipoContato.PESSOAL);

            System.out.print("\nDIGITE O NOME DO CONTATO: ");
            contato.setNome(sc.nextLine().trim().toUpperCase());

            System.out.print("DIGITE O SOBRENOME DO CONTATO: ");
            contato.setSobrenome(sc.nextLine().trim().toUpperCase());

            System.out.println("DIGITE O TIPO DO CONTATO: " + "(PESSOAL, PROFISSIONAL)");
            contato.setTipo(sc.nextLine().toUpperCase().trim());

            /* System.out.println("DIGITE O DATA DE NASCIMENTO DO CANTATO");
            LocalDate dataDeNasciment = LocalDate.parse(sc.nextLine());*/

            contato.setEnderecos(mostrarMenuCadastroEndereco());
            contato.setTelefones(mostrarMenuCadastroTelefone());

            controller.adicionarContato(contato);
            System.out.println("Contato adicionado com sucesso!\n");
            mostrarMenu();

           // mostrarContato(contato);
        }

        public void listarContatos() {
            System.out.println("Contatos cadastrados: ");
            List<Contatos> lstContatosCadastrados = controller.listarContatos();

            for (int i = 0; i < lstContatosCadastrados.size(); i++) {
                System.out.println("IDENTIFICADOR: " + i + "Nome: " + lstContatosCadastrados.get(i).getNome().toUpperCase() + " " + lstContatosCadastrados.get(i).getSobrenome().toUpperCase());
            }

//            for (Contatos contato : lstContatosCadastrados) {
//                System.out.println("\nNOME Completo: " + contato.getNome().toUpperCase() + " " + contato.getSobrenome().toUpperCase());
//               // System.out.println("TIPO DE CONTATO: " + contato.getTipo());
//
//            }
        }

         public void mostrarContato(Contatos contato){


            System.out.println("\nNOME: " + contato.getNome().toUpperCase() + " " + contato.getSobrenome().toUpperCase());
            System.out.println("TIPO DE CONTATO: " + contato.getTipo());

            System.out.println("\nTelefones: \n");

            contato.getTelefones().stream().forEach(telefone -> {
                Integer id = contato.getTelefones().indexOf(telefone);
                System.out.println("\nIDENTIFICADOR: " + id);
                System.out.println("TELEFONE: " + telefone.getDdd() + " " + telefone.getNumero() );
                System.out.println("TIPO DE TELEFONE: " + telefone.getTipo());


            });

            System.out.println("\nEndereços: \n");
            contato.getEnderecos().stream().forEach(endereco -> {
                Integer id = contato.getEnderecos().indexOf(endereco);
                System.out.println("\nIDENTIFICADOR: " + id);
                System.out.println("RUA: " + endereco.getLogradouro());
                System.out.println("NÚMERO: " + endereco.getNumero());
                System.out.println("CEP: " + endereco.getCep());
                System.out.println("MUNICIPIO: " + endereco.getCidade() + " - " + endereco.getEstado());
                System.out.println("TIPO DE ENDEREÇO: " + endereco.getTipo());
                System.out.println();

            });

        }
        private void pesquisarContatos() {
            String nome = controller.pegaContato();
            List<Contatos> cttEncontrados = controller.encontrarContato(nome);
            System.out.println("Contato(s) localizado(s): \n");
//            for (Contatos contato: cttEncontrados
//                 ) {
//                System.out.println("Nome: "+contato.getNomeCompleto());
//            }
            for (int i = 0; i < cttEncontrados.size(); i++) {
                System.out.println("IDENTIFICADOR: " + i + "Nome: " + cttEncontrados.get(i).getNome().toUpperCase() + " " + cttEncontrados.get(i).getSobrenome().toUpperCase());
            }
       }

    private void excluirContato() {
        Scanner sc = new Scanner(System.in);

        listarContatos();

        System.out.println("Digite o nome do contato a ser excluído.");
        String nome = sc.nextLine().toUpperCase();

        List<Contatos> cttEncontrados = controller.encontrarContato(nome);
        System.out.println("Contato(s) localizado(s): \n");
        for (int i = 0; i < cttEncontrados.size(); i++) {
            System.out.println("IDENTIFICADOR: " + i + "Nome: " + cttEncontrados.get(i).getNome() + " " + cttEncontrados.get(i).getSobrenome());
        }

        System.out.println("Digite o identificador do contato a ser excluído.");
        String opcaoEscolhida = sc.nextLine();

        controller.removerContato(cttEncontrados.get(Integer.valueOf(opcaoEscolhida)));
        System.out.println("O contato foi excluído.");

    }


    private void excluirTodosContatos() {
        Scanner sc = new Scanner (System.in);

        System.out.println("Você tem certeza que deseja excluir todos os contatos? (0 - Não / 1 - Sim)");
        String opcaoNaoSim = sc.nextLine();

        if (opcaoNaoSim.equals("0")) {
            mostrarMenu();
        } else if (opcaoNaoSim.equals("1")) {
            controller.removerTodosContatos();
            System.out.println("Todos os contatos foram excluídos!");
        }
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