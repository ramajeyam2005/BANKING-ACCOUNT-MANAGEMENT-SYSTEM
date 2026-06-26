import java.util.Scanner;

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        bank.loadAccounts();

        while(true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Display Accounts");
            System.out.println("6. Save Data");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");

                    int type = sc.nextInt();

                    if(type == 1) {
                        bank.createAccount(
                                new SavingsAccount(accNo, name, balance));
                    }
                    else {
                        bank.createAccount(
                                new CurrentAccount(accNo, name, balance));
                    }

                    break;

                case 2:

                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    System.out.print("Amount: ");
                    double deposit = sc.nextDouble();

                    bank.deposit(accNo, deposit);

                    break;

                case 3:

                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    System.out.print("Amount: ");
                    double withdraw = sc.nextDouble();

                    bank.withdraw(accNo, withdraw);

                    break;

                case 4:

                    System.out.print("From Account: ");
                    int from = sc.nextInt();

                    System.out.print("To Account: ");
                    int to = sc.nextInt();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    bank.transfer(from, to, amount);

                    break;

                case 5:

                    bank.displayAllAccounts();

                    break;

                case 6:

                    bank.saveAccounts();

                    break;

                case 7:

                    bank.saveAccounts();

                    System.out.println("Thank You!");

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}