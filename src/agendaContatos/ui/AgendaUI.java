package agendaContatos.ui;

import agendaContatos.controll.AgendaController;
import agendaContatos.enums.TipoContato;
import agendaContatos.enums.TipoEndereco;
import agendaContatos.enums.TipoTelefone;
import agendaContatos.model.Contato;
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
            System.out.println("Digite uma das opções abaixo");
            System.out.println("1- Adicionar contato");
            System.out.println("2- Pesquisar contato");
            System.out.println("3- Excluir contato");
            System.out.println("4- Listar contato");
            System.out.println("0 - Sair\n");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1" -> {
                    adicionarContato();
                }
                case "2" -> {
                    System.out.println("Pesquisou");
                }
                case "3" -> {
                    System.out.println("Excluiu");
                }
                case "4" -> {
                    listarContatos();

                }
            }
        } while (continuar);
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

                System.out.print("DIGITE O NOME DO CONTATO: ");
                telefone.setContato(sc.nextLine().trim());

                System.out.println("TIPO DE TELEFONE:  " + "(CELULAR, COMERCIAL, RESIDENCIAL)");
                telefone.setTipo(sc.nextLine().toUpperCase().trim());

                telefones.add(telefone);

            }while (continuar);

            return telefones;
        }
        private void adicionarContato() {

            Contato contato = new Contato("","","", TipoContato.PESSOAL);

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
        }

        private void listarContatos() {
            controller.listarContatos(this);
        }
        public void mostrarContato(Contato contato){

            AgendaController controller = new AgendaController();

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

        private void excluircontato() {

        }
}
