package adv_electric_car;
import java.util.Scanner;
import java.io.*;

abstract class Vehicle{
	protected String vno;
	protected String manu;
	
	Vehicle(String vno,String manu){
		this.vno=vno;
		this.manu=manu;
	}
	
	public void showSpec() {
		System.out.println("Processing: Ecar [vno="+ vno+ " ,make="+ manu+ "]");
	}
}

interface EfficiencyStandard{
	public void calculateRange();
}

class ElectricCar extends Vehicle{
	protected double batteryCapacity;
	ElectricCar(String vno,String manu,double batteryCapacity){
		super(vno,manu);
		this.batteryCapacity=batteryCapacity;
	}
	
	@Override
	public void showSpec() {
		System.out.println("Processing: Ecar [vno="+ vno+ " ,make="+ manu+ " ,battery="+batteryCapacity+"]");
	}
	
	public void calculateRange() {
		double r=batteryCapacity*5;
		System.out.println(">> Range Update for ["+vno+"]: "+r+ " miles availabale.");
		System.out.println();
	}

}

//Vehicle-->ElectricCar-->Sedan

class Sedan extends ElectricCar implements EfficiencyStandard{
	protected String status;
	
	Sedan(String vno,String manu,double batteryCapacity,String status){
		super(vno,manu,batteryCapacity);
		this.status=status;
		
	}
	
	public void calculateRange() {
		super.calculateRange();
	}
}

//Vehicle-->HydrogenTruck

class HydrogenTruck extends Vehicle implements EfficiencyStandard{
	int hydrogenLevel;
	
	HydrogenTruck(String vno,String manu,int hydrogenLevel){
		super(vno,manu);
		this.hydrogenLevel=hydrogenLevel;
	}
	public void calculateRange() {
		double r=hydrogenLevel*5;
		System.out.println(">> Range Update for ["+vno+"]: "+r+ " miles availabale.");
		System.out.println();
	}
}
public class adv_electric_car {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("=== Aetheria Entry Port: Data Entry === ");
		ElectricCar[] list=new ElectricCar[3];
		
		for(int i=0;i<3;i++) {
			System.out.println("Recording vehicle #"+(i+1));
				System.out.print("Enter vno(or type 'skip' to test NPE):");
				String vno=sc.next();
				
				if(vno.equalsIgnoreCase("skip")) {
					vno="";
				}
				
				sc.nextLine();
				System.out.print("Enter make:");
				String make=sc.nextLine();
				System.out.print("Enter battery(kWh):");
				double b=sc.nextDouble();
				sc.nextLine();

				list[i]=new ElectricCar(vno,make,b);
		     
			
		}
		
		
		//EXCEPTION HANDLING
		for(int i=0;i<3;i++) {
			
			try {
				list[i].showSpec();
				if(list[i].vno.equals("")) {
					throw new NullPointerException();
				}
				
				if(list[i].batteryCapacity==0.0) {
					throw new ArithmeticException();
				}
				
				list[i].calculateRange();
			}
			catch(NullPointerException e){
				list[i].calculateRange();
				System.out.println("[System] vno is skipped.");
				
			}
			catch (ArithmeticException e) {
		        System.out.println("[System] Battery cannot be zero.");	
		    }       
		}
		
		//FILE HANDLING 
		try {
			FileWriter fw=new FileWriter("car.txt",true);
			for(int i=0;i<3;i++) {
				fw.write("Processing: Ecar [vno="+ list[i].vno+ " ,make="+ list[i].manu+ " ,battery="+list[i].batteryCapacity+"]"+"\n");
				fw.write(">> Range Update for ["+list[i].vno+"]: "+ list[i].batteryCapacity*5 + " miles availabale.\n");
			}
			System.out.println("data is saved into car.txt");
			fw.close();
		}
		catch(IOException e ) {
			System.out.println("File not found");
		}
		
		try {
			FileReader fr=new FileReader("car.txt");
			System.out.println("\n=== Reading from File ===");
			int a;
			while((a=fr.read())!=-1) {
				char b=(char)a;
				System.out.print(b);
			}
			fr.close();
		}
		catch(IOException e ) {
			System.out.println("File not found");
		}
		
		
		sc.close();
		
	}
	
}
