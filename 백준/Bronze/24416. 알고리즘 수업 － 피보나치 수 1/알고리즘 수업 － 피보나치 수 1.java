import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dp = new int[50];
	
	static int ans1 = 1; // 일반 재귀 시행 시
	static int ans2 = 1; // DP 시행 시
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
				
		fibo1(N);
		fibo2(N);
		System.out.println(ans1+" "+ans2);	
	}

	
	private static int fibo2(int n) {
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i=3; i<n; i++) {
			if(dp[n]==0) {
				ans2++;
				dp[n] = fibo2(n-1) + fibo2(n-2);
			}
		}
		return dp[n];
	}


	private static int fibo1(int n) {
		if(n <= 2) {
			return 1;
		}
		ans1++;
		return fibo1(n-1) + fibo1(n-2);
	}
}