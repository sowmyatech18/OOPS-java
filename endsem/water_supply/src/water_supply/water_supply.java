package water_supply;
import java.util.Scanner;

abstract class WaterSource{
	protected int id;
	protected String location;
	protected double capacity;
	
	WaterSource(int id,String location,double capacity){
		this.id=id;
		this.location=location;
		this.capacity=capacity;
	}

}

class SmartFilter extends WaterSource{
	protected int purityCore;
	
	SmartFilter(int id,String location,double capacity,int purityCore){
		super(id,location,capacity);
		this.purityCore=purityCore;
	}
	
	
}
public class water_supply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("--- Welcome to the Aquatopia Distribution Grid --- ");
		System.out.print("Enter number of units to calibrate:");
		int ch=sc.nextInt();
		sc.nextLine();
		
		SmartFilter [] list=new SmartFilter[ch];
		
		for(int i=0;i<ch;i++) {
			System.out.println("--- Calibrating Unit #"+(i+1)+"--- ");
			System.out.print("Source ID:");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.print("Location name:");
			String n=sc.nextLine();
			System.out.print("Max Capacity(L):");
			double c=sc.nextDouble();
			System.out.print("PurityCore (0-100):");
			int p=sc.nextInt();
			
			list[i]=new SmartFilter(id,n,c,p);
		}
		System.out.println("[System] All units burned into Hydrology Ledger. ");
		System.out.println();
		System.out.println("--- ACCESSING THE HYDROLOGY LEDGER --- ");
		
		for(int i=0;i<ch;i++) {
			System.out.println("System Check: Source ID ["+ list[i].id +"] at "+list[i].location);
			System.out.println("Purity Core Level: "+list[i].purityCore +"% ");
			System.out.println("---------------------------------------------");
			
		}
		sc.close();
	}

}
