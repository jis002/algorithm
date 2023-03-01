import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int sugar = N;
		int bag5 = 0;
		int bag3 = 0;
		
		while(sugar > 0) {
			if(sugar%5==0) {
				bag5 = sugar/5;
				sugar -= bag5*5;
				break;
			} else {
				sugar -= 3;
				bag3++;
			}	
		}
			
		if(sugar==0) {
			System.out.println(bag5+bag3);
		} else {
			System.out.println("-1");
		}

	}

}