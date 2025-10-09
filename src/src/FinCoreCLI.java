import java.util.Scanner;

public class FinCoreCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = 1000;
        String accountHolderName = "Jane Doe";

        System.out.println("\nWelcome to FinCore CLI Banking!");

        System.out.println("\nAccount Holder: " + accountHolderName);
        //pre-determined for now but assuming we'll add in options to input name so it can fetch correct account balance etc

        System.out.println("Initial Balance: £" + currentBalance);

        String option;

        do {
            System.out.println("\n=== FinCore CLI Banking Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Please select an option (1-4): ");
            option = scanner.nextLine();

            switch (option) {
                case "1": //deposit
                    currentBalance = makeDeposit(scanner, currentBalance); //updates currentBalance value with returned version from method
                    break;
                case "2": //withdraw
                    currentBalance = makeWithdrawal(scanner, currentBalance);
                    break;
                case "3": //check balance
                    checkBalance(currentBalance, accountHolderName);
                    break;
                case "4": //exit
                    System.out.println("\nThank you for using FinCore CLI Banking!");
                    break;
                default: //invalid choices
                    System.out.println("Invalid choice. Please try again");
                    break;
            }
        } while (!option.equals("4"));
    }

    public static double makeDeposit(Scanner scanner, double currentBalance) {
        boolean valid = false;
        double depositAmount = 0;
        while (!valid) {
            System.out.print("\nEnter your amount to deposit (or 'x' to cancel): £");
            String input = scanner.nextLine();

            // check for cancel option
            if (input.equalsIgnoreCase("x")) {
                System.out.println("\nDeposit cancelled, returning to main menu");
                return currentBalance;
            }
            // parsing input (String) to int so can add onto balance
            // validation so must be a positive integer and a number, not a string, char or symbol etc
            try{
                depositAmount = Double.parseDouble(input);
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
        System.out.println("\nDeposit successful!");
        System.out.println("Amount deposited: £" + depositAmount);
        System.out.println("Your new balance is: £" + currentBalance);
        return currentBalance;
    }

    public static double makeWithdrawal(Scanner scanner, double currentBalance) {
        while (true) {
            System.out.print("\nEnter your amount to withdraw (or 'x' to cancel): £");
            String input = scanner.nextLine();

            //check for cancel option
            if (input.equalsIgnoreCase("x")) {
                System.out.println("\nWithdrawal cancelled, returning to main menu");
                return currentBalance;
            }
            // parsing string and validation steps
            try{
                double withdrawalAmount = Double.parseDouble(input);
                if(withdrawalAmount <=0){
                    System.out.println("Please enter a positive integer");
                } else if(withdrawalAmount > currentBalance){
                    // withdrawal amount must be smaller than current balance
                    // otherwise would go into -ves
                    System.out.println("Error: Insufficient funds");
                    System.out.println("Attempted withdrawal: £" + withdrawalAmount);
                    System.out.println("Your current balance is £" + currentBalance);
                } else {
                    // actual withdrawal calculation and output to user
                    currentBalance -= withdrawalAmount;
                    System.out.println("\nWithdrawal successful!");
                    System.out.println("Amount withdrawn: £" + withdrawalAmount);
                    System.out.println("Your new balance is: £" + currentBalance);
                    return currentBalance;
                }
            } catch(NumberFormatException e){
                System.out.println("Invalid input. Please try again and enter a number");
            }

        }
    }

    public static void checkBalance(double currentBalance, String accountHolderName) {
        System.out.println("\n=== Account Balance ===");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: £" + currentBalance);
    }
}

