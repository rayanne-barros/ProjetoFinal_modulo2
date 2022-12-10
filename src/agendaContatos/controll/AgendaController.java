package agendaContatos.controll;

import agendaContatos.model.Agenda;
import agendaContatos.model.Contato;
import agendaContatos.ui.AgendaUI;

import java.util.ArrayList;
import java.util.List;

public class AgendaController {
    private Agenda agenda = new Agenda();

    public  void adicionarContato(Contato contato){
        agenda.addContatos(contato);

    }
    public  void listarContatos(AgendaUI view){
        agenda.getContatos().forEach(contato ->view.mostrarContato(contato));


    }

//    public void excluir(Contato contato) {
//        contatos.remove(contato);
//    }
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