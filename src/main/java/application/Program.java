package application;

import model.entites.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int numberRoom = scanner.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        Date checkIn = dateFormat.parse(scanner.next());
        System.out.print("Check-out date (DD/MM/YYYY): ");
        Date checkOut = dateFormat.parse(scanner.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = dateFormat.parse(scanner.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = dateFormat.parse(scanner.next());

            Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }


        scanner.close();
    }
}
