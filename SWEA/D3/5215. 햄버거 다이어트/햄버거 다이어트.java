import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());  // 재료의 수
			int L = Integer.parseInt(st.nextToken());  // 제한 칼로리
			
			int[] scores = new int[N+1];
			int[] kcal = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken()); // 재료 점수
				kcal[i] = Integer.parseInt(st.nextToken()); // 재료 칼로리
			}
			
			int[][] dp = new int[N+1][L+1];
			for(int i=1; i<N+1; i++) {	//i:아이템
				for(int j=1; j<L+1; j++) { //j:임시 제한 칼로리
					// 아이템 칼로리가 제한 칼로리를 초과할 때는, 해당 아이템을 포함할 수 없다
					if(kcal[i] > j) {
						dp[i][j] = dp[i-1][j];
					} else {
						// 아이템을 선택하지 않거나 선택하는 것 중에 최적해를 구한다
						dp[i][j] = Math.max(dp[i-1][j], scores[i]+dp[i-1][j-kcal[i]]);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, dp[N][L]);
		} //tc	
	}
}