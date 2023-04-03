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

public class Solution {

	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int[][] copy;
	static boolean[] visited; // 해당 열에 남은 벽돌이 없으면 true
	static int[] sel; // 중복 순열에서 선택한 열
	static int min;
	
	static int[] dh = {0, 1, 0, -1};
	static int[] dw = {1, 0, -1, 0};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			copy = new int[H][W];
			visited = new boolean[W];
			sel = new int[N];
			
			for(int h=0; h<H; h++) {
				st = new StringTokenizer(br.readLine());
				for(int w=0; w<W; w++) {
					map[h][w] = copy[h][w] = Integer.parseInt(st.nextToken());
				}
			}
			
			findVisited();

			min = Integer.MAX_VALUE;	
			combi(0);
			
			sb.append(min);
			System.out.println(sb.toString());
		}
	}


	private static void combi(int idx) {
		if(idx == N) {
			// 탐색 시작
			start(sel);
			int cnt = count();
			min = Math.min(min, cnt);
			// 맵 원복하기
			copyMap();
			return;
		}
				
		// 중복 포함한 순열 구하기
		for(int w=0; w<W; w++) {
			if(visited[w]) continue;
			sel[idx] = w;
			combi(idx+1);
		}
	}
	
	
	private static void start(int[] sel) {
		int h = 0;
		int w = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<H; j++) {
				if(map[j][sel[i]]!=0) {
					h = j;
					w = sel[i];
					break;
				}
			}
			// 공격지점 : map[x][y]
			int power = map[h][w]; // 공격 범위
			bfs(h, w, power); // 블록 파괴
			blockDown(); // 블록 내리기
		}
	}


	private static void bfs(int h, int w, int power) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {h, w, power});
		map[h][w] = 0;
		
		while(!q.isEmpty()) {	
			int[] curr = q.poll();
			h = curr[0];
			w = curr[1];
			power = curr[2];
			
			for(int p=1; p<power; p++) {
				for(int d=0; d<4; d++) {
					int nh = h + dh[d]*p;
					int nw = w + dw[d]*p;
				
					if(isInMap(nh, nw) && map[nh][nw]!=0) {
						int nPower = map[nh][nw];
						q.add(new int[] {nh, nw, nPower});
						map[nh][nw] = 0;
					}
				}
			}
		}
	}
	
	
	private static void blockDown() {
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<W; i++) {
			for(int j=0; j<H; j++) {
				if(map[j][i]!=0) {
					s.add(map[j][i]);
				}
			}
			for(int j=H-1; j>=0; j--) {
				if(!s.isEmpty()) {
					map[j][i] = s.pop();
				} else {
					map[j][i] = 0;
				}
			}
		}
	}


	
	private static boolean isInMap(int nh, int nw) {
		return 0<=nh && 0<=nw && nh<H && nw<W;
	}



	// 남은 벽돌 개수 구하기
	private static int count() {
		int cnt = 0; 
		for(int h=0; h<H; h++) {
			for(int w=0; w<W; w++) {
				if(map[h][w] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	
	// 맵 원복
	private static void copyMap() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}
	
	
	// 모든 벽돌을 제거한 열이 있는 지 확인. 있으면 visited[열] = true 로 변경
	private static void findVisited() {
		boolean flag = true;
		for(int w=0; w<W; w++) {
			if(visited[w]) continue;
			for(int h=0; h<H; h++) {
				if(map[h][w]!=0) {
					flag = false;
					break; 
				}
			}
			if(flag) {
				visited[w] = true;
			}
		}
	}
}