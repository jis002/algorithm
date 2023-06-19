import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	
	static int N;
	static char[][] map;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int ans1;	//적록색약 아님
	static int ans2;	//적록색약
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited1[r][c]) {
					bfs1(r, c);					
				}
				if(!visited2[r][c]) {
					bfs2(r, c);
				}
			}
		}
		
		System.out.println(ans1+" "+ans2);
		
	}

	private static void bfs1(int r, int c) { 
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		visited1[r][c] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0; d<4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(isInMap(nr, nc) && !visited1[nr][nc]) {
					if(map[nr][nc] == map[curr[0]][curr[1]]) {
						cnt++;
						visited1[nr][nc] = true;
						q.add(new int[] {nr, nc});
					}
				}
			}
		}
		ans1++;
	}
	
	
	private static void bfs2(int r, int c) { 
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		visited2[r][c] = true;
		int cnt = 1;
		
		boolean isBlue = true;
		if(map[r][c] == 'B') {
			isBlue = true;
		} else {
			isBlue = false;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();			
			for(int d=0; d<4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(isInMap(nr, nc) && !visited2[nr][nc]) {
					if(isBlue) {
						if(map[nr][nc] == 'B') {
							cnt++;
							visited2[nr][nc] = true;
							q.add(new int[] {nr, nc});
						}
					} else {
						if(map[nr][nc] != 'B') {
							cnt++;
							visited2[nr][nc] = true;
							q.add(new int[] {nr, nc});
						}
					}
				}
			}
		}
		ans2++;
	}


	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<N;
	}
}