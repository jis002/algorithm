import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static List<Integer> list;
	static boolean[][] visited;
	static int cnt;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		 
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		list = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]==1) {
					cnt = 0;
					cnt = bfs(r, c);
					list.add(cnt);
				}
			}
		}
		list.sort(null);
		System.out.println(list.size());
		for(int i : list) {
			System.out.println(i);
		}
		
	}

	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		map[r][c] = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			r = curr[0];
			c = curr[1];
			cnt++;
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(isInMap(nr, nc) && map[nr][nc]==1) {
					q.add(new int[] {nr, nc});
					map[nr][nc] = 0;
				}
			}
		}
		return cnt;
	}

	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<N;
	}

}