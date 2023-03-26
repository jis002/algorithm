import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int B;
	static int[] heights;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			heights = new int[N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			ans = Integer.MAX_VALUE;
			powerSet(0, 0);
			
			sb.append(ans);
			System.out.println(sb.toString());
			
		}
		
	}

	// sum : 부분집합 원소의 합
	private static void powerSet(int idx, int sum) {
		if(sum >= B) {
			ans = Math.min(ans, sum-B);
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		visited[idx] = true;
		powerSet(idx+1, sum+heights[idx]);
		visited[idx] = false;
		powerSet(idx+1, sum);
	}
}