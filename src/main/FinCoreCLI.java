import java.util.Scanner;

// === TRY GENERATE, RIGHT CLICK  ===


public class FinCoreCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //creating objects of classes
        Account account = new Account("Jane Doe", 1000);
        ServiceHandler handler = new ServiceHandler(scanner);

        System.out.println("\nWelcome to FinCore CLI Banking!");

        System.out.println("\nAccount Holder: " + account.getAccountHolderName());
        System.out.println("\nAccount Number: " + account.getAccountNumber());

        System.out.println("Initial Balance: £" + account.getCurrentBalance());

        String option;

        do {
            System.out.println("\n=== FinCore CLI Banking Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Please select an option (input number 1-4): ");
            option = scanner.nextLine();

            switch (option) {
                case "1": //deposit
                    handler.deposit(account);
                    break;
                case "2": //withdraw
                    handler.withdraw(account);
                    break;
                case "3": //check balance
                    handler.checkBalance(account);
                    break;
                case "4": //exit
                    System.out.println("\nThank you for using FinCore CLI Banking!");
                    break;
                default: //invalid choices
                    System.out.println("Invalid choice. Please try again and enter a number between 1 and 4.");
                    break;
            }
        } while (!option.equals("4"));
    }
}