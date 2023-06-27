package application;

import model.entites.Reservas;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProgramaReservas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero do quarto: ");
            int numeroQuarto = scanner.nextInt();
            System.out.print("Data de checkIn (DD/MM/YYYY): ");
            Date checkIn = formatoData.parse(scanner.next());
            System.out.print("Data de checkOut (DD/MM/YYYY): ");
            Date checkOut = formatoData.parse(scanner.next());

            Reservas reserva = new Reservas(numeroQuarto, checkIn, checkOut);
            System.out.println("\nReserva: " + reserva);

            System.out.println("\nDigite os dados para alteração da reserva:");
            System.out.print("Data de checkIn (DD/MM/YYYY): ");
            checkIn = formatoData.parse(scanner.next());
            System.out.print("Data de checkOut (DD/MM/YYYY): ");
            checkOut = formatoData.parse(scanner.next());

            reserva.atualizacaoReservas(checkIn, checkOut);
            System.out.println("Reserva atualizada: " + reserva);
        } catch (ParseException parseException) {
            System.out.println("Formato de data inválido!");
        } catch (DomainException domainException) {
            System.out.println("Erro na reserva: " + domainException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Erro inesperado!");
        }
        scanner.close();
    }
}