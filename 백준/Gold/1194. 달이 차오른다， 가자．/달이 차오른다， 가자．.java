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
	static char[][] map;
	static boolean[][][][][][][][] visited; // r, c, a~f
	
	// 아스키코드로  A~F=17~22, a~f=49~54
	
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0}; 
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][2][2][2][2][2][2];  
		
		int sr = -1;
		int sc = -1;
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c]=='0') {
					sr = r;
					sc = c;
				}
			}
		}
		
		
		int move = bfs(sr, sc); // 행좌표, 열좌표
		
		System.out.println(move);
	
	}
	
	
	private static int bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		visited[sr][sc][0][0][0][0][0][0] = true;
		q.add(new int[] {sr, sc, 0, 0, 0, 0, 0, 0, 1}); // 행, 열, a~f, move카운트
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int R = curr[0];
			int C = curr[1];
			int a = curr[2];
			int b = curr[3];
			int c = curr[4];
			int d = curr[5];
			int e = curr[6];
			int f = curr[7];
			int move = curr[8];
						
			for(int D=0; D<4; D++) {
				int nr = R + dr[D];
				int nc = C + dc[D];
				
				if(!isInMap(nr, nc)) continue;
								
				switch (map[nr][nc]) {
				case '1': // 출구 도착
					return move;
					
				case '.':
				case '0':
					if(!visited[nr][nc][a][b][c][d][e][f]) {
						visited[nr][nc][a][b][c][d][e][f] = true;
						q.add(new int[] {nr, nc, a, b, c, d, e, f, move+1});
					}
					break;
					
				case 'a':
					if(a==0) {
						if(!visited[nr][nc][a+1][b][c][d][e][f]) {
							visited[nr][nc][a+1][b][c][d][e][f] = true;
							q.add(new int[] {nr, nc, a+1, b, c, d, e, f, move+1});
						}
					} else if(a==1){
						if(!visited[nr][nc][a][b][c][d][e][f]) {
							visited[nr][nc][a][b][c][d][e][f] = true;
							q.add(new int[] {nr, nc, a, b, c, d, e, f, move+1});
						}
					}
					break;
				case 'b':
					if(b==0) {
						if(!visited[nr][nc][a][b+1][c][d][e][f]) {
							visited[nr][nc][a][b+1][c][d][e][f] = true;
							q.add(new int[] {nr, nc, a, b+1, c, d, e, f, move+1});
						}
					} else if(b==1){
						if(!visited[nr][nc][a][b][c][d][e][f]) {
							visited[nr][nc][a][b][c][d][e][f] = true;
							q.add(new int[] {nr, nc, a, b, c, d, e, f, move+1});
						}
					}
					break;
				case 'c':
					if(c==0) {
						if(!visited[nr][nc][a][b][c+1][d][e][f]) {
							visited[nr][nc][a][b][c+1][d][e][f] = true;
							q.add(new int[] {nr, nc, a, b, c+1, d, e, f, move+1});
						}
					} else if(c==1){
						if(!visited[nr][nc][a][b][c][d][e][f]) {
							visited[nr][nc][a][b][c][d][e][f] = true;
							q.add(new int[] {nr, nc, a, b, c, d, e, f, move+1});
						}
					}
					break;
				case 'd':
					if(d==0) {
						if(!visited[nr][nc][a][b][c][d+1][e][f]) {
							visited[nr][nc][a][b][c][d+1][e][f] = true;
							q.add(new int[] {nr, nc, a, b, c, d+1, e, f, move+1});
						}
					} else if(d==1){
						if(!visited[nr][nc][a][b][c][d][e][f]) {
							visited[nr][nc][a][b][c][d][e][f] = true;
							q.add(new int[] {nr, nc, a, b, c, d, e, f, move+1});
						}
					}
					break;
				case 'e': 
					if(e==0) {
						if(!visited[nr][nc][a][b][c][d][e+1][f]) {
							visited[nr][nc][a][b][c][d][e+1][f] = true;
							q.add(new int[] {nr, nc, a, b, c, d, e+1, f, move+1});
						}
					} else if(e==1){
						if(!visited[nr][nc][a][b][c][d][e][f]) {
							visited[nr][nc][a][b][c][d][e][f] = true;
							q.add(new int[] {nr, nc, a, b, c, d, e, f, move+1});
						}
					}
					break;
				case 'f':
					if(f==0) {
						if(!visited[nr][nc][a][b][c][d][e][f+1]) {
							visited[nr][nc][a][b][c][d][e][f+1] = true;
							q.add(new int[] {nr, nc, a, b, c, d, e, f+1, move+1});
						}
					} else if(f==1){
						if(!visited[nr][nc][a][b][c][d][e][f]) {
							visited[nr][nc][a][b][c][d][e][f] = true;
							q.add(new int[] {nr, nc, a, b, c, d, e, f, move+1});
						}
					}
					break;
					
				case 'A':
				case 'B': 
				case 'C': 
				case 'D': 
				case 'E': 
				case 'F': 
					if(curr[(map[nr][nc]-'0')-15]==1) {
						if(!visited[nr][nc][a][b][c][d][e][f]) {
							visited[nr][nc][a][b][c][d][e][f] = true;
							q.add(new int[] {nr, nc, a, b, c, d, e, f, move+1});
						}
					}
					break;
				}
			}
		}
		return -1;
	}


	private static boolean isInMap(int nr, int nc) {
		return 0<=nr && 0<=nc && nr<N && nc<M;
	}

}