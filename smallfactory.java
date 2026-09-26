import java.util.Scanner;

class machine{
	Scanner sc=new Scanner(System.in);
	private int id;
	private String name;
	private int capacity;
	private int production_count;
	private String status;
	
	public machine() {
		id=0;
		name="";
		capacity=0;
		production_count=0;
		status="";
	}
	public machine(int id,String name,int capacity,int production_count,String status) {
		this.id=id;
		this.name=name;
		this.capacity=capacity;
		this.production_count=production_count;
		this.status=status;
	}
	
	public void details(machine[] mac,int num) {
		for(int i=0;i<num;i++) {
			System.out.print("Id:");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.print("Name:");
			String n=sc.nextLine();
			System.out.print("Capacity(units per hr):");
			int c=sc.nextInt();
			sc.nextLine();
			System.out.print("Production count:");
			int pc=sc.nextInt();
			sc.nextLine();
			System.out.print("Status:");
			String s=sc.nextLine();
			mac[i]=new machine(id,n,c,pc,s);
		}
	}
	
	public void dispall(machine[] mac) {
		for(int i=0;i<mac.length;i++) {
			System.out.println(mac[i].name);
		}
	}
	
	public void highprod(machine[] mac) {
		int high=mac[0].production_count;
		for(int i=0;i<mac.length;i++) {
			if(mac[i].production_count>high) {
				high=mac[i].production_count;
			}
		}
		System.out.println("The highest production count is ,");
		System.out.println(high);
	}
	
	public void stopmach(machine[] mac) {
		for(int i=0;i<mac.length;i++) {
			if(mac[i].status.equals("stop")) {
				System.out.println("The machine stopped is "+mac[i].name);
			}
		}
		
	}
	public void totalproductioncap(machine[] mac) {
		int tcap=0;
		for(int i=0;i<mac.length;i++) {
			tcap+=mac[i].capacity;
		}
		System.out.println("Total production capacity ,");
		System.out.println(tcap);
	}

}
public class smallfactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("No of machines:");
		int num=sc.nextInt();
		sc.nextLine();
		machine []mac=new machine[num];
		machine obj=new machine();
		int ch=0;
		do {
			System.out.println("1.Store details of machine");
			System.out.println("2.Display all machines.");
			System.out.println("3.Find the machine with highest production.");
			System.out.println("4.Stop a faulty machine.");
			System.out.println("5.Calculate total production of factory.");
			System.out.println("6.Exit");
			System.out.print("Enter choice");
			ch=sc.nextInt();
			switch(ch){
			case 1:
				obj.details(mac,num);
				break;
			case 2:
				obj.dispall(mac);
				break;
			case 3:
				obj.highprod(mac);
				break;
			case 4:
				obj.stopmach(mac);
				break;
			case 5:
				obj.totalproductioncap(mac);
				break;
			}	
		}while(ch!=6);
		
	}

}
