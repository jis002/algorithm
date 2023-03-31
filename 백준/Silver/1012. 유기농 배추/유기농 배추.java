import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int cnt;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			 
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			cnt = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c]==1) {
						map[r][c] = 0;
						dfs(r, c);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}

	private static void dfs(int r, int c) {
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(isInMap(nr, nc) && map[nr][nc]==1) {
				map[nr][nc] = 0;
				dfs(nr, nc);
			}
		}
	}



	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<M;
	}

}