package modelo;

import java.time.LocalDate;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class Despesa {
    //Atributos
    private int id;
    private String descricao;
    private float valor;
    private boolean pago;
    private LocalDate vencimento, dataPagamento;
    
    //Construtores
    public Despesa () {
        
    }

    public Despesa(int id, String descricao, float valor, boolean pago, LocalDate vencimento, LocalDate dataPagamento) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.pago = pago;
        this.vencimento = vencimento;
        this.dataPagamento = dataPagamento;
    }
    
    public Despesa(int id, String descricao, float valor, boolean pago, LocalDate vencimento) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.pago = pago;
        this.vencimento = vencimento;
        this.dataPagamento = null;
    }
    
    //Métodos Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    //Métodos Sobrescritos
    @Override
    public String toString () {
        return descricao + " - R$" + valor + ", Vencimento: " + vencimento.toString() + " - " + (pago?"PAGO":"SEM PAGAR");
    }
    
    @Override
    public boolean equals (Object outro) {
        try {
            Despesa despesa = (Despesa) outro;
            return despesa.id == this.id;
        } catch (Exception e) {
            return false;
        }
    }
}
