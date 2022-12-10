package agendaContatos.model;

import agendaContatos.enums.TipoTelefone;

public class Telefone {
    private TipoTelefone tipo;
    private String ddi;
    private String ddd;
    private String numero;
    private String ramal;
    private String contato;

    public Telefone( String ddi, String ddd, String numero, String ramal, String contato, TipoTelefone tipo) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
        this.ramal = ramal;
        this.contato = contato;
        this.tipo = tipo;
    }


    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = TipoTelefone.valueOf(tipo);
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
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

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefoneCompleto() {
        String valor = ddi;
        if (!ddd.isBlank() && !numero.isBlank()) {
            valor += " " + ddd + "" + numero + " " + tipo;
        }
        return valor.trim();
    }
    @Override
    public String toString() {
        return "Telefone{" +
                "tipo=" + tipo +
                ", ddi='" + ddi + '\'' +
                ", ddd='" + ddd + '\'' +
                ", numero='" + numero + '\'' +
                ", ramal='" + ramal + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}
