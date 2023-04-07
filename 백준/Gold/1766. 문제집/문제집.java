import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer>[] list;
	static int[] inDegree; // 노드별 진입차수를 담은 배열 
	static boolean[] visited; // 노드 방문 체크
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		inDegree = new int[N+1]; 
		visited = new boolean[N+1];
		
		// 그래프 정보 입력 받기
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			inDegree[v]++; // 진입 차수를 하나씩 늘려줌
		}

		sb = new StringBuilder();
		
		topologySort();
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());	
	}
	

	private static void topologySort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=1; i<N+1; i++) {
			if(inDegree[i]==0) {
				visited[i] = true;
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int curr = pq.poll();
			sb.append(curr).append(" ");
			
			for(int next : list[curr]) {
				inDegree[next]--;
				if(inDegree[next]==0 && !visited[inDegree[next]]) {
					pq.add(next);
				}
			}
		}
	}

}