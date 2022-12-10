package agendaContatos.model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos = new ArrayList<>();

    public List<Contato> getContatos() {
        return contatos;
    }


    public void addContatos(Contato contato) {// FUNCAO PARA ADD CONTATO E NAO A LISTA INTEIRA
        contatos.add(contato);
    }
}
