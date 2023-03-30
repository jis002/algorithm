import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int M;
	
	static boolean[] visited;
	static int[] dist;
	static List<Node>[] list;
	
	static int ans;
	
	static class Node implements Comparable<Node>{
		int e;
		int w;
		
		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}	
	}
	
	
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
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e, w));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		visited = new boolean[N+1];
		visited[0] = true;
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		dijkstra(start);
		
		ans = dist[end];
		System.out.println(ans);
	}

	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			
			Node curr = pq.poll();
			
			if(visited[curr.e]) continue;
			visited[curr.e] = true;
			
			for(Node next : list[curr.e]) {
				if(!visited[next.e]) {
					dist[next.e] = Math.min(dist[next.e], curr.w + next.w);
					pq.add(new Node(next.e, dist[next.e]));
				}
			}			
		}

	}
	
}