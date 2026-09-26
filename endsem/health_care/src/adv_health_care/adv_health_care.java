package adv_health_care;
import java.io.*;
import java.util.Scanner;

abstract class Patient{
	protected int patientID;
	protected String name;
	
	Patient(int patientID,String name){
		this.patientID=patientID;
		this.name=name;
	}
	
	void  displayBasicInfo() {
		System.out.println("ID: ["+patientID+"]"+" Name: "+name+ " -> Protocol: Long-term rehabilitative care.");
	}
}

interface IBillable{
	public void final_contract();
}

class LongTermResident extends Patient implements IBillable{
	protected int m_stay;
	protected double m_rate;
	
	LongTermResident(int patientID,String name,int m_stay,double m_rate){
		super(patientID,name);
		this.m_stay=m_stay;
		this.m_rate=m_rate;
	}
	
	public void final_contract() {
		double amt=m_stay*m_rate;
		System.out.println("Current Account Balance: $"+amt);
		System.out.println("----------------------------------- ");
	}
}
public class adv_health_care {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("=== Lumina Admissions=== ");
		
		LongTermResident[] list=new LongTermResident[3];
		for(int i=0;i<3;i++) {
			System.out.println("Bed Slot "+(i+1)+":");
			System.out.print("Enter Patient Name (or 'skip' for null):");
			String n=sc.nextLine();
			if(n.equals("skip")) {
				n="";
			}
			
			System.out.print("Enter ID:");
			int id=sc.nextInt();
			System.out.print("Enter Monthly stay:");
			int ms=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Monthly rate:");
			double mr=sc.nextDouble();
			sc.nextLine();
			list[i]=new LongTermResident(id,n,ms,mr);
		}
		System.out.println("[System] Securely archived 3 records.");
		System.out.println();
		
		//EXCEPTION HANDLING
		for(int i=0;i<3;i++) {
			try {
				list[i].displayBasicInfo();
				
				if(list[i].name.equals("")) {
					throw new NullPointerException();
				}
				list[i].final_contract();
			}
			catch(NullPointerException e) {
				System.out.println("[system] name is skipped");
				list[i].final_contract();
			}
		}
		
		//FILE HANDLING 
		try {
			FileWriter fw=new FileWriter("health.txt",true);
			for(int i=0;i<3;i++) {
				fw.write("ID: ["+list[i].patientID+"]"+" Name: "+list[i].name+ " -> Protocol: Long-term rehabilitative care.\n");
				double amount = list[i].m_stay * list[i].m_rate;
				fw.write("Current Account Balance: $" + amount + "\n");
				
			}
			System.out.println("Data is saved inside health.txt");
			fw.close();
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
		
		try {
			FileReader fr=new FileReader("health.txt");
			System.out.println("\n=== Reading from File ===");
			
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
