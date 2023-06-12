import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	static int sumw;	//우리팀
	static int sumb;	//적팀
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visited = new boolean[M][N];
		sumw = 0;
		sumb = 0;
		
		for(int r=0; r<M; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		for(int r=0; r<M; r++) {
			for(int c=0; c<N; c++) {
				if(visited[r][c]) continue;
				if(map[r][c] == 'W') {
					sumw += bfs(r, c, 'W');
				} else {
					sumb += bfs(r, c, 'B');
				}
			}
		}
		
		
		System.out.print(sumw+" "+sumb);
	}

	
	private static int bfs(int r, int c, char team) {
		int power = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			power++;
			for(int d=0; d<4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(!isInMap(nr, nc) || visited[nr][nc]) continue;
				if(map[nr][nc] == team) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		return power*power;
	}
	
	
	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<M && nc<N;
	}

}