// 재귀로 풀기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int w; // 너비
	static int h; // 높이
	static int[][] map;
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int cnt = 0; // 섬의 개수

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); 
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break; // 0 0 이 입력되면 종료
			
			map = new int[h][w];
			
			for(int r=0; r<h; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 각 위치마다 연결되는 섬이 있는 지 확인
			cnt = 0;
			for(int r=0; r<h; r++) {
				for(int c=0; c<w; c++) {
					if(map[r][c] == 1) {
						dfs2(r, c);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
		
	}


	private static void dfs2(int r, int c) {

		map[r][c] = 0;
		
		for(int d=0; d<8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(0>nr || 0>nc || nr>=h || nc>=w) {
				continue;
			}
			if(map[nr][nc] == 1) {
				map[nr][nc] = 0;
				dfs2(nr, nc);
			}	
		}
		return;
	
	}
}