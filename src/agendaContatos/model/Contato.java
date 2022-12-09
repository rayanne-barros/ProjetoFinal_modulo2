package agendaContatos.model;

import agendaContatos.controll.Agenda;
import agendaContatos.enums.TipoContato;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Contato {
    private String nome;
    private String sobrenome;
    private String email;
    private TipoContato tipo;

    private List<Telefone> telefones = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();


//Módulo de contrutores
    public Contato(String nome, String sobrenome) {
        this(nome, sobrenome, "", TipoContato.Pessoal);

    }

    public Contato(String nome, String sobrenome, String email, TipoContato tipo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.tipo = tipo;
    }

    public Contato(String nome, String sobrenome, Telefone telefone) {
        this(nome, sobrenome);
        this.telefones.add(telefone);
    }
    public static final Scanner scan = new Scanner(System.in);
    //Módulo getters e setters;
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

    public void setTipo(TipoContato tipo) {
        this.tipo = tipo;
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

  /* public void armazenaContato (String nome, String sobrenome, String email, TipoContato tipo){

       System.out.println("Digite o nome do cantato: ");
       setNome(nome = scan.nextLine());
       System.out.println("Digite o sobrenome do cantato: ");
       setNome(sobrenome = scan.nextLine());
       System.out.println("Digite o email do cantato: ");
       setNome(email = scan.nextLine());
       System.out.println("Digite o tipo de cantato: ");
       setNome(String.valueOf(tipo = TipoContato.valueOf(scan.nextLine())));

       Contato contato = new Contato(getNome(), getSobrenome(), getEmail(), getTipo());

       System.out.println(contato.nome + " | " + contato.sobrenome + " | " +
                          contato.email + " | " + contato.tipo);
       if (te)
   }*/

    public String getNomeCompleto() {
        String valor = nome;
        if (!sobrenome.isBlank()) {
            valor += " " + sobrenome;
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + getNome() + '\'' +
                ", sobrenome='" + getSobrenome() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) && Objects.equals(sobrenome, contato.sobrenome) && tipo == contato.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, tipo);
    }
}




