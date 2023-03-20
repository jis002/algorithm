import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int result;
	
	// 45도 회전 이동 시 탐색할 델타 배열
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 0: 비어있는 곳, 1: 벽, 2: 현재 파이프 끝 자리
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		
		int curR = 0;
		int curC = 1;
		int direction = 1; // 현재 파이프의 방향. 1:가로, 2:세로, 3:대각선
		dfs(curR, curC, direction);
		System.out.println(result);

	}


	private static void dfs(int r, int c, int direction) {
		
		if(r==N-1 && c==N-1) {
			result++;
			return;
		} else if(direction==1 && c==N-1) {
			return;
		} else if(direction==2 && r==N-1) {
			return;
		}
		
		int nr, nc; // 파이프 끝점의 다음 좌표
		
		if(direction==1) {
			// 가로로 밀기
			nr = r;
			nc = c+1;
			if(isInMap(nr, nc) && map[nr][nc]!=1) {
				dfs(nr, nc, 1);
			}
			// 대각선으로 밀기
			if(canMoveDiag(r, c)) {
				nr = r+1;
				nc = c+1;
				dfs(nr, nc, 3);
			}
			
		} else if(direction==2) {
			// 세로로 밀기
			nr = r+1;
			nc = c;
			if(isInMap(nr, nc) && map[nr][nc]!=1) {
				dfs(nr, nc, 2);
			}
			// 대각선으로 밀기
			if(canMoveDiag(r, c)) {
				nr = r+1;
				nc = c+1;
				dfs(nr, nc, 3);
			}
			
		} else if(direction==3) {
			// 가로로 밀기
			nr = r;
			nc = c+1;
			if(isInMap(nr, nc) && map[nr][nc]!=1) {
				dfs(nr, nc, 1);
			}
			// 세로로 밀기
			nr = r+1;
			nc = c;
			if(isInMap(nr, nc) && map[nr][nc]!=1) {
				dfs(nr, nc, 2);
			}
			// 대각선으로 밀기
			if(canMoveDiag(r, c)) {
				nr = r+1;
				nc = c+1;
				dfs(nr, nc, 3);
			}
		}
		
	}


	private static boolean canMoveDiag(int nr, int nc) {
		for(int d=0; d<3; d++) {
			int i = nr + dr[d];
			int j = nc + dc[d];
			if(!isInMap(i,j) || map[i][j]==1) {
				return false;
			}	
		}
		return true;
	}


	private static boolean isInMap(int nr, int nc) {
		return nr<N && nc<N;
	}


}