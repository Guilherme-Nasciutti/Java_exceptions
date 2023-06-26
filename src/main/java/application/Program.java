package application;

import model.entites.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int numberRoom = scanner.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            Date checkIn = dateFormat.parse(scanner.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            Date checkOut = dateFormat.parse(scanner.next());

            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = dateFormat.parse(scanner.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = dateFormat.parse(scanner.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (ParseException parseException) {
            System.out.println("Invalid date format!");
        } catch (DomainException domainException) {
            System.out.println("Error in reservation: " + domainException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Unexpected error!");
        }
        scanner.close();
    }
}
