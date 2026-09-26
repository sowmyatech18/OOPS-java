class Account {
    protected int accountNumber;
    protected String accountHolderName;
    protected double balance;

    Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void displayAccountdetails() {
        System.out.println("Account Number:" + accountNumber);
        System.out.println("Account Holder:" + accountHolderName);
        System.out.println("Balance:" + balance);
    }
}

class PremiumAccount extends Account {
    protected double withdrawalLimit;

    PremiumAccount(int accountNumber, String accountHolderName,
                   double balance, double withdrawalLimit) {
        super(accountNumber, accountHolderName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountdetails() {
        System.out.println("Premium Account Number:" + accountNumber);
        System.out.println("Account Holder:" + accountHolderName);
        System.out.println("Balance:" + balance);
        System.out.println("Withdrawal limit:" + withdrawalLimit);
    }
}

public class bank_system {
    public static void main(String[] args) {

        Account obj;
        PremiumAccount obj1;

        obj = new Account(1001, "Rahul", 20000);
        obj.displayAccountdetails();

        obj1 = new PremiumAccount(2001, "Ananya", 50000, 10000);
        obj1.displayAccountdetails();
    }
}
