import agendaContatos.ui.AgendaUI;

public class App {
    public static void main(String[] args) {

        System.out.println("Olá! Bem vindo(a) a sua agenda!");
        AgendaUI view = new AgendaUI();
        view.mostrarMenu();

    }
}