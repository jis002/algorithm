import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] sel;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		sel = new int[M];
		visited = new boolean[N];
		
		permutation(0, N, M, arr);
		
	}

	private static void permutation(int idx, int n, int m, int[] arr) {
		if(idx==m) {
			StringBuilder sb = new StringBuilder();
			for(int i : sel) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			sel[idx] = arr[i];
			visited[i] = true;
			permutation(idx+1, n, m, arr);
			visited[i] = false;
		}
	}
}