package agendaContatos.controll;

import agendaContatos.model.Agenda;
import agendaContatos.model.Contatos;
import agendaContatos.model.Endereco;
import agendaContatos.model.Telefone;
import agendaContatos.ui.AgendaUI;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AgendaController {

    Scanner sc = new Scanner(System.in);

    private Agenda agenda = new Agenda();

    public  void adicionarContato(Contatos contato){
        agenda.addContatos(contato);

    }
    public List<Contatos> listarContatos(){
        return agenda.getContatos();
    }
    public  void listarContatos(AgendaUI view){
        agenda.getContatos().forEach(contato ->view.mostrarContato(contato));


    }

    public void removerContato(Contatos contato) {
        agenda.removerContato(contato);
    }

    public void removerTodosContatos() {
        agenda.removerTodosContatos();
    }

    public String pegaContato(){
        System.out.println("Qual o nome do contato? ");
        System.out.print(">>> ");
        String nome = sc.nextLine();
        return nome;
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

    public Contatos escolherContato(List<Contatos> contatos) {

        if(!(contatos.size() == 1)){
            System.out.println("Qual o nome do contato? ");
            System.out.print(">>> ");
            Integer opcao = sc.nextInt();
            sc.nextLine();
            return contatos.get(opcao);
        }
        return contatos.get(0);
    }

    public Telefone escolherTelefoneRemover(Contatos contato) {

        System.out.println("Qual telefone a remover? ");
        System.out.print(">>> ");
        for (int i = 0; i < contato.getTelefones().size(); i++) {
            System.out.println("ID: "+(i)+" Telefone: "+contato.getTelefones().get(i));

        }
        Integer opcao = sc.nextInt();
        sc.nextLine();
        return contato.getTelefones().get(opcao);


    }
    public Endereco escolherEnderecoRemover(Contatos contato) {

        System.out.println("Qual endereco a remover? ");
        System.out.print(">>> ");
        for (int i = 0; i < contato.getEnderecos().size(); i++) {
            System.out.println("ID: "+(i)+" Telefone: "+contato.getEnderecos().get(i));

        }
        int opcao = sc.nextInt();
        sc.nextLine();
        return contato.getEnderecos().get(opcao);

    }

    public void pegaID() {
        System.out.println("Digite o identificador do contato.");
        String opcaoEscolhida = sc.nextLine();
        Contatos contatoListar = agenda.getContatos().get(Integer.valueOf(opcaoEscolhida));

//        List<Contatos> cttEncontrados = encontrarContato(nome);
//        System.out.println("Contato(s) localizado(s): \n");
//        for (int i = 0; i < cttEncontrados.size(); i++) {
//            System.out.println("IDENTIFICADOR: " + i + "Nome: " + cttEncontrados.get(i).getNome() + " " + cttEncontrados.get(i).getSobrenome());
//        }
//
//        System.out.println("Digite o identificador do contato a ser excluído.");
//        String opcaoEscolhida = sc.nextLine();

    }

    public void apagaTelefoneContato() {
//        String contato = pegaContato();
//        List<Contatos> contatosEncontrados = encontrarContato(contato);
//        Contatos contatoSelecionado = escolherContato(contatosEncontrados);
//        Telefone telefone = escolherTelefoneRemover(contatoSelecionado);

        System.out.println("Digite o nome do contato a ser excluído.");
        String nome = sc.nextLine().toUpperCase();

        List<Contatos> cttEncontrados = encontrarContato(nome);

        System.out.println("Contato(s) localizado(s): \n");
        for (int i = 0; i < cttEncontrados.size(); i++) {
            System.out.println("IDENTIFICADOR: " + i + "Nome: " + cttEncontrados.get(i).getNome() + " " + cttEncontrados.get(i).getSobrenome());
        }

        //Contatos contatoSelecionado = escolherContato(cttEncontrados);

        System.out.println("Digite o identificador do contato a ser excluído.");
        String opcaoEscolhida = sc.nextLine();

        Telefone telefone = escolherTelefoneRemover(cttEncontrados.get(Integer.valueOf(opcaoEscolhida)));
        long quantidadeApagados = agenda.getContatos().stream()
                .filter(cont -> cont.equals(cttEncontrados.get(Integer.valueOf(opcaoEscolhida))))
                .map(cont -> cont.getTelefones().remove(telefone))
                .count();

        System.out.println("Foi/Foram apagado(s) " + quantidadeApagados + " telefone(s).");
    }



    public void apagaEnderecoContato() { // 9
        String contato = pegaContato();
        List<Contatos> contatosEncontrados = encontrarContato(contato);
        Contatos contatoSelecionado = escolherContato(contatosEncontrados);
        Endereco endereco = escolherEnderecoRemover(contatoSelecionado);
        long quantidadeApagados = agenda.getContatos().stream().filter(cont -> cont.equals(contatoSelecionado)).map(cont -> cont.getEnderecos().remove(endereco)).count();
        System.out.println("Foi/Foram apagado(s) " + quantidadeApagados + " endereço(s).");
    }
    public void mostrarTelefonesParaContato(Contatos contato){
        contato.getTelefones().forEach(telefone -> {
            System.out.println("Telefone: " + telefone.getTelefoneCompleto());
        });
    }

    public void mostrarEnderecosParaContato(Contatos contato){
        contato.getEnderecos().forEach(endereco -> {
            System.out.println("Endereço: " + endereco.getEnderecoCompleto());
        });
    }





//
//    public List<Contato> pesquisarNome(String nome) {
//        List<Contato> contatosEncontrados = new ArrayList<>();
//        for (int i = 0; i < contatos.size(); i++) {
//            if(contatos.get(i).getNome().contains(nome)) {
//                contatosEncontrados.add(contatos.get(i));
//            }
//        }
//        return contatos;
//    }
//
//    public List<Contato> pesquisarEmail(String email) {
//        List<Contato> contatosEncontrados = new ArrayList<>();
//        for (int i = 0; i < contatos.size(); i++) {
//            if(contatos.get(i).getNome().contains(email)) {
//                contatosEncontrados.add(contatos.get(i));
//            }
//        }
//        return contatosEncontrados;
//    }
//
//    public List<Contato> listar(int start, int quantidade) {
//        if(start < 0 || start >= contatos.size()) {
//            start = 0;
//        }
//
//        if(quantidade < 0) {
//            quantidade = 0;
//        }
//
//        if(quantidade > contatos.size()) {
//            quantidade = contatos.size();
//        }
//
//        if((start+quantidade) >= contatos.size()) {
//            quantidade = (contatos.size() - start);
//        }
//        List<Contato> listarContatosEncontrados = new ArrayList<>();
//        for (int i = start; i < (start + quantidade); i++) {
//            listarContatosEncontrados.add(contatos.get(i));
//
//        }
//        return listarContatosEncontrados;
//
//    }

}
