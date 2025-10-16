public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountHolderName, double currentBalance, double overdraftLimit) {
        super(accountHolderName, currentBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit() {
        this.overdraftLimit = overdraftLimit;
    }

    @Override //override withdrawal to allow overdraft
    public void makeWithdrawal(double amount) {
        if (amount > getCurrentBalance() + overdraftLimit) {
            System.out.println("Error: Exceeded overdraft limit!");
        } else {
            super.makeWithdrawal(amount); //allows balance to go negative within overdraft
        }
    }
}
