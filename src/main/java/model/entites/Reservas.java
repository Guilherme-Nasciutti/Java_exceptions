package model.entites;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {

    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) {
        Date agora = new Date();
        if (checkIn.before(agora)) {
            throw new DomainException("A data de checkIn precisa ser maior que a data atual!");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("A data de checkout precisa ser posterior a data de checkIn!");
        }
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Long duration() {
        long diferenca = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void atualizacaoReservas(Date checkIn, Date checkOut) {
        Date agora = new Date();
        if (checkIn.before(agora)) {
            throw new DomainException("A data de checkIn precisa ser maior que a data atual!");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("A data de checkout precisa ser posterior a data de checkIn!");
        }
        if (checkIn.before(agora) || checkOut.before(agora)) {
            throw new DomainException("As datas para reservas precisam ser futuras a data atual!");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Quarto: "
                + numeroQuarto
                + ", Data de checkIn: "
                + formatoData.format(checkIn)
                + ", Data de checkOut: "
                + formatoData.format(checkOut)
                + ", Duração: "
                + duration()
                + " noites.";
    }

}
