package agendaContatos.model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contatos> contatos = new ArrayList<>();

    public List<Contatos> getContatos() {
        return contatos;
    }


    public void addContatos(Contatos contato) {// FUNCAO PARA ADD CONTATO E NAO A LISTA INTEIRA
        contatos.add(contato);
    }

    public void removerContato(Contatos contato) {
        this.contatos.remove(contato);
    }

    public void removerTodosContatos() {
        this.contatos.removeAll(contatos);
    }
}
