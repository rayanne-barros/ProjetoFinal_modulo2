import agendaContatos.controll.Agenda;
import agendaContatos.enums.TipoContato;
import agendaContatos.enums.TipoEndereco;
import agendaContatos.enums.TipoTelefone;
import agendaContatos.model.Contato;
import agendaContatos.model.Endereco;
import agendaContatos.model.Telefone;
import agendaContatos.ui.AgendaUI;

import java.util.List;

public class App {
    public static void main(String[] args) {

        AgendaUI agendaui = new AgendaUI();

        agendaui.menuInicial();
        Agenda agenda = new Agenda();

        Contato maria = new Contato("Maria", "Silva ", "maria@email.com", TipoContato.Pessoal);

        agenda.adicionar(maria);
        List<Contato> lista = agenda.listar(0, 10);

        System.out.println(lista);
        System.out.println(lista.size());


       /* Endereco mariaEnde = new Endereco(TipoEndereco.Residencial, "Brasil", "55555000");
        mariaEnde.setLogradouro("Rua dos Jardins");
        mariaEnde.setNumero("224");
        mariaEnde.setCidade("João Pessoa");
        mariaEnde.setEstado("Paraíba");
        mariaEnde.setBairro("Centro");
        mariaEnde.setComplemento("Casa");

        Telefone mariaTel = new Telefone(TipoTelefone.Celular, "Maria");
        mariaTel.setDdi("+55");
        mariaTel.setDdd("83");
        mariaTel.setNumero("988888888");
*/
/*
        System.out.println("Contato Maria: " + maria);
        System.out.println("Contato Maria: " + mariaEnde);
        System.out.println("Contato Maria: " + mariaTel);

        System.out.println("|" + maria.getNomeCompleto() + "|");
        System.out.println("|" + mariaTel.getTelefoneCompleto() + "|");
        System.out.println("|" + mariaEnde.getEnderecoCompleto() + "|");
*/

    }

}