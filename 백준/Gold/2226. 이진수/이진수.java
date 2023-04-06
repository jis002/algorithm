import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		BigInteger[] dp = new BigInteger[N+2];
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("0");
		
		for(int i=2; i<N+1; i++) {
			if(i%2==0) {
				dp[i] = dp[i-1].multiply(new BigInteger("2")).add(BigInteger.ONE);
			} else {
				dp[i] = dp[i-1].multiply(new BigInteger("2")).subtract(BigInteger.ONE);
			}
		}
		System.out.println(dp[N]);
	}


}