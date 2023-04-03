import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;	// 체스판 한 변의 길이
	static int[][] map;
	static boolean[][] visited; // 나이트가 방문한 적 있는 위치
	
	// 나이트 이동 가능한 장소 델타 배열
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			// 나이트 현위치
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			// 나이트 목적지
			st = new StringTokenizer(br.readLine());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			min = Integer.MAX_VALUE;
			bfs(sr, sc, er, ec);
			
			System.out.println(min);
		}

	}


	private static void bfs(int sr, int sc, int er, int ec) {
		Queue<int[]> q = new LinkedList<>();
		
		int depth = 0;
		q.add(new int[] {sr, sc, 0});
		visited[sr][sc] = true;
		int size = q.size();
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			--size;
			
			if(r==er && c==ec) {
				break;
			}
			
			for(int d=0; d<8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(isInMap(nr, nc) && !visited[nr][nc]) {
					q.add(new int[] {nr, nc, depth});
					visited[nr][nc] = true;
				}
			}
			
			if(size==0) {
				++depth;
				size = q.size();
			}
		}		
		min = Math.min(min, depth);
	}

    
	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<N;
	}

}