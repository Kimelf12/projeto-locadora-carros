package modelo;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class Aluguel {
    //Atributos
    private int id;
    private boolean pago, devolvido;
    private float valor;
    private LocalDateTime dataSaida, dataPrevisao, dataChegada;
    private Cliente cliente;
    private Carro carro;
    private Funcionario funcionario;
    
    //Construtores
    public Aluguel () {
           
    }
    
    public Aluguel (int id, Cliente cliente, Carro carro, Funcionario funcionario, LocalDateTime dataSaida, LocalDateTime dataPrevisao) {
        this.id = id;
        this.cliente = cliente;
        this.carro = carro;
        this.funcionario = funcionario;
        this.dataSaida = dataSaida;
        this.dataPrevisao = dataPrevisao;
        this.dataChegada = null;
        this.pago = false;
        this.devolvido = false;
    }
    
    public Aluguel (Cliente cliente, Carro carro, Funcionario funcionario, LocalDateTime dataSaida, LocalDateTime dataPrevisao) {
        this.cliente = cliente;
        this.carro = carro;
        this.funcionario = funcionario;
        this.dataSaida = dataSaida;
        this.dataPrevisao = dataPrevisao;
        this.dataChegada = null;
        this.pago = false;
        this.devolvido = false;
    }

    //Métodos Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalDateTime getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(LocalDateTime dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public LocalDateTime getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDateTime dataChegada) {
        this.dataChegada = dataChegada;
    }
    
    //Métodos criados
    public float getValorPrevisao () {
        Duration duracao = Duration.between(dataSaida, dataPrevisao);
        return duracao.getSeconds() / 3600 * carro.getValorHora();
    }
    
    public float devolverCarro (LocalDateTime dataChegada) {
        this.dataChegada = dataChegada;
        this.devolvido = true;
        Duration duracao = Duration.between(dataSaida, dataChegada);
        this.valor = duracao.getSeconds() / 3600 * carro.getValorHora();
        return valor;
    }
    
    public float devolverCarro () {
        return devolverCarro(LocalDateTime.now());
    }
    
    //Métodos Sobrescritos
    @Override
    public String toString () {
        return cliente + " - " + carro + " - " + funcionario;
    }
    
    @Override
    public boolean equals (Object outro) {
        try {
            Aluguel aluguel = (Aluguel) outro;
            return aluguel.id == this.id;
        } catch (Exception e) {
            return false;
        }
    }
    
}
