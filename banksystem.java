import java.util.Scanner;

class BankAccount {

    private String acc_no;
    private String acc_holder;
    private double balance;

    public BankAccount() {
        acc_no = "N/A";
        acc_holder = "N/A";
        balance = 0.0;
    }


    public BankAccount(String acc_no, String acc_holder, double balance) {
        this.acc_no = acc_no;
        this.acc_holder = acc_holder;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0.0;
        }

    }

    public void deposit(double amt) {
        balance=balance+amt;
        System.out.println("New Balance: " + balance);
    }

    // Withdraw method
    public void withdraw(double amt) {
        if (amt > balance) {
            System.out.println("Insufficient balance!");
            System.out.println("Balance remains: " + balance);
        } else {
            balance=balance-amt;
            System.out.println("Updated Balance: " + balance);
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + acc_no);
        System.out.println("Account Holder: " + acc_holder);
        System.out.println("Balance: " + balance);
    }
}


public class banksystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Default account
        BankAccount bank_acc = new BankAccount();
        System.out.println("Default Account Details:");
        bank_acc.displayAccountDetails();
        System.out.println();

        // User input
        System.out.print("Account number: ");
        String acc_no = sc.nextLine();

        System.out.print("Account holder name: ");
        String acc_holder = sc.nextLine();

        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();

        bank_acc = new BankAccount(acc_no, acc_holder, balance);

        System.out.println();
        System.out.println("Your transaction is being processed");

        System.out.print("Deposit amount: ");
        double deposit_amt = sc.nextDouble();
        bank_acc.deposit(deposit_amt);
        System.out.println();

        System.out.print("Withdraw amount: ");
        double withdraw_amt = sc.nextDouble();
        bank_acc.withdraw(withdraw_amt);
        System.out.println();

        System.out.println("Final Account Details:");
        bank_acc.displayAccountDetails();

        sc.close();
    }
}

