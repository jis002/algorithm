import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}		
	}
	
	static final int INF = Integer.MAX_VALUE;

	static int V;
	static int E;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		dist = new int[V+1];
		
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(dist, INF);
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v,w));
		}
		
		dijkstra(start);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<V+1; i++) {
			if(dist[i]==INF) {
				bw.write("INF\n");
			} else {
				bw.write(dist[i]+"\n");
			}
		}
		bw.close();
		
	}
	

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(!visited[curr.v]) {
				visited[curr.v] = true;
	
				for(Node next : list[curr.v]) {
					if(dist[next.v] > (curr.w+next.w) ) {
						dist[next.v] = curr.w+next.w;
						pq.offer(new Node(next.v, dist[next.v]));
					}					
				}
			}
		}		
	}

}