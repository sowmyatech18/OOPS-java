import java.io.*;
import java.util.Scanner;
abstract class Customer{
	protected int id;
	protected String name;
	protected int qty;
	protected String type;

	
	Customer(int id,String name,int qty,String type){
		this.id=id;
		this.name=name;
		this.qty=qty;
		this.type=type;
	}
	static final int max_order_limit=50;
	abstract void Placeorder()throws Exception;
	abstract void Calculatebill();
	
}

interface Payable{
	public void processPayment() throws Exception;
}

class Onlinecustomer  extends Customer implements Payable{
	Scanner sc=new Scanner(System.in);
	
	Onlinecustomer(int id,String name,int qty,String type){
		super(id,name,qty,type);
	}
	
	public void processPayment()throws Exception {
		if(type.equalsIgnoreCase("upi")) {
			System.out.print("Enter UPI ID:");
			String uid=sc.next();
		}
		else if(type.equalsIgnoreCase("card")) {
			System.out.print("Enter card number:");
			String cno=sc.next();
		}
		
		else {
			throw new Exception("Invalid Payment type");
		}
	}
	
	public void Placeorder() throws Exception {
		if(qty>max_order_limit) {
			throw new Exception("Out of stock Exception");
		}
		
		else {
			System.out.println("Order placed successfully");
		}
	}
	
	public void Calculatebill() {
		System.out.println("|Custormer ID:"+id+"|Custormer name:"+name+"|Custormer qty:"+qty+"|Payment mode:"+type);
	}
}
public class adv_purchase_system {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Onlinecustomer obj=new Onlinecustomer(241,"Headphone",1,"card");
		System.out.println("Your bill");
		obj.Calculatebill();
		try {
			obj.processPayment();
			obj.Placeorder();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
			
		try {
			FileWriter fw=new FileWriter("data.txt",true);
			System.out.println("Data saved in file");
			fw.write("|Custormer ID:"+obj.id+"|Custormer name:"+obj.name+"|Custormer qty:"+obj.qty+"|Payment mode:"+obj.type);
			fw.close();
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
		try {
			FileReader fr=new FileReader("data.txt");
			int a;
			while((a=fr.read())!=-1) {
				char b=(char)a;
				System.out.print(b);
			}
			fr.close();
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
		
	}

}
