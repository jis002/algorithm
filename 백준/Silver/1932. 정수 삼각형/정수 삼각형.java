import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static Integer[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new Integer[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				if(st.hasMoreTokens()) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int j=0; j<N; j++) {
			dp[N-1][j] = map[N-1][j];
		}
		
		int ans = memo(0, 0);
		System.out.println(ans);
		br.close();
	}

	private static int memo(int r, int c) {
		if(r==N-1) return dp[r][c];
		
		if(dp[r][c]==null) {
			dp[r][c] = map[r][c] + Math.max(memo(r+1, c), memo(r+1, c+1));
		}

		return dp[r][c];
	}
	
}