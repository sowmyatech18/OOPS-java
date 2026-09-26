package Q2;
import java.util.Scanner;

abstract class Vehicle{
	String vid;
	String brand;
	double rentperday;
	
	Vehicle(String vid,String brand,double rentperday){
		this.vid=vid;
		this.brand=brand;
		this.rentperday=rentperday;
	}
	
	public void displayDetails() {
		System.out.print("|Vehicle ID: "+vid+" |Brand: "+brand);
	}
	
	abstract double calculateRent(int days);
}

interface Insurable {
	public double getInsuranceAmount();
}

class Car  extends Vehicle  implements Insurable{
	int seatingCapacity;
	
	Car(String vid,String brand,double rentperday,int seatingCapacity){
		super(vid,brand,rentperday);
		this.seatingCapacity=seatingCapacity;
		
	}
	
	@Override
	 double calculateRent(int days) {
		return rentperday*days;
	}
	
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Seating capacity: "+seatingCapacity);
	}
	
	final public double getInsuranceAmount() {
		return 500;
	}
}

class Bike extends Vehicle{
	boolean isSportsModel;
	
	Bike(String vid,String brand,double rentperday,boolean isSportsModel){
		super(vid,brand,rentperday);
		this.isSportsModel=isSportsModel;
	}
	
	@Override
	
	double calculateRent(int days) {
		if(isSportsModel==true) {
			return rentperday * days * 1.2;
		}
		
		else {
			return rentperday*days;
		}
	}
	
	@Override
	
	public void displayDetails() {
		super.displayDetails();
		System.out.println(" |isSportsModel: " + isSportsModel);
	}
	
}
public class vehicle_rent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Car obj=new Car("C001","Toyota",1000,5);
		System.out.println("Rent for 5 days: Rs." + obj.calculateRent(5));
		System.out.println("Insurance: Rs." + obj.getInsuranceAmount());
		
		Vehicle obj1=new Bike("B003","Honda",1000,true);
		obj1.displayDetails();
        System.out.println("Rent for 6 days: Rs." + obj1.calculateRent(6));
        
        System.out.println();
        System.out.println("---Run time polymorphism---");
        Vehicle v=new Car("C001","Toyota",1000,5);
		System.out.println("Rent via runtime." + v.calculateRent(5));
		sc.close();
	}
}
