import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int V;
	static int E;
	static List<Integer>[] list;
	static int[] inDegree;
	static boolean[] visited;
	
	static StringBuilder sb;
	
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			for(int i=0; i<V+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			inDegree = new int[V+1];
			visited = new boolean[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int srt = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list[srt].add(end);
				inDegree[end]++;
			}
			
			// 큐로 풀기
//			find1();

			// 스택으로 풀기
			stack = new Stack<>();
			topology2();
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		}
	}


	private static void topology2() {
		for(int i=1; i<V+1; i++) {
			if(inDegree[i] == 0) {
				find2(i);
			}
		}
	}

	// 스택(dfs)으로 풀기
	private static void find2(int v) {
		visited[v] = true;
		for(int next : list[v]) {
			if(!visited[next]) {
				find2(next);
			}
		}
		stack.push(v);
	}

	
	
	// 큐로 풀기
//	private static void find1() {
//		Queue<Integer> q = new LinkedList<>();
//		for(int i=1; i<V+1; i++) {
//			if(inDegree[i]==0) {
//				q.add(i);
//			}
//		}
//		while(!q.isEmpty()) {
//			int curr = q.poll();
//			sb.append(curr).append(" ");
//			visited[curr] = true;
//			for(int next : list[curr]) {
//				if(!visited[next]) {
//					inDegree[next]--;
//					if(inDegree[next] == 0) {
//						q.add(next);
//					}
//				}
//			}
//		}
//	}

}