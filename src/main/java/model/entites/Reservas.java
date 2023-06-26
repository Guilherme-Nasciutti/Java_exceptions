package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {

    private Integer numeroQuarto;
    private Date dataEntrada;
    private Date dataSaida;

    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public Reservas(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public long duracao() {
        long diferenca = dataSaida.getTime() - dataEntrada.getTime(); // Variavel diferença para calcular os milisecundos entre a saida e a entrada
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); // Usa a classe TimeUnit para converter em dias os milisecundos da variavel diferença
    }

    public void atualizacaoReserva(Date dataEntrada, Date dataSaida) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return "Quarto: "
                + numeroQuarto
                + ", Data de entrada: "
                + formatoData.format(dataEntrada)
                + ", Data de saída: "
                + formatoData.format(dataSaida)
                + ", "
                + duracao()
                + " noites.";
    }

}
