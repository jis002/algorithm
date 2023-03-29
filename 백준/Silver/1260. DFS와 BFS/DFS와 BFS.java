import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int start;
	static int[][] graph;
	
	static boolean[] visited;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		graph = new int[1001][1001];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		
		sb = new StringBuilder();
		
		visited = new boolean[1001];	
		dfs(start);
		sb.setLength(sb.length()-1);
		sb.append("\n");
		
		visited = new boolean[1001];
		bfs();
		sb.setLength(sb.length()-1);
		
		System.out.println(sb.toString());
		
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visited[start] = true;
		sb.append(start).append(" ");
				
		while(!q.isEmpty()) {
			int v = q.poll();
		
			for(int i=0; i<N+1; i++) {
				if(!visited[i] && graph[v][i]==1) {
					q.add(i);
					visited[i] = true;
					sb.append(i).append(" ");
				}
			}
		}	
	}

	
	private static void dfs(int v) {		
		visited[v] = true;
		sb.append(v).append(" ");
		
		for(int i=0; i<N+1; i++) {
			if(!visited[i] && graph[v][i]==1) {
				dfs(i);
			}
		}
	}

}