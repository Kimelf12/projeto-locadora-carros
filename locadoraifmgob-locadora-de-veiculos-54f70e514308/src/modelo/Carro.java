package modelo;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class Carro {
    //Atributos
    private String placa, marca, cor, modelo, acessorio;
    private int ano;
    private float valorHora;
    private boolean seguro;
    
    //Construtores
    public Carro () {
        
    }
    
    public Carro(String placa, String marca, String cor, String modelo, int ano, float valorHora, boolean seguro, String acessorio) {
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
        this.valorHora = valorHora;
        this.seguro = seguro;
        this.acessorio = acessorio;
        this.marca = marca;
    }
    
    //Métodos Getters e Setter
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getValorHora() {
        return valorHora;
    }

    public String getAcessorio() {
        return acessorio;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public void setAcessorio(String acessorio) {
        this.acessorio = acessorio;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    //Métodos sobrescritos
    @Override
    public boolean equals (Object outro) {
        try {
            Carro carro = (Carro) outro;
            return carro.placa.equals(this.placa);
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public String toString () {
        return placa + " - " + marca + " - " + modelo + " (" + ano + ")";
    }
    
}
