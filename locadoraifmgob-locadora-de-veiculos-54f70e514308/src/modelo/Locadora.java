package modelo;

import java.time.LocalDate;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class Locadora {
    //Atributos
    private String nomeLocadora, cnpj, contaBancaria;
    private LocalDate dataFundacao;
    private Endereco endereco;

    //Construtores
    public Locadora() {
    }

    public Locadora(String nomeLocadora, String cnpj, String contaBancaria, Endereco endereco) {
        this.nomeLocadora = nomeLocadora;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.contaBancaria = contaBancaria;
    }

    //Métodos Getters e Setters
    public String getNomeLocadora() {
        return nomeLocadora;
    }

    public void setNomeLocadora(String nomeLocadora) {
        this.nomeLocadora = nomeLocadora;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    //Método ToString
    @Override
    public String toString() {
        return cnpj + " - " + nomeLocadora + " - Endereço: " + endereco.toString() + " - Desde:" + dataFundacao.toString() + ".";
    }

    @Override
    public boolean equals (Object outro) {
        try {
            Locadora locadora = (Locadora) outro;
            return locadora.cnpj.equals(this.cnpj);
        } catch (Exception e) {
            return false;
        }
    }
    
} 
