package agendaContatos.controll;

import agendaContatos.enums.TipoContato;
import agendaContatos.enums.TipoEndereco;
import agendaContatos.enums.TipoTelefone;
import agendaContatos.model.Agenda;
import agendaContatos.model.Contatos;
import agendaContatos.model.Endereco;
import agendaContatos.model.Telefone;
import agendaContatos.ui.AgendaUI;
import agendaContatos.util.ConsoleUIHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AgendaController {

    Scanner sc = new Scanner(System.in);

    private Agenda agenda = new Agenda();


    public void adicionarContato() {  // letra a
        Contatos contato = new Contatos("", "", TipoContato.PESSOAL);

        System.out.print("\nDIGITE O NOME DO CONTATO: ");
        contato.setNome(sc.nextLine().trim().toUpperCase());

        System.out.print("DIGITE O SOBRENOME DO CONTATO: ");
        contato.setSobrenome(sc.nextLine().trim().toUpperCase());

        System.out.println("DIGITE O TIPO DO CONTATO: " + "(PESSOAL, PROFISSIONAL)");
        contato.setTipo(sc.nextLine().toUpperCase().trim());

        // Implementando a Regra de negócio

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

        contato.setTelefones(mostrarMenuCadastroTelefone(contato));
        contato.setEnderecos(mostrarMenuCadastroEndereco(contato));
    }

    public List<Telefone> mostrarMenuCadastroTelefone(Contatos contato) {

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

            //Criar uma regra pra ver se o numero já está inserido nos numeros do contato, caso contrario, permite salvar

            //cria uma validação pra ver se na lista de telefones - telefones - existe o numero que voce está tentando salvar agora - telefone -
            //se existe -> printa "esse telefone já foi adicionado.
            // se não existe -> printa telefone adicionado com sucesso e coloca o - telefone- tanto na agenda dentro do contato, quanto no array - telefones -

            Boolean telefoneRepetido = false;


            if (telefones.contains(telefone))
            {
                telefoneRepetido = true;
                System.out.println("Este telefone já foi salvo a este contato");
            }

            if (!telefoneRepetido) {
                telefones.add(telefone);
                contato.setTelefones(telefones);
                System.out.println("O telefone foi adicionado");
            }


        } while (continuar);
//
     return telefones;
  }

    public List<Endereco> mostrarMenuCadastroEndereco(Contatos contato) {

        Boolean continuar = true;

        List<Endereco> enderecos = new ArrayList<>();

        do {
            System.out.println("\nDESEJA ADICIONAR ENDEREÇO? \n");

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
            contato.setEnderecos(enderecos);
            System.out.println("O endereço foi adicionado");



        } while (continuar);
        return enderecos;
    }


    public Contatos listarContatos() { // letra b
        System.out.println("Contatos cadastrados: ");

        for (int i = 0; i < agenda.getContatos().size(); i++) {
            System.out.println("Identificador: " + i + ". Nome: " + agenda.getContatos().get(i).getNome().toUpperCase() + " " + agenda.getContatos().get(i).getSobrenome().toUpperCase());
        }

        System.out.println("\nEscolha um contato pelo identificador.");
        String escolha = sc.nextLine();
        Contatos contato = agenda.getContatos().get(Integer.valueOf(escolha));

        System.out.println("O contato escolhido foi " + contato.getNome() + " " + contato.getSobrenome() + ".");

        return contato;
    }

    public Contatos pesquisarContatos() { // letra c
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

        System.out.println("O contato escolhido foi " + contato.getNome() + " " + contato.getSobrenome() + ".");

        return contato;
    }

    public List<Contatos> encontrarContato(String contatoProcurado) {

        List<Contatos> contatosEncontrados = agenda
                .getContatos()
                .stream()
                .filter(c -> c.getNome().equalsIgnoreCase(contatoProcurado) || c.getSobrenome().equalsIgnoreCase(contatoProcurado))
                .collect(Collectors.toList());

        if (contatosEncontrados.size() == 0) {
            System.err.println("Contato não encontrado. ");
        }
        return contatosEncontrados;
    }

    public Boolean excluirTodosContatos() { // letra e
        Boolean mostrarMenu = true;

        System.out.println("Você tem certeza que deseja excluir todos os contatos? (0 - Não / 1 - Sim)");
        String opcaoNaoSim = sc.nextLine();
        if (opcaoNaoSim.equals("0")) {
            return mostrarMenu;
        } else if (opcaoNaoSim.equals("1")) {
            agenda.removerTodosContatos();
            System.out.println("Todos os contatos foram excluídos!");
            return mostrarMenu;
        } else {
            return mostrarMenu;
        }
    }

    public void excluirContato(Contatos contato) { // letra d
        agenda.removerContato(contato);
        System.out.println("O contato " + contato.getNome() + " " + contato.getSobrenome() + "foi excluído.");
    }


    public void adicionarTelefoneEmContatoExistente(Contatos contato) { // letra f

        Telefone telefone = new Telefone("", "", TipoTelefone.CELULAR);

        System.out.print("DIGITE O DDD: ");
        telefone.setDdd(sc.nextLine().trim());

        System.out.print("DIGITE O NUMERO: ");
        telefone.setNumero(sc.nextLine().trim());

        System.out.println("TIPO DE TELEFONE:  " + "(CELULAR, COMERCIAL, RESIDENCIAL)");
        telefone.setTipo(sc.nextLine().toUpperCase().trim());
        Boolean telefoneRepetido = false;

        if (contato.getTelefones().contains(telefone))
        {
            telefoneRepetido = true;
            System.out.println("este telefone já foi cadastrado a este contato");
        }

        if (!telefoneRepetido) {
            contato.getTelefones().add(telefone);
            System.out.println("O telefone foi adicionado");
        }
    }

    public void adicionarEnderecoContatoExistente(Contatos contato) { // letra g
        List<Endereco> enderecos = new ArrayList<>();
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
        contato.setEnderecos(enderecos);
        System.out.println("O endereço foi adicionado");

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

    public void removerTelefoneContato(Contatos contato) { // letra h
        Telefone telefone = escolherTelefoneRemover(contato);
        long quantidadeApagados = agenda.getContatos().stream()
                .filter(cont -> cont.equals(contato))
                .map(cont -> cont.getTelefones().remove(telefone))
                .count();

        System.out.println("Foi/Foram apagado(s) " + quantidadeApagados + " telefone(s).");
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

    public void removerEnderecoContato(Contatos contato) { // letra h
        Endereco endereco = escolherEnderecoRemover(contato);
        long quantidadeApagados = agenda.getContatos().stream().filter(cont -> cont.equals(contato)).map(cont -> cont.getEnderecos().remove(endereco)).count();
        System.out.println("Foi/Foram apagado(s) " + quantidadeApagados + " endereço(s).");
    }

    // Exibir todas as informações de um contato da agenda

    public void exibirTodasInformacoesContato(Contatos contato) { // letra j

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
    public void listarTodosTelefonesContato(Contatos contato) { //letra k
        AgendaUI view = new AgendaUI();

        contato.getTelefones().forEach(telefone -> {
            Integer id = contato.getTelefones().indexOf(telefone);
            System.out.println("\nIDENTIFICADOR: " + id);
            System.out.println("Telefone: " + telefone.getTelefoneCompleto());
        });
        /*System.out.println("Escolha um Telefone pelo identificador para exibir todas informações? ");
        System.out.print(">>> ");
        int opcao = sc.nextInt();
        sc.nextLine();

        exibirTodasInformacoesTelefone(contato);*/
    }

    public void listarTodosEnderecosContato(Contatos contato) { // letra l
        contato.getEnderecos().forEach(endereco -> {
            Integer id = contato.getEnderecos().indexOf(endereco);
            System.out.println("\nIDENTIFICADOR: " + id);
            System.out.println("Logradouro: " + endereco.getLogradouro());
            System.out.println("Número: " + endereco.getNumero());
        });
    }



    public void exibirTodasInformacoesTelefone(Contatos contatos){ //letra m
        System.out.println("\nTodas informações do telefones: ");
        contatos.getTelefones().stream().forEach(telefone -> {
            Integer id = contatos.getTelefones().indexOf(telefone);
            System.out.println("\nIDENTIFICADOR: " + id);
            System.out.println("TELEFONE: " + telefone.getDdd() + " " + telefone.getNumero() );
            System.out.println("TIPO DE TELEFONE: " + telefone.getTipo());
        });

    }
    public void exibirTodasInformacoesEndereco(Contatos contatos){ //letra n
        System.out.println("\nEndereços: \n");
        contatos.getEnderecos().stream().forEach(endereco -> {
            Integer id = contatos.getEnderecos().indexOf(endereco);
            System.out.println("\nIDENTIFICADOR: " + id);
            System.out.println("RUA: " + endereco.getLogradouro());
            System.out.println("NÚMERO: " + endereco.getNumero());
            System.out.println("CEP: " + endereco.getCep());
            System.out.println("MUNICIPIO: " + endereco.getCidade() + " - " + endereco.getEstado());
            System.out.println("TIPO DE ENDEREÇO: " + endereco.getTipo());
            System.out.println();
        });
    }


}
