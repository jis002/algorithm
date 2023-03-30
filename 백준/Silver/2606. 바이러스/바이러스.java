import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static List<Integer>[] list;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		visited = new boolean[N+1];
		bfs(1);
		
		System.out.println(ans);
	}

	private static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next : list[curr]) {
				if(visited[next]) continue;
				q.add(next);
				visited[next] = true;
				++ans;
			}
		}
	}

}