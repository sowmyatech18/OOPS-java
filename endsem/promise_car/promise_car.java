package promise_car;
import java.util.Scanner;
class Resident{
	int ID;
	String name;
	int age;
	
	Resident(int ID,String name,int age){
		this.ID=ID;
		this.name=name;
		this.age=age;
	}
}

class  CriticalCareResident extends Resident{
	int hr;
	String m_condn;
	
	CriticalCareResident(int ID,String name,int age,int hr,String m_condn){
		super(ID,name,age);
		this.hr=hr;
		this.m_condn=m_condn;
	}
	
}

public class promise_car {
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
		
		System.out.println("--- DAILY VITAL SIGN LOG --- ");
		for(int i=0;i<ch;i++) {
			System.out.println("Monitoring Resident: "+list[i].name+" (Condition: "+list[i].m_condn+")");
		}
		sc.close();
	}
}
