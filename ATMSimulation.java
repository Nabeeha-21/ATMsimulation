import java.util.Scanner;

class ATM {
    Account account = new Account();
    Scanner sc = new Scanner(System.in);

    public void start() {

        System.out.println("===== ATM SIMULATION SYSTEM =====");

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (!account.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN!");
            return;
        }

        System.out.println("Login Successful!");
        int choice;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Balance: Rs." + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    System.out.println("Deposit Successful!");
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdraw = sc.nextDouble();

                    if (account.withdraw(withdraw)) {
                        System.out.println("Withdrawal Successful!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 4:
                    System.out.println("Thank You for Using ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
