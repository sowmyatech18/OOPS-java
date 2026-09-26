	package adv_voting_system;
	import java.util.Scanner;
	abstract class Voter{
		private int vid;
		protected String name;
		protected int age;
		protected String place;
		
		Voter(int vid,String name,int age,String place){
			this.vid=vid;
			this.name=name;
			this.age=age;
			this.place=place;
		}
		
		public int getvid() {
			return vid;
		}
		
		void displayVoterDetails() {
			System.out.println("---Voter details---");
			System.out.println("Voter ID:"+getvid());
			System.out.println("Voter name:"+name);
			System.out.println("Vote age:"+age);
			System.out.println("Voter place:"+place);
		}
		void isEligibleToVote() {
			System.out.println("Voter is eligible to vote.");
		}
		abstract void castVote();
		
	}
	
	interface Verifiable{
		void verifyIdentity();
	}
	
	class OnlineVoter extends Voter implements Verifiable{
		private String mode;
		
		OnlineVoter(int vid,String name,int age,String place,String mode){
			super(vid,name,age,place);
			this.mode=mode;
		}
		
		@Override
		void displayVoterDetails() {
		    super.displayVoterDetails();
		    System.out.println("Voting mode: " + mode);
		}
		
		void castVote() {
			if(getvid()<5000) {
				System.out.println("Online authentication successful.  ");
				System.out.println("Vote cast successfully through Online Voting.  ");
			}
		}
	}
	
	public class adv_voting_system {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			while(true) {
				System.out.println("--Give voter details--");
				System.out.print("Enter id:");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter name:");
				String n=sc.nextLine();
				System.out.print("Enter age:");
				int a=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter place:");
				String p=sc.nextLine();
				System.out.print("Enter mode:");
				String m=sc.nextLine();
				OnlineVoter obj=new OnlineVoter(id,n,a,p,m);
				
				obj.displayVoterDetails();
				obj.isEligibleToVote();
				obj.castVote();
				
				System.out.println("You want to stop(y/n)?");
				String ans=sc.next();
				if(ans.equalsIgnoreCase("y")) {
					break;
				}
			}
			
			sc.close();
		}
	}
