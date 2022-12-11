package agendaContatos.model;

import agendaContatos.enums.TipoContato;

import java.util.List;

public class Contatos {
    private String nome;
    private String sobrenome;
    private String email;
    private TipoContato tipo;

    private List<Telefone> telefones;
    private List<Endereco> enderecos;

    public Contatos(String nome, String sobrenome, String email, TipoContato tipo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoContato getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = TipoContato.valueOf(tipo);
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getNomeCompleto() {
        String valor = nome;
        if (!sobrenome.isBlank()) {
            valor += " " + sobrenome;
        }
        return valor.trim();
    }

//    @Override
//    public String toString() {
//        return "Contato{" +
//                "nome='" + getNome() + '\'' +
//                ", sobrenome='" + getSobrenome() + '\'' +
//                ", email='" + getEmail() + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Contato contato = (Contato) o;
//        return Objects.equals(nome, contato.nome) && Objects.equals(sobrenome, contato.sobrenome) && tipo == contato.tipo;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nome, sobrenome, tipo);
//    }
}




