
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Robust ATM Simulation console application
 * Features: Exception Handling, Input Validation, and OOP Encapsulation.
 */
public class ATMSimulator {
    private double balance = 1000.0; 
    private final int PIN = 1234;
    private final Scanner scanner = new Scanner(System.in);



    
    public void start() {
        System.out.println("=== Welcome to Java Bank ===");
        System.out.print("Enter Secret PIN: ");
        
        try {
            int enteredPin = scanner.nextInt();
            if (enteredPin == PIN) {
                showMenu();
            } else {
                System.out.println("Error: Incorrect PIN");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input: PIN must be numeric");
        }
    }

    private void showMenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n1. View Balance | 2. Deposit | 3. Withdraw | 4. Logout");
            System.out.print("Select Option: ");
            
            try {
                choice = scanner.nextInt();
                processChoice(choice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Option. Please enter a number (1-4).");
                scanner.next(); // Clear the invalid input from buffer
            }
        }
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1 -> System.out.printf("Current Balance: ₹%.2f\n", balance);
            case 2 -> handleDeposit();
            case 3 -> handleWithdrawal();
            case 4 -> System.out.println("Thank you for using Java Bank. Goodbye!");
            default -> System.out.println("Option out of range. Try 1-4.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter Deposit Amount: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Success! Amount added to account.");
        } else {
            System.out.println("Invalid amount. Deposit must be positive.");
        }
    }

    private void handleWithdrawal() {
        System.out.print("Enter Withdrawal Amount: ");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Transaction Failed: Insufficient Balance.");
        } else if (amount <= 0) {
            System.out.println("Error: Amount must be greater than zero.");
        } else {
            balance -= amount;
            System.out.println("Success! Please collect your cash.");
        }
    }

    public static void main(String[] args) {
        new ATMSimulator().start();
    }
}