import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int V;
	static int E;
	static List<Node>[] list;
	static int[] dist; 
	static boolean[] visited;
	
	static int[] ans; // 각 정점의 최단 운동 경로
	
	static class Node {
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "[v=" + v + ", w=" + w + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}
		
		ans = new int[V+1];	
		
		for(int s=1; s<V+1; s++) {
			dist = new int[V+1];
			Arrays.fill(dist, INF);
			visited = new boolean[V+1];
			dijkstra(s);
		}
				
		int min = INF;
		for(int i=1; i<V+1; i++) {
			min = Math.min(min, ans[i]);
		}
		
		if(min == INF) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
	}

	private static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.w - o2.w;
			}
		});
		
		for(Node next : list[s]) {
			dist[next.v] = next.w;
			pq.add(new Node(next.v, dist[next.v]));
		}
				
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(!visited[curr.v]) {
				visited[curr.v] = true;
				for(Node next : list[curr.v]) {
					if(dist[next.v] > curr.w + next.w) {
						dist[next.v] = curr.w + next.w;
					}
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
			
			if(visited[s]) break;
		}
		ans[s] = dist[s];
	}
}