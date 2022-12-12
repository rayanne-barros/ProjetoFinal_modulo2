package agendaContatos.model;

import agendaContatos.enums.TipoTelefone;

public class Telefone {
   private TipoTelefone tipo;
   private String ddd;
   private String numero;
   private String contato;

    public Telefone( String ddd, String numero,String contato, TipoTelefone tipo) {
        this.ddd = ddd;
        this.numero = numero;
        this.contato = contato;
        this.tipo = tipo;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = TipoTelefone.valueOf(tipo);
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getTelefoneCompleto() {
        String valor = ddd;
        if (!ddd.isBlank() && !numero.isBlank()) {
            valor += numero;
        }
        return valor.trim();
    }

    @Override
    public String toString() { return "(" + ddd + ")" + numero; }

}
