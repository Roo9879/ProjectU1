import java.util.Scanner;

public class ServiceHandler {
    private Scanner scanner;
    //constructor
    public ServiceHandler (Scanner scanner) {
        this.scanner = scanner;
    }

    public void deposit(Account account) {
        System.out.print("\nEnter your amount to deposit (or 'x' to cancel) : £");
        String depositInput = scanner.nextLine();
        if (!depositInput.equalsIgnoreCase("x")) {
            try {
                double depositAmount = Double.parseDouble(depositInput);
                account.makeDeposit(depositAmount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number");
            }
        } else {
            System.out.println("\nDeposit cancelled, returning to main menu.");
        }
    }

    public void withdraw(Account account) {
        System.out.print("\nEnter your amount to withdraw (or 'x' to cancel): £");
        String withdrawalInput = scanner.nextLine();
        if (!withdrawalInput.equalsIgnoreCase("x")) {
            try {
                double withdrawalAmount = Double.parseDouble(withdrawalInput);
                account.makeWithdrawal(withdrawalAmount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number");
            }
        } else {
            System.out.println("\nWithdrawal cancelled, returning to main menu");
        }
    }

    public void checkBalance(Account account) {
        account.checkBalance(account.getCurrentBalance(), account.getAccountHolderName(), account.getAccountNumber());
    }
}
