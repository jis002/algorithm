import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] dp = new int[1002];
	static int ans = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n==1) {
			ans = 1;
		} else {
			dp[1] = 1;
			for(int i=2; i<=n; i++) {
				if(i%2!=0) {
					dp[i] = (dp[i-1]*2 - 1)%10007;
				} else {
					dp[i] = (dp[i-1]*2 + 1)%10007;
				}
			}
			ans = dp[n];
		}
		System.out.println(ans);
	}
}