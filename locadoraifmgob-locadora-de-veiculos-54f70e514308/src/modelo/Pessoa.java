package modelo;

import java.time.LocalDate;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public abstract class Pessoa {
    //Atributos
    protected String nome, rg, cpf, telefoneMovel, telefoneFixo, email;
    protected LocalDate data_nascimento;
    protected Endereco endereco;
    
    //Construtores
    public Pessoa() {
        this.nome = "";
        this.rg = "";
        this.cpf = "";
        this.telefoneMovel = "";
        this.telefoneFixo = "";
        this.endereco = new Endereco();
    }
    
    public Pessoa(String nome, String rg, String cpf, String telefoneMovel, String telefoneFixo, String email, LocalDate data_nascimento, Endereco endereco) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.telefoneMovel = telefoneMovel;
        this.telefoneFixo = telefoneFixo;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.endereco = endereco;
    }
    
    //Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefoneMovel() {
        return telefoneMovel;
    }

    public void setTelefoneMovel(String telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }
    
    public Endereco getEndereco () {
        return endereco;
    }
    
    public void setEndereco (Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
    //Métodos Sobrescritos
    @Override
    public String toString () {
        return nome + " - CPF:" + cpf + " - RG:" + rg;
    }
    
    @Override
    public boolean equals (Object outro) {
        try {
            Pessoa pessoa = (Pessoa) outro;
            return pessoa.cpf.equals(this.cpf);
        } catch (Exception e) {
            return false;
        }
    }
}
