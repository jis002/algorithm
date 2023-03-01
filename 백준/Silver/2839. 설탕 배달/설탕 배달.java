import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int sugar = N;
		int bag5 = 0;
		int bag3 = 0;
		
		if(sugar >= 5) {
			bag5 = sugar/5;
			sugar -= bag5*5;
		}
		if(sugar >= 3) {
			bag3 = sugar/3;
			sugar -= bag3*3;
		}

		while(sugar!=0) {
			sugar = N;
			if(bag5>0) {
				bag5--;
				sugar -= bag5*5;
				bag3 = sugar/3;
				sugar -= bag3*3;
			} else {
				break;
			}
		}	
		
		if(sugar==0) {
			System.out.println(bag5+bag3);
		} else {
			System.out.println("-1");
		}

	}

}