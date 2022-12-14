package agendaContatos.controll;

import agendaContatos.enums.TipoContato;
import agendaContatos.enums.TipoEndereco;
import agendaContatos.enums.TipoTelefone;
import agendaContatos.model.Agenda;
import agendaContatos.model.Contatos;
import agendaContatos.model.Endereco;
import agendaContatos.model.Telefone;
import agendaContatos.util.ConsoleUIHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AgendaController {
    int width = 85;
    Scanner sc = new Scanner(System.in);

    private Agenda agenda = new Agenda();

    public void adicionarContato() {
        ConsoleUIHelper.drawLine(width);

        Contatos contato = new Contatos("", "", TipoContato.PESSOAL);

        System.out.print("\nDIGITE O NOME DO CONTATO: ");
        contato.setNome(sc.nextLine().trim().toUpperCase());

        System.out.print("DIGITE O SOBRENOME DO CONTATO: ");
        contato.setSobrenome(sc.nextLine().trim().toUpperCase());

        System.out.println("DIGITE O TIPO DO CONTATO: " + "(PESSOAL, PROFISSIONAL)");
        contato.setTipo(sc.nextLine().toUpperCase().trim());

        contato.setTelefones(mostrarMenuCadastroTelefone());
        contato.setEnderecos(mostrarMenuCadastroEndereco());

        ConsoleUIHelper.drawLine(width);

        /* Implementando a Regra de negócio
         */
        Boolean contatoRepetido = false;

        for (int i = 0; i < agenda.getContatos().size(); i++) {
            if (agenda.getContatos().get(i).equals(contato)) {
                System.out.println("Esse contato já foi cadastrado!");
                contatoRepetido = true;
            }
        }
        if (!contatoRepetido) {
            agenda.addContatos(contato);
            System.out.println("Contato adicionado com sucesso!\n");
        }
    }

    public List<Telefone> mostrarMenuCadastroTelefone() {
        Boolean continuar = true;
        List<Telefone> telefones = new ArrayList<>();

        do {

            System.out.println("\nDESEJA ADICIONAR TELEFONE? ");

            System.out.println("1-  SIM");
            System.out.println("0 - NÃO");

            System.out.print("DIGITE SUA OPÇÃO: ");

            String opcao = sc.nextLine();

            if (opcao.equals("0")) {
                break;
            }

            Telefone telefone = new Telefone("", "", TipoTelefone.CELULAR);

            System.out.print("DIGITE O DDD: ");
            telefone.setDdd(sc.nextLine().trim());

            System.out.print("DIGITE O NUMERO: ");
            telefone.setNumero(sc.nextLine().trim());

            System.out.println("TIPO DE TELEFONE:  " + "(CELULAR, COMERCIAL, RESIDENCIAL)");
            telefone.setTipo(sc.nextLine().toUpperCase().trim());

            telefones.add(telefone);

        } while (continuar);

        return telefones;
    }

    public List<Endereco> mostrarMenuCadastroEndereco() {

        Boolean continuar = true;

        List<Endereco> enderecos = new ArrayList<>();

        do {
            System.out.println("\nDESEJA ADICIONAR ENDEREÇO?");

            System.out.println("1-  SIM");
            System.out.println("0 - NÃO");

            System.out.print("DIGITE SUA OPÇÃO: ");

            String opcao = sc.nextLine();

            if (opcao.equals("0")) {
                break;
            }

            Endereco endereco = new Endereco("", "", "", "", "", TipoEndereco.RESIDENCIAL);

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

        } while (continuar);
        return enderecos;
    }


    public Contatos listarContatos() {
        System.out.println("Contatos cadastrados: \n");

        for (int i = 0; i < agenda.getContatos().size(); i++) {
            System.out.println("Identificador: " + i + ". Nome: " + agenda.getContatos().get(i).getNome().toUpperCase() + " " + agenda.getContatos().get(i).getSobrenome().toUpperCase());
        }

        System.out.println("\nEscolha um contato pelo identificador.");
        String escolha = sc.nextLine();
        Contatos contato = agenda.getContatos().get(Integer.valueOf(escolha));

        System.out.println("\nO contato escolhido foi " + contato.getNome() + " " + contato.getSobrenome() + ".\n");

        return contato;
    }

    public Contatos pesquisarContatos() {
        System.out.println("Qual o nome do contato? ");
        System.out.print(">>> ");
        String nome = sc.nextLine();
        List<Contatos> cttEncontrados = encontrarContato(nome);
        System.out.println("Contato(s) localizado(s): \n");

        for (int i = 0; i < cttEncontrados.size(); i++) {
            System.out.println("IDENTIFICADOR: " + i + "Nome: " + cttEncontrados.get(i).getNome().toUpperCase() + " " + cttEncontrados.get(i).getSobrenome().toUpperCase());
        }

        System.out.println("\nEscolha um contato pelo identificador.");
        String escolha = sc.nextLine();
        Contatos contato = cttEncontrados.get(Integer.valueOf(escolha));

        System.out.println("\nO contato escolhido foi " + contato.getNome() + " " + contato.getSobrenome() + ".");

        return contato;
    }

    public List<Contatos> encontrarContato(String contatoProcurado) {

        List<Contatos> contatosEncontrados = agenda
                .getContatos()
                .stream()
                .filter(c -> c.getNome().equalsIgnoreCase(contatoProcurado) || c.getSobrenome().equalsIgnoreCase(contatoProcurado))
                .collect(Collectors.toList());

        if (contatosEncontrados.size() == 0) {
            System.err.println("\nContato não encontrado.\n");
        }
        return contatosEncontrados;
    }

    public Boolean excluirTodosContatos() {
        Boolean mostrarMenu = true;

      //  System.out.println("Você tem certeza que deseja excluir todos os contatos? (0 - Não / 1 - Sim)");
        String opcaoNaoSim = ConsoleUIHelper.askSimpleInput("Você tem certeza que deseja excluir todos os contatos? (0 - Não / 1 - Sim)");
        opcaoNaoSim = sc.nextLine();
        if (opcaoNaoSim.equals("0")) {
            ConsoleUIHelper.drawLine(120);
            return mostrarMenu;
        }
        else if (opcaoNaoSim.equals("1")) {
            agenda.removerTodosContatos();
            System.out.println("\nTodos os contatos foram excluídos!");
            ConsoleUIHelper.drawLine(120);
            return mostrarMenu;
        }
        else {
            return mostrarMenu;
        }
    }

    public void excluirContato(Contatos contato) {
        agenda.removerContato(contato);
        ConsoleUIHelper.askSimpleInput("\nO contato " + contato.getNome() + " " + contato.getSobrenome() + "foi excluído.\n");
        //System.out.println("\nO contato " + contato.getNome() + " " + contato.getSobrenome() + "foi excluído.\n");
        ConsoleUIHelper.drawLine(80);
    }

    public Telefone escolherTelefoneRemover(Contatos contato) {

        System.out.println("Qual telefone a remover? ");
        System.out.print(">>> ");
        for (int i = 0; i < contato.getTelefones().size(); i++) {
            System.out.println("ID: " + (i) + " Telefone: " + contato.getTelefones().get(i));

        }
        Integer opcao = sc.nextInt();
        sc.nextLine();
        return contato.getTelefones().get(opcao);
    }

    public void removerTelefoneContato(Contatos contato) {
        Telefone telefone = escolherTelefoneRemover(contato);
        long quantidadeApagados = agenda.getContatos().stream()
                .filter(cont -> cont.equals(contato))
                .map(cont -> cont.getTelefones().remove(telefone))
                .count();

        System.out.println("\nFoi/Foram apagado(s) " + quantidadeApagados + " telefone(s).\n");
    }

    public Endereco escolherEnderecoRemover(Contatos contato) {
        System.out.println("Qual endereco a remover? ");
        System.out.print(">>> ");
        for (int i = 0; i < contato.getEnderecos().size(); i++) {
            System.out.println("ID: " + (i) + " Telefone: " + contato.getEnderecos().get(i));
        }
        int opcao = sc.nextInt();
        sc.nextLine();
        return contato.getEnderecos().get(opcao);
    }

    public void removerEnderecoContato(Contatos contato) { // 9
        Endereco endereco = escolherEnderecoRemover(contato);
        long quantidadeApagados = agenda.getContatos().stream().filter(cont -> cont.equals(contato)).map(cont -> cont.getEnderecos().remove(endereco)).count();
        System.out.println("\nFoi/Foram apagado(s) " + quantidadeApagados + " endereço(s).\n");
    }

    // Exibir todas as informações de um contato da agenda

    public void exibirTodasInformacoesContato(Contatos contato) {

        System.out.println("\nNOME: " + contato.getNomeCompleto().toUpperCase());
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
    public void listarTodosTelefonesContato(Contatos contato) {
        contato.getTelefones().forEach(telefone -> {
            Integer id = contato.getTelefones().indexOf(telefone);
            System.out.println("\nIDENTIFICADOR: " + id);
            System.out.println("Telefone: " + telefone.getTelefoneCompleto());
        });
    }

    public void listarTodosEnderecosContato(Contatos contato) {
        contato.getEnderecos().forEach(endereco -> {
            Integer id = contato.getEnderecos().indexOf(endereco);
            System.out.println("\nIDENTIFICADOR: " + id);
            System.out.println("Endereço: " + endereco.getEnderecoCompleto());
        });
    }

    public void adicionarEnderecoContatoExistente(Contatos contato) {
        Endereco endereco = new Endereco("", "", "", "", "", TipoEndereco.RESIDENCIAL);

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



        agenda.getContatos().stream()
                .filter(cont -> cont.equals(contato))
                .map(cont -> cont.getEnderecos().add(endereco))
                .count();

        System.out.println("\nO endereço foi adicionado\n");

    }

    public void adicionarTelefoneEmContatoExistente(Contatos contato) {
        Telefone telefone = new Telefone("", "", TipoTelefone.CELULAR);

        System.out.print("DIGITE O DDD: ");
        telefone.setDdd(sc.nextLine().trim());

        System.out.print("DIGITE O NUMERO: ");
        telefone.setNumero(sc.nextLine().trim());

        System.out.println("TIPO DE TELEFONE:  " + "(CELULAR, COMERCIAL, RESIDENCIAL)");
        telefone.setTipo(sc.nextLine().toUpperCase().trim());


        long quantidadeApagados = agenda.getContatos().stream()
                .filter(cont -> cont.equals(contato))
                .map(cont -> cont.getTelefones().add(telefone))
                .count();

        System.out.println("\nFoi adicionado " + quantidadeApagados + " telefone\n");


    }

}
