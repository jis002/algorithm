import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K, W, H;
	static int[][] map;
	static int min;
	
	static boolean[][][] visited; // r, c, cnt
	
	// 말 움직임
	static int[] dr1 = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc1 = {1, 2, 2, 1, -1, -2, -2, -1};
	
	// 원숭이 움직임. 상하좌우
	static int[] dr2 = {-1, 1, 0, 0}; 
	static int[] dc2 = {0, 0, -1, 1}; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		for(int r=0; r<H; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[H][W][K+1];
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

	
	
	// cnt : 말처럼 움직인 횟수
	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		visited[sr][sc][0] = true;
		q.add(new int[] {sr, sc, 0, 0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int cnt = curr[2];
			int move = curr[3];
			
			// 종착지에 도착
			if(r==H-1 && c==W-1) {
				min = Math.min(min, move);
			}
			
			// 원숭이처럼 움직임
			for(int d=0; d<4; d++) {
				int nr = r + dr2[d];
				int nc = c + dc2[d];
				if(isInMap(nr, nc) && !visited[nr][nc][cnt]) {
					if(map[nr][nc]!=1) {
						visited[nr][nc][cnt] = true;
						q.add(new int[] {nr, nc, cnt, move+1});
					}
				}
			}
			
			// 말처럼 움직임
			if(cnt<K) {
				for(int d=0; d<8; d++) {
					int nr = r + dr1[d];
					int nc = c + dc1[d];
					if(isInMap(nr, nc) && !visited[nr][nc][cnt+1]) {
						if(map[nr][nc]!=1) {
							visited[nr][nc][cnt+1] = true;
							q.add(new int[] {nr, nc, cnt+1, move+1});
						}
					}
				}
			}
		}
		
	}

	
	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<H && nc<W;
	}

}