package adv_promise_car_txt;
import java.util.Scanner;
import java.io.*;

abstract class Resident{
	protected int ID;
	protected String name;
	protected int age;
	
	Resident(int ID,String name,int age){
		this.ID=ID;
		this.name=name;
		this.age=age;
	}
	
	public abstract void disp();
}

interface EmergencyResponse{
	public void  triggerAmbulance() throws Exception ;
}
class  CriticalCareResident extends Resident implements EmergencyResponse{
	protected int hr;
	protected String m_condn;
	
	CriticalCareResident(int ID,String name,int age,int hr,String m_condn){
		super(ID,name,age);
		this.hr=hr;
		this.m_condn=m_condn;
	}
	
	@Override
	 public void disp() {
		System.out.println("Monitoring Resident: "+name+" (Condition: "+m_condn+")");
	}
	
	public void  triggerAmbulance() throws Exception {
		
		if (hr==0) {
			throw new ArithmeticException();
		}
		else if(hr<60||hr>100) {
			throw new Exception();
		}
		
		else {
			System.out.println("Vitals are stable.");
		}
	}
	
}
public class adv_promise_car_txt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		System.out.print("Enter number of residents to register:");
		int ch=sc.nextInt();
		
		CriticalCareResident [] list=new CriticalCareResident[ch];
		for(int i=0;i<ch;i++) {
			System.out.println("Registering Resident #"+(i+1));
			System.out.print("ID: ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String n=sc.nextLine();
			System.out.print("Age: ");
			int a=sc.nextInt();
			sc.nextLine();
			System.out.print("Current Heart Rate: ");
			int hr=sc.nextInt();
			sc.nextLine();
			System.out.print("Medical Condition: ");
			String mc=sc.nextLine();
			
			list[i]=new CriticalCareResident(id,n,a,hr,mc);
		}
		
		//EXCEPTION HANDLING
		System.out.println("--- DAILY VITAL SIGN LOG --- ");
		for(int i=0;i<ch;i++) {
			list[i].disp();
			try {
				list[i].triggerAmbulance();
			}
			catch(ArithmeticException e) {
				System.out.println("Heart rate can't be 0");
			}
			catch(Exception e) {
				System.out.println("!!! EMERGENCY ALERT for "+list[i].name+" !!! Condition:"+list[i].m_condn+" "+list[i].hr+" detected. Contacting Hospital... ");
			}
			System.out.println("---------------------------");
		}
		
		//FILE HANDLING
		try {
			FileWriter fw=new FileWriter("care.txt",true);
			for(int i=0;i<ch;i++) {
				fw.write("Monitoring Resident: "+list[i].name+" (Condition: "+list[i].m_condn+")\n");
				fw.write("Condition: "+list[i].m_condn+" " +list[i].hr+" detected.\n");
			}
			fw.close();
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
		
		try {
			FileReader fr=new FileReader("care.txt");
			int a;
			System.out.println("==== Reading the file care.txt ====");
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