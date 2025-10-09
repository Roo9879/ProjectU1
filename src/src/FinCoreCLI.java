import java.util.Scanner;

public class FinCoreCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentBalance = 1000;
        String accountHolderName = "Jane Doe";

        System.out.println(" ");
        System.out.println("Welcome to FinCore CLI Banking!");
        System.out.println("Application initialised successfully");
        System.out.println(" ");

        System.out.println("Account Holder: " + accountHolderName);
        //pre-determined for now but assuming we'll add in options to input name so it can fetch correct account balance etc

        System.out.println("Initial Balance: £" + currentBalance);

        String option;

        do {
            System.out.println(" ");
            System.out.println("=== FinCore CLI Banking Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Please select an option (1-4): ");
            option = scanner.nextLine();

            switch (option) {
                case "1": //deposit
                    currentBalance = makeDeposit(scanner, currentBalance);
                    break;
                case "2":
                    //withdraw
                    break;
                case "3":
                    //check balance
                    break;
                case "4": //exit
                    System.out.println(" ");
                    System.out.println("Thank you for using FinCore CLI Banking!");
                    break;
                default: //invalid choices
                    System.out.println("Invalid choice. Please try again");
                    break; // want it to get them to try again
            }
        } while (!option.equals("4"));
    }

    public static int makeDeposit(Scanner scanner, int currentBalance) {
        boolean valid = false;
        int depositAmount = 0;
        while (!valid) {
            System.out.println(" ");
            System.out.println("Enter your amount to deposit (or 'x' to cancel): £");
            String input = scanner.nextLine();

            // check for cancel option
            if (input.equalsIgnoreCase("x")) {
                System.out.println(" ");
                System.out.println("Deposit cancelled, returning to main menu");
                return currentBalance;
            }
            // parsing input (String) to int so can add onto balance
            // validation so must be a positive integer and a number, not a string, char or symbol etc
            try{
                depositAmount = Integer.parseInt(input);
                if(depositAmount > 0){
                    valid = true;
                } else {
                    System.out.println("Please enter a positive integer");
                }
            } catch(NumberFormatException e){
                System.out.println("Invalid input. Please try again and enter a number");
            }
        }
        // adding deposit amount to balance and outputting to user
        currentBalance += depositAmount;
        System.out.println(" ");
        System.out.println("Deposit successful! New balance: £" + currentBalance);
        return currentBalance;
    }
}
