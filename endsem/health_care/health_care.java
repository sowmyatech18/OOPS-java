package health_care;
import java.util.Scanner;
class Patient{
	protected String patientID;
	protected String name;
	
	Patient(String patientID,String name){
		this.patientID=patientID;
		this.name=name;
	}
	
	void  displayBasicInfo() {
		System.out.println("|Patient ID: "+patientID+" |Name: "+name);
	}
}

class InPatient extends Patient{
	protected int m_stay;
	protected double m_rate;
	
	InPatient(String patientID,String name,int m_stay,double m_rate){
		super(patientID,name);
		this.m_stay=m_stay;
		this.m_rate=m_rate;
	}
}
public class health_care {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		InPatient obj;
		int i=1;
		while(i<4) {
			System.out.println("Registring patient #"+i);
			System.out.print("Enter Patient ID:");
			String id=sc.next();
			sc.nextLine();
			System.out.print("Enter Patient Name:");
			String n=sc.nextLine();
			System.out.print("Enter Monthly stay:");
			int ms=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Monthly rate:");
			double mr=sc.nextDouble();
			sc.nextLine();
			obj=new InPatient(id,n,ms,mr);
			
			obj.displayBasicInfo();
			System.out.println("Applying long term therapy and monitoring ");
			System.out.println("Calculated bill: $"+ms*mr);
			System.out.println("------------------------------------------");
			
			i++;
		}
		sc.close();
	
	}

}
