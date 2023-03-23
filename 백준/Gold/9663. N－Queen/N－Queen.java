import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N;
	static int[][] map;
	static int cnt; // 체스판 위에 둔 퀸의 갯수
	static int ans; // 경우의 수
	
	// 대각선 탐색용 델타 배열
	static int[] dr = {-1, -1};
	static int[] dc = {1, -1};
	
	// 열 visited 배열
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt = 0;
		ans = 0;
		visited = new boolean[N]; 
		
		findQueen(0);
		System.out.println(ans);
	}


	private static void findQueen(int r) {
		if(cnt == N) {
			ans++;
			return;
		}
		if(r==N) {
			return;
		}
		
		for(int c=0; c<N; c++) {
			boolean flag = true;
			
			if(visited[c]==true) continue;
			
			outer: for(int d=0; d<dr.length; d++) {
				for(int s=1; s<r+1; s++) {
					int nr = r + dr[d]*s;
					int nc = c + dc[d]*s;
					if(isInMap(nr, nc)) {
						if(map[nr][nc]==1) {
							flag = false;
							break outer;
						}
					}
				}
			}
			if(flag) {
				map[r][c] = 1;
				cnt++;
				visited[c] = true;
				findQueen(r+1);
				map[r][c] = 0;
				cnt--;
				visited[c] = false;
			}
			if(c==N-1) {
				return;
			}
		}
	}
	
	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<N;
	}

}