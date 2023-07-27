package ProjectsFile;


    import java.util.Scanner;

class ATM {
    int pin;
    private double balance;

    public ATM(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public void showBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void resetPin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your new PIN: ");
        int newPin = scanner.nextInt();
        pin = newPin;
        System.out.println("PIN successfully reset!");
    }

    public void transferMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();

        if (amount <= balance) {
            System.out.print("Enter the recipient's account number: ");
            String accountNumber = scanner.next();
            balance -= amount;
            System.out.println("$" + amount + " transferred to account " + accountNumber + " successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class Main{
    public static void main(String[] args) {
        ATM atm = new ATM(1234, 1000.0); // Default PIN and balance

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == atm.pin) {
            System.out.println("1. Show Balance");
            System.out.println("2. Reset PIN");
            System.out.println("3. Transfer Money");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.showBalance();
                    break;
                case 2:
                    atm.resetPin();
                    break;
                case 3:
                    atm.transferMoney();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } else {
            System.out.println("Invalid PIN.");
        }
    }
}


