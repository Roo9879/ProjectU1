public class Account {
    private String accountHolderName;
    private int accountNumber;
    private double currentBalance;
    // static field to auto increment account number every time account object is created
    private static int nextAccountNumber = 1;

    //Constructor
    public Account(String accountHolderName, double currentBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = nextAccountNumber;
        this.currentBalance = currentBalance;

        nextAccountNumber++; //increment account number
    }

    //getters and setters

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setAccountHolderName(String name) {
        this.accountHolderName = name;
    }

    //Account methods: Deposit, withdraw, check balance
    public void makeDeposit(double amount) {
        if (amount <= 0 ) {
            System.out.println("Amount must be positive.");
            return;
        }
        currentBalance += amount;
        System.out.println("\nDeposit successful!");
        System.out.println("Amount deposited: £" + amount);
        System.out.println("Your new balance is: £" + currentBalance);
    }

    public void makeWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive");
        } else if (amount > currentBalance) {
            System.out.println("Error: Insufficient funds");
            System.out.println("Attempted withdrawal: £" + amount);
            System.out.println("Your current balance is £" + currentBalance);
        } else {
            currentBalance -= amount;
            System.out.println("\nWithdrawal successful!");
            System.out.println("Amount withdrawn: £" + amount);
            System.out.println("Your new balance is: £" + currentBalance);
        }
    }

    public static void checkBalance(double currentBalance, String accountHolderName, int accountNumber) {
        System.out.println("\n=== Account Balance ===");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: £" + currentBalance);
    }
}