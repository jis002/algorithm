import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] sel;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		visited = new boolean[N+1];

		backTracking(0);
	}

	private static void backTracking(int idx) {
		if(idx == M) {
			StringBuilder sb = new StringBuilder();
			for(int i : sel) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		for(int i=1; i<N+1; i++) {
			if(visited[i]) continue;
			
			sel[idx] = i;
			visited[i] = true;
			backTracking(idx+1);
			visited[i] = false;
		}
		
	}
}