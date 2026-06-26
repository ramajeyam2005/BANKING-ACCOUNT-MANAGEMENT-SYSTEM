import java.io.*;
import java.util.*;

public class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();
    private final String FILE_NAME = "accounts.dat";

    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account Created Successfully!");
    }

    public Account findAccount(int accountNumber) {

        for(Account acc : accounts) {
            if(acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }

        return null;
    }

    public void deposit(int accountNumber, double amount) {

        Account acc = findAccount(accountNumber);

        if(acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public void withdraw(int accountNumber, double amount) {

        Account acc = findAccount(accountNumber);

        if(acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public void transfer(int fromAcc, int toAcc, double amount) {

        Account sender = findAccount(fromAcc);
        Account receiver = findAccount(toAcc);

        if(sender != null && receiver != null) {

            if(sender.getBalance() >= amount) {

                sender.withdraw(amount);
                receiver.deposit(amount);

                System.out.println("Transfer Successful!");
            } else {
                System.out.println("Insufficient Balance!");
            }

        } else {
            System.out.println("Invalid Account!");
        }
    }

    public void displayAllAccounts() {

        if(accounts.isEmpty()) {
            System.out.println("No Accounts Available!");
            return;
        }

        for(Account acc : accounts) {
            acc.displayAccount();
        }
    }

    public void saveAccounts() {

        try(ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(accounts);

            System.out.println("Accounts Saved Successfully!");

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadAccounts() {

        try(ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            accounts = (ArrayList<Account>) ois.readObject();

            System.out.println("Accounts Loaded Successfully!");

        } catch(Exception e) {
            System.out.println("No Previous Data Found.");
        }
    }
}
