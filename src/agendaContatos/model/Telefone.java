package agendaContatos.model;

import agendaContatos.enums.TipoTelefone;

import java.util.Objects;

public class Telefone {
   private TipoTelefone tipo;
   private String ddd;
   private String numero;

    public Telefone( String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public Telefone( String ddd, String numero, TipoTelefone tipo) {
        this.ddd = ddd;
        this.numero = numero;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(ddd, telefone.ddd) && Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, numero);
    }

//    @Override
//    public String toString() { return "(" + ddd + ")" + numero; }

}
