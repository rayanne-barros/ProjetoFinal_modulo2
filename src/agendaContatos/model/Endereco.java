package agendaContatos.model;

import agendaContatos.enums.TipoEndereco;

import java.util.Objects;

public class Endereco {
    private TipoEndereco tipo;
    private String pais;
    private String cep;
    private String logradouro;

    private String numero;
    private String cidade;
    private String estado;




    public Endereco(String cidade, String cep, String logradouro,String numero, String estado, TipoEndereco tipo) {
        this.cidade = cidade;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.estado = estado;
        this.tipo = tipo;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = TipoEndereco.valueOf(tipo);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(logradouro, endereco.logradouro) && Objects.equals(numero, endereco.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, numero);
    }

    @Override
    public String toString() { return  logradouro + ", N: "  +  numero + ". " + cidade +  "-" + estado; }

}
