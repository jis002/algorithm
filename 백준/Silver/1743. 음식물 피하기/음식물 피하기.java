import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int N;
	static int M;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 1;
		}
		
		max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] || map[i][j]==0) continue;
				max = Math.max(max, bfs(i, j));
			}
		}
		System.out.println(max);
	}
	
	
	static int bfs(int r, int c) {
		int size = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			size++;
			
			for(int d=0; d<4; d++) {
				int nr = x + dr[d];
				int nc = y + dc[d];
				if(isInMap(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		return size;
	}
	
	
	
	static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<M;
	}

}