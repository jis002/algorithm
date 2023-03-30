import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[][] dist;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c)-'0';
				dist[r][c] = -1;
			}
		}
	
		bfs(0, 0);
		
		int ans = dist[N-1][M-1];
		System.out.println(ans);
	}


	private static void bfs(int r, int c) {

		Queue<int[]> q = new LinkedList<>();
		
		dist[r][c] = 1;
		q.offer(new int[] {r, c, dist[r][c]});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			r = curr[0];
			c = curr[1];
			int d = curr[2];
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(isInMap(nr, nc) && map[nr][nc]==1 && dist[nr][nc]==-1) {
					dist[nr][nc] = d+1;
					q.offer(new int[] {nr, nc, dist[nr][nc]});
				}
			}
		}		
	}


	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<M;
	}

}