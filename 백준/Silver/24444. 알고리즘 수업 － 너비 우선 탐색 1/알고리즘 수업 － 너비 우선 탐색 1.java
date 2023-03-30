import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
		}
		
		seq = new int[N+1];
		visited = new boolean[N+1];
		visited[R] = true;
		
		bfs(R);
		for(int i=1; i<N+1; i++) {
			System.out.println(seq[i]);
		}
	}

	private static void bfs(int r) {
		Queue<Integer> q = new LinkedList<>();
		q.add(r);
		visited[r] = true;
		seq[r] = ++idx;
		
		while(!q.isEmpty()) {
			int u = q.poll();
			
			for(int v : nodes[u]) {
				if(visited[v]) continue;
				visited[v] = true;
				seq[v] = ++idx;
				q.offer(v);
			}
		}		
		
	}

}