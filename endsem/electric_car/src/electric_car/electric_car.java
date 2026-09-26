package electric_car;
import java.util.Scanner;

class Vehicle{
	protected int vno;
	protected String manu;
	protected double battery;
	
	Vehicle(int vno,String manu,double battery){
		this.vno=vno;
		this.manu=manu;
		this.battery=battery;
	}
	
	public void showSpec() {
		System.out.println("--- Traffic Grid Data Log --- ");
		System.out.println("Vehicle No (vno):"+vno);
		System.out.println("Manufacturer:"+manu);
		System.out.println("Status: Electric | Battery:"+battery+"kWh");
	}
	
}


class ElectricCar extends Vehicle{
	int c_time;
	ElectricCar(int vno,String manu,double battery,int c_time){
		super(vno,manu,battery);
		this.c_time=c_time;
	}
	
	@Override
	public void showSpec() {
		super.showSpec();
		System.out.println("The Whisper: Driver, you have "+battery*5 +" miles left.");
		System.out.println("---------------------------------------------------------");
	}
}
public class electric_car {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ElectricCar[] list=new ElectricCar[3];
		
		for(int i=0;i<3;i++) {
			System.out.println("Recording vehicle #"+(i+1));
			System.out.print("Enter vno:");
			int vno=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter make:");
			String make=sc.nextLine();
			System.out.print("Enter battery(kWh):");
			double b=sc.nextDouble();
			sc.nextLine();
			System.out.print("Enter Charging time:");
			int ct=sc.nextInt();
			sc.nextLine();
			list[i]=new ElectricCar(vno,make,b,ct);

		}
		
		System.out.println("\n>>> Displaying Active Fleet Registry <<< ");
        for (int i = 0; i < 3; i++) {
            list[i].showSpec();
        }
		sc.close();
	}

}
