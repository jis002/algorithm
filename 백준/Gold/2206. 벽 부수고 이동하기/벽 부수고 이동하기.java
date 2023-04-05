import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int min;
	
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0}; 
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		visited = new boolean[N][M][2];
		min = Integer.MAX_VALUE;
		bfs(0, 0);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		if(min==Integer.MAX_VALUE) {
			bw.write("-1");
		} else {
			bw.write(Integer.toString(min));
		}
		bw.close();
		
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		visited[sr][sc][0] = true;
		q.add(new int[] {sr, sc, 0, 1}); // r, c, chance사용함:1,사용안함:0, move
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int chance = curr[2];
			int move = curr[3];
			
			if(r==N-1 && c==M-1) {
				min = Math.min(min, move);
				break;
			}			
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!isInMap(nr,nc) || visited[nr][nc][chance]) continue;

				if(map[nr][nc]!=1) {
					visited[nr][nc][chance] = true;
					q.add(new int[] {nr, nc, chance, move+1});
				} else {
					if(chance==0) {
						visited[nr][nc][chance+1] = true;
						q.add(new int[] {nr, nc, chance+1, move+1}); // 찬스 사용
					}
				}
			}			
		}
	}

	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<M;
	}

}