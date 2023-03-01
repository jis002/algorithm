import java.util.Scanner;

public class Main {

	static int[] dp = new int[100];
	static {
		dp[0] = 1;
		dp[1] = 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = Fibo(n);
		System.out.println(result);
	}

	private static int Fibo(int n) {
		if(n<2) return n;
		
		if( dp[n] == 0 ) {
			dp[n] = Fibo(n-1) + Fibo(n-2);
		}
		return dp[n];
	}

}