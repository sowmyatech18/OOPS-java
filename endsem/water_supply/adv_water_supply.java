package adv_water_supply;
import java.util.Scanner;
import java.io.*;

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

interface EmergencyShutDown{
	public void  AutoSmartFilter()throws Exception;
}
class SmartFilter extends WaterSource implements EmergencyShutDown{
	protected int purityCore;
	
	SmartFilter(int id,String location,double capacity,int purityCore){
		super(id,location,capacity);
		this.purityCore=purityCore;
	}
	
	public void AutoSmartFilter() throws Exception {
		if(purityCore<20) {
			throw new Exception();
		}
		System.out.println("Status: FLOW STABLE. AQUATOPIA STANDARDS SECURE.");
	}
	
	
}
public class adv_water_supply {

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
			
			try {
				System.out.println("Purity Core Level: "+list[i].purityCore +"% ");
				
				if((list[i].purityCore)<20){
					list[i].AutoSmartFilter();
				}
			}
			catch(Exception e) {
				System.out.println("[!] CRITICAL: SHUTDOWN TRIGGERED AT SOURCE"+ list[i].id);
				System.out.println("[!] REASON: Purity level below zero-waste threshold.");
			}
			
			System.out.println("---------------------------------------------");
		}
		
		try {
			FileWriter fw=new FileWriter("water.txt",true);
			for(int i=0;i<ch;i++) {
				fw.write("System Check: Source ID ["+ list[i].id +"] at "+list[i].location+"\n");
				fw.write("Purity Core Level: "+list[i].purityCore +"% \n");
			}
			fw.close();
		}
		
		catch(IOException e) {
			System.out.println("File not found");
		}
		
		try {
			FileReader fr=new FileReader("water.txt");
			
			System.out.println("\n ====READING THE TEXT FILE====");
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
		sc.close();
	}

}
