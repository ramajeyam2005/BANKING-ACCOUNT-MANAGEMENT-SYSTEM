import java.io.Serializable;

public abstract class Account implements Serializable {

    private int accountNumber;
    private String customerName;
    protected double balance;

    public Account(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful!");
        }
    }

    public abstract void withdraw(double amount);

    public void displayAccount() {
        System.out.println("\nAccount Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Balance        : " + balance);
    }
}

    

