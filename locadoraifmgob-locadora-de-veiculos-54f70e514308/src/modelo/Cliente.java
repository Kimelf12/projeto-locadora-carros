package modelo;

import java.time.LocalDate;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class Cliente extends Pessoa {
    //Atributos
    private String cnh;
    private boolean autorizado;
    
    //Construtores
    public Cliente () {
        
    }
    
    public Cliente(Pessoa pessoa, String cnh, boolean autorizado) {
        super(pessoa.getNome(), pessoa.getRg(), pessoa.getCpf(), pessoa.getTelefoneMovel(), pessoa.getTelefoneFixo(), pessoa.getEmail(), pessoa.getData_nascimento(), pessoa.getEndereco());
        this.cnh = cnh;
        this.autorizado = autorizado;
    }

    public Cliente(String nome, String rg, String cpf, String telefoneMovel, String telefoneFixo, String email, LocalDate data_nascimento, Endereco endereco, String cnh, boolean autorizado) {
        super(nome, rg, cpf, telefoneMovel, telefoneFixo, email, data_nascimento, endereco);
        this.cnh = cnh;
        this.autorizado = autorizado;
    }
    
    //Métodos Getters e Setters
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    //Métodos Sobrescritos
    @Override
    public String toString () {
        return cpf + " - " + nome + " - CNH: " + cnh + " - " + data_nascimento;
    }
    
    @Override
    public boolean equals (Object outro) {
        try {
            Cliente cliente = (Cliente) outro;
            return cliente.cpf.equals(cliente.cpf);
        } catch (Exception e) {
            return false;
        }
    }
}
