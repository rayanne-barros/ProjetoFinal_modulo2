package agendaContatos.model;

import agendaContatos.enums.TipoEndereco;

public class Endereco {
    private TipoEndereco tipo;
    private String pais;
    private String cep;
    private String logradouro;

    private String numero;
    private String cidade;
    private String estado;
    private String bairro;
    private String complemento;



    public Endereco(String pais, String cep, String logradouro,String numero, String cidade, String estado, String bairro, String complemento, TipoEndereco tipo) {
        this.pais = pais;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.complemento = complemento;
        this.tipo = tipo;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = TipoEndereco.valueOf(tipo);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEnderecoCompleto() {
        String valor = logradouro;
        if (!numero.isBlank() && !cidade.isBlank()) {
            valor += "," + numero + " - " + tipo;
        }
        return valor.trim();

    }

//    @Override
//    public String toString() {
//        return "Endereco{" +
//                "tipo=" + tipo +
//                ", pais='" + pais + '\'' +
//                ", cep='" + cep + '\'' +
//                ", logradouro='" + logradouro + '\'' +
//                ", cidade='" + cidade + '\'' +
//                ", estado='" + estado + '\'' +
//                ", bairro='" + bairro + '\'' +
//                ", complemento='" + complemento + '\'' +
//                '}';
//    }
}
