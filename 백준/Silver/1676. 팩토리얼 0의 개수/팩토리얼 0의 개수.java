import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt5 = 0;
		int cnt2 = 0;
		
		for(int i=1; i<=N; i++) {
			int target = i;
			
			while(target%5==0) {
				cnt5++;
				target = target/5;
			}
			while(target%2==0) {
				cnt2++;
				target = target/2;
			}
		}
		
		int ans = Math.min(cnt2, cnt5);
		System.out.println(ans);
	}

}