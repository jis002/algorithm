import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dp0 = new int[41];
	static int[] dp1 = new int[41];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		dp0[0] = 1;
		dp1[1] = 1;
		
		for(int i=2; i<=40; i++) {
			dp0[i] = dp0[i-1] + dp0[i-2];
			dp1[i] = dp1[i-1] + dp1[i-2];			
		}
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.printf("%d %d\n", dp0[N], dp1[N]);
		}
		
	}
}