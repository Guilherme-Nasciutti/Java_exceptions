package application;

import model.entites.Account;
import model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class ProgramAccount {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account data:");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.print("Holder: ");
        scanner.nextLine();
        String holder = scanner.nextLine();
        System.out.print("Initial balance: $");
        double balanceInitial = scanner.nextDouble();
        System.out.print("Withdraw limit: $");
        double withdrawLimit = scanner.nextDouble();

        Account account = new Account(number, holder, balanceInitial, withdrawLimit);
        System.out.println();
        System.out.print("Enter amount for withdraw: $");
        double amount = scanner.nextDouble();

        try {
            account.withdraw(amount);
            System.out.printf("New balance: %.2f", account.getBalance());
        } catch (BusinessException businessException) {
            System.out.println("Withdraw Error: " + businessException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Error unexpected!");
        }
        scanner.close();
    }
}
