import java.io.*;
abstract class Account{
	protected int accountNumber;
	protected String accountHolderName;
	protected double balance;
	
	Account(int accountNumber,
	String accountHolderName,
	double balance){
		this.accountNumber=accountNumber;
		this.accountHolderName=accountHolderName;
		this.balance=balance;
	}
	
	abstract void calculateIntrest();
	
	final double min_bal=1000;
	
	final void generateStatement() {
	    System.out.println("Account Number:" + accountNumber);
	    System.out.println("Account Holder:" + accountHolderName);
	    System.out.println("Balance:" + balance);
	}
}

interface TransactionService {
    void deposit(double amount) throws Exception;
    void withdraw(double amount) throws Exception;
}

class PremiumAccount extends Account implements TransactionService{
	protected double withdrawalLimit;
	
	PremiumAccount(int accountNumber,
			String accountHolderName,
			double balance,double withdrawalLimit){
		super(accountNumber,accountHolderName,balance);
		this.withdrawalLimit=withdrawalLimit;
	}
	
	void calculateIntrest() {
	    double interest = balance * 0.05;
	    System.out.println("Interest: " + interest);
	}
	
	@Override
	public void deposit(double amount) throws Exception {
	    if (amount <= 0) {
	        throw new Exception("Invalid amount");
	    }
	    balance += amount;
	}

	@Override
	public void withdraw(double amount) throws Exception {
	    if (amount <= 0) {
	        throw new Exception("Invalid amount");
	    }

	    else if ((balance - amount) < min_bal) {
	        throw new Exception("Insufficient balance");
	    }

	    balance -= amount;
	}
}
public class adv_bank_system {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account obj = new PremiumAccount(1001,"Rahul",20000,5000);
		TransactionService obj1 = new PremiumAccount(1001,"Rahul",20000,5000);
		
		obj.generateStatement();
		obj.calculateIntrest(); 
		
        try {
            obj1.deposit(5000);
            obj1.withdraw(2000);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            FileWriter fw = new FileWriter("accounts.txt", true);
            fw.write("|Account Number: " + obj.accountNumber + 
                     " |Balance: " + obj.balance + "\n");
            fw.close();
        } 
        catch(IOException e) {
            System.out.println("File error");
        }

        try {
            FileReader fr = new FileReader("accounts.txt");
            int a;
            while((a = fr.read()) != -1) {
            		char b=(char)a;
                System.out.print(b);
            }
            fr.close();
        } 
        catch(IOException e) {
            System.out.println("File error");
        }	
	}
}
