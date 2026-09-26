package adv_promise_car;
import java.util.Scanner;
import java.io.*;
import java.io.Serializable;

abstract class Resident implements Serializable{
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
			throw new ArithmeticException("Heart rate is 0");
		}
		else if(hr<60||hr>100) {
			throw new Exception("Abnormal heart rate detected");
		}
		
		else {
			System.out.println("Vitals are stable.");
		}
	}
	
}
public class adv_promise_car {

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
				System.out.println(e.getMessage());
			}
			catch(Exception e) {
				System.out.println("!!! EMERGENCY ALERT for "+list[i].name+" !!! Condition:"+list[i].m_condn+" "+list[i].hr+" detected. Contacting Hospital... ");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------------------");
		}
		
		//FILE HANDLING
		try {
			FileOutputStream fos =new FileOutputStream("care.dat",true);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			for(int i=0;i<ch;i++) {
				oos.writeObject(list[i]);
			}
			oos.close();
			fos.close();
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
		
		try {
			FileInputStream fis =new FileInputStream("care.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			System.out.println("==== Reading the file care.txt ====");
			
			for(int i=0;i<ch;i++) {
				CriticalCareResident k= (CriticalCareResident)ois.readObject();
				k.disp();
				k.triggerAmbulance();
			}
			
			ois.close();
			fis.close();
		}
		catch(IOException | ClassNotFoundException e) {
			System.out.println("File not found");
		} 
		catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR:"+e.getMessage());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR:"+e.getMessage());
		}
		
		sc.close();
	}

}
