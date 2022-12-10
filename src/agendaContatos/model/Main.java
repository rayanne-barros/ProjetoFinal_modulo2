package agendaContatos.model;

import agendaContatos.ui.AgendaUi;


public class Main {
    Agenda agenda = new Agenda();

    public static void main(String[] args) {
        AgendaUi view = new AgendaUi();
        view.mostrarMenu();

    }
}
