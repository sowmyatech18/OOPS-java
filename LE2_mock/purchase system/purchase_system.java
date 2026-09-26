class Customer{
	protected int id;
	protected String name;
	protected int phno;
	protected String pdt;
	protected int qty;
	
	Customer(int id,String name,int phno,String pdt,int qty){
		this.id=id;
		this.name=name;
		this.phno=phno;
		this.pdt=pdt;
		this.qty=qty;
	}
	
	void  displayCustomerDetails() {
		System.out.println("|Custormer ID:"+id+"|Custormer name:"+name+"|Custormer phno:"+phno);
	}
	void Placeorder() {
		System.out.println("Order placed successfully");
	}
}

class Onlinecustomer extends Customer{
	int offer=100;
	
	Onlinecustomer(int id,String name,int phno,String pdt,int qty){
		super(id,name,phno,pdt,qty);
	}
	void Placeorder() {
		System.out.println("Order placed successfully");
		System.out.println("Offer provided for Rs."+offer);
	}
}
public class purchase_system {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer obj=new Customer(1,"Sowmya",23456,"Lemon",2);
		obj.displayCustomerDetails();
		obj.Placeorder();
		
		Customer obj1=new Onlinecustomer(2,"Aashika",67899,"Orange",9);
		obj1.displayCustomerDetails();
		obj1.Placeorder();
	}

}
