package application;

import model.entites.Reservas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProgramaReservas {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int numeroQuarto = scanner.nextInt();
        System.out.print("Data de entrada: ");
        Date dataEntrada = formatoData.parse(scanner.next());
        System.out.print("Data de saída: ");
        Date dataSaida = formatoData.parse(scanner.next());

        if (!dataSaida.after(dataEntrada)) {
            System.out.print("Erro na reserva: Data de saída precisa ser maior que a data de entrada!");
        } else {
            Reservas reservas = new Reservas(numeroQuarto, dataEntrada, dataSaida);
            System.out.println("\nReserva: " + reservas);

            System.out.println("\nDigite os dados para alteração da reserva:");
            System.out.print("Data de entrada: ");
            dataEntrada = formatoData.parse(scanner.next());
            System.out.print("Data de saída: ");
            dataSaida = formatoData.parse(scanner.next());

            String erro = reservas.atualizacaoReserva(dataEntrada, dataSaida);
            if (erro != null) {
                System.out.println("Erro na reserva: " + erro);
            } else {
                System.out.println("\nReservas: " + reservas);
            }
        }
        scanner.close();
    }
}