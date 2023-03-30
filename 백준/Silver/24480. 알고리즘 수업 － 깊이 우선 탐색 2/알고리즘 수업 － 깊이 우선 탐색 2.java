import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int idx;
	
	static List<Integer>[] nodes;
	static int[] seq; // 각 정점의 출력 순서
	static boolean[] visited; // 각 정점의 출력 순서
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); // 시작 정점
		
		nodes = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			nodes[u].add(v);
			nodes[v].add(u);
		}
		
		for(int i=0; i<N+1; i++) {
			Collections.sort(nodes[i]);
			Collections.reverse(nodes[i]);
		}
		
		seq = new int[N+1];
		visited = new boolean[N+1];
		visited[R] = true;
		
		DFS(R);
		for(int i=1; i<N+1; i++) {
			System.out.println(seq[i]);
		}
	}

	private static void DFS(int r) {
		seq[r] = ++idx;
		
		for(int next : nodes[r]) {
			if(visited[next]) continue;
			visited[next] = true;
			DFS(next);
		}
	}

}