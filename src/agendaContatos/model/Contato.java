package agendaContatos.model;

import agendaContatos.enums.TipoContato;

import java.time.LocalDate;
import java.util.List;

public class Contato {
    private String nome;
    private String sobrenome;
    private String email;
    private TipoContato tipo;
    private LocalDate dataNascimento;

    private List<Telefone> telefones;
    private List<Endereco> enderecos;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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
}


