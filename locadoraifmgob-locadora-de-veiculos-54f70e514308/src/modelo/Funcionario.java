package modelo;

import java.time.LocalDate;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class Funcionario extends Pessoa {
    //Atributos
    private String ctps, usuario;
    private float salario, comissao;
    private boolean gerente;

    //Construtores
    public Funcionario () {
        
    }
    
    public Funcionario(Pessoa pessoa, String ctps, float salario, float comissao, boolean gerente, String usuario) {
        super(pessoa.getNome(), pessoa.getRg(), pessoa.getCpf(), pessoa.getTelefoneMovel(), pessoa.getTelefoneFixo(), pessoa.getEmail(), pessoa.getData_nascimento(), pessoa.getEndereco());
        this.ctps = ctps;
        this.salario = salario;
        this.comissao = comissao;
        this.gerente = gerente;
        this.usuario = usuario;
    }

    public Funcionario(String nome, String rg, String cpf, String telefoneMovel, String telefoneFixo, String email, LocalDate data_nascimento, Endereco endereco, String ctps, float salario, float comissao) {
        super(nome, rg, cpf, telefoneMovel, telefoneFixo, email, data_nascimento, endereco);
        this.ctps = ctps;
        this.salario = salario;
        this.comissao = comissao;
    }
    
    //Métodos Getters e Setters
    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }
    
    //Métodos Sobrescritos
    @Override
    public String toString () {
        return cpf + " - " + nome + " - CTPS: " + ctps + " - " + data_nascimento;
    }
    
    @Override
    public boolean equals (Object outro) {
        try {
            Funcionario funcionario = (Funcionario) outro;
            return this.cpf.equals(funcionario.cpf);
        } catch (Exception e) {
            return false;
        }
    }
    
}
