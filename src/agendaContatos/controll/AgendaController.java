package agendaContatos.controll;


import agendaContatos.model.Agenda;
import agendaContatos.model.Contato;
import agendaContatos.ui.AgendaView;

public class AgendaController {
    private Agenda agenda = new Agenda();

    public  void adicionarContato(Contato contato){
        agenda.addContatos(contato);

    }
    public  void listarContatos(AgendaView view){
        agenda.getContatos().forEach(contato ->view.mostrarContato(contato));


    }

}