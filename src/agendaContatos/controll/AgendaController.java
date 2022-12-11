package agendaContatos.controll;

import agendaContatos.model.Agenda;
import agendaContatos.model.Contatos;
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
        System.out.println("Qual o contato? ");
        System.out.print("> ");
        String nome = sc.nextLine();
        return nome;
    }

    public List<Contatos> encontrarContato(String contatoProcurado) {

        List<Contatos> contatosEncontrados = agenda
                .getContatos()
                .stream()
                .filter(c -> c.getNome().equalsIgnoreCase(contatoProcurado))
                .collect(Collectors.toList());

        if (contatosEncontrados.size() == 0) {
            System.err.println("Contato não encontrado. ");
        }

        return contatosEncontrados;
    }

    public Contatos escolherContato(List<Contatos> contatos) { //Para buscar um contato para editar

        if(!(contatos.size() == 1)){
            System.out.println("Qual o nome do contato? ");
            System.out.print("> ");
            Integer opcao = sc.nextInt();
            sc.nextLine();
            return contatos.get(opcao);
        }
        return contatos.get(0);
    }

    public void mostrarTodasTelefonesParaContato(Contatos contato){
        contato.getTelefones().forEach(telefone -> {
            System.out.println("(" + telefone.getDdd() + ") " + telefone.getNumero());
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
