import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int w;
	static int h;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	

	public static void main(String[] args) throws IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) break;
			
			map = new int[h][w];

			for(int r=0; r<h; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0; 
			for(int r=0; r<h; r++) {
				for(int c=0; c<w; c++) {
					if(map[r][c] == 1) {
						bfs(r, c);
						cnt++;
					}
				}
			}
			
			bw.write(Integer.toString(cnt));
			bw.newLine();
			bw.flush();
		}
		
		bw.close();
		br.close();
		
	} // main


	private static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row, col});
		
		while(!q.isEmpty()) {
			int[] first = q.poll();
			
			int r = first[0],
				c = first[1];
			
			// 팔방탐색
			for(int d=0; d<8; d++) { 
				int nr = r + dr[d];
				int nc = c + dc[d];
			
				if(isInMap(nr, nc) && map[nr][nc] == 1) {
					q.add(new int[] {nr, nc});
					map[nr][nc] = 0;
				}
			}
		}
	}


	private static boolean isInMap(int nr, int nc) {
		if (nr>=0 && nc>=0 && nr<h && nc<w) {
			return true;
		} 
		return false;
	}
	
	
}