public class CurrentAccount extends Account {

    private static final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(int accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    @Override
    public void withdraw(double amount) {

        if(balance + OVERDRAFT_LIMIT >= amount) {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Overdraft Limit Exceeded!");
        }
    }
}