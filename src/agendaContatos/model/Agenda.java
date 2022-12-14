package agendaContatos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


/*o start pode ser maior ou igual ao contato.size(), pq o size é 'um a mais' do que
 *o indixe, como eu começo no '0', se eu tiver '10' o meu último vai ser o '9',
 * DICA BÀSICA -> sempre o final acaba IGUAL ao tamanho. */
    /*public List<Contatos> listar (int start, int quantidade){
*//*Para o 'LISTAR' precisamos de 2 parâmetros, iremos usar o 'START'(início que é de
 onde eu começo0 e a 'QUANTIDADE' (que é quantos eu quero trazer)*//*
        if (start <= 0 || start > contatos.size()){
            start = 0;
        }
        if (quantidade >  contatos.size()){
            quantidade = contatos.size() -1;
        }


        List<Contatos> contatosEncontrados = new ArrayList<>();
        //O 'i' tem que ser menor ou igual ao 'start' + quantidade;
        for (int i = start; i < start + quantidade; i ++) {
            contatosEncontrados.add(contatos.get(i));
        }
        return contatosEncontrados;
    }
*/

    @Override
    public int hashCode() {
        return Objects.hash(contatos);
    }
}
