import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int sum = 0;
		for(int i=1; i<=N; i++) {
			sum += cntPair(i);
		}
		System.out.println(sum);
	}

	private static int cntPair(int i) {
		int cnt = 0;
		for(int j=1; j<=Math.sqrt(i); j++) {
			if(i%j==0) {
				cnt++;
			}
		}
		return cnt;
	}

}