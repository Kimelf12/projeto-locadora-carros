package modelo;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 * Formato do Endereço: Rua Antonio Vieira, nº 156 (Apartamento 2) - Bairro: Carijós - Lafaiete(MG) 
 */

public class Endereco {
    //Atributos
    private String rua, bairro, cidade, uf, complemento, referencia;
    private int numero, id;

    //Construtores    
    public Endereco () {
        this.rua = "";
        this.bairro = "";
        this.cidade = "";
        this.uf = "";
        this.complemento = "";
        this.referencia = "";
        this.numero = 0;
    }
    
    public Endereco(String rua, String bairro, String cidade, String uf, String complemento, String referencia, int numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.numero = numero;
        this.referencia = referencia;
    }
    
    public Endereco(int id, String rua, String bairro, String cidade, String uf, String complemento, String referencia, int numero) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.numero = numero;
        this.referencia = referencia;
    }

    //Métodos Getters e Setters
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //Métodos Sobrescritos
    @Override
    public String toString() {
        return rua + ", nº" + numero + "(" + complemento + ") - Bairro: " + bairro + " - " + cidade + "(" + uf.toUpperCase() + ")";
    }
    
    @Override
    public boolean equals (Object outro) {
        try {
            Endereco endereco = (Endereco) outro;
            return this.getCidade().equalsIgnoreCase(endereco.cidade) 
                   && this.getRua().equalsIgnoreCase(endereco.getRua())
                   && this.getNumero() == endereco.numero
                   && this.getComplemento().equalsIgnoreCase(endereco.getComplemento());
        } catch (Exception e) {
            return false;
        }
    }
    
}
