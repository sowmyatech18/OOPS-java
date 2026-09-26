import java.util.Scanner;
class movie{
	private String title;
	private String director;
	private double rating;
	
	public movie(){
		title="";
		director="";
		rating=0.0;
	}
	public movie(String title,String director,double rating) {
		this.title=title;
		this.director=director;
		this.rating=rating;
	}
	
	public String gettitle(){
		return title;
	}
	public String getdirector() {
		return director;
	}
	public double getrating() {
		return rating;
	}
	public void dispbydir(String dir,movie[] mov) {
		for(int i=0;i<mov.length;i++) {
			if(dir.equals(mov[i].getdirector())) {
				System.out.println(mov[i].gettitle());
			}
		}
	}
	
	public void dispbyrate(double lim,movie[] mov) {
		for(int i=0;i<mov.length;i++) {
			if(mov[i].getrating()>lim) {
				System.out.println(mov[i].gettitle());
			}
		}
	}
	public void dispall(movie[] mov) {
		for(int i=0;i<mov.length;i++) {
			System.out.println(mov[i].gettitle());
		}
	}
}
public class moviemanager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of movies to add:");
		int n=sc.nextInt();
		sc.nextLine();
		movie []mov=new movie[n];
		for(int i=0;i<n;i++) {
			System.out.print("Title:");
			String t=sc.nextLine();
			System.out.print("Director:");
			String d=sc.nextLine();
			System.out.print("Rating:");
			double r=sc.nextDouble();
			sc.nextLine();
			mov[i]=new movie(t,d,r);
		}
		movie obj=new movie();
		int c=0;
		do {
			System.out.println("---Movie manager---");
			System.out.println("1.Search by director");
			System.out.println("2.Search by rating");
			System.out.println("3.Display all");
			System.out.println("4.Exit");
			System.out.print("Enter choice:");
			c=sc.nextInt();
			sc.nextLine();
			switch(c) {
			case 1:
				System.out.println("Director name");
				String dir=sc.next();
				obj.dispbydir(dir,mov);
				break;
			case 2:
				System.out.println("Enter rating limit:");
				double lim=sc.nextDouble();
				obj.dispbyrate(lim,mov);
				break;
			case 3:
				obj.dispall(mov);
				break;
			case 4:
				break;
			}
		}while(c!=4);
	}

}
