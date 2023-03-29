import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	static int H;
	static int[][][] map;

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] dh = {-1, 1};
	
	static int days = 0;
	static List<int[]> list = new ArrayList<int[]>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이
		
		map = new int[H][N][M];
		
		boolean allRipe = true; // 토마토가 모두 익었으면 true, 안 익은 토마토가 하나라도 있으면 false
		for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[h][r][c] = Integer.parseInt(st.nextToken());
					if(map[h][r][c]==0) {	
						allRipe=false;
					} else if(map[h][r][c]==1) { 
						// 익은 토마토의 좌표를 list에 담는다
						list.add(new int[] {h, r, c});
					}
				}
			}
		}

		int result = -1;

		// 초기에 안 익은 토마토가 없다면 0 출력
		if(allRipe) {
			result = 0;
			
		// 초기에 안 익은 토마토가 있다면	
		} else {
			result = bfs();
			
			// 안 익은 토마토가 남아 있으면 -1 출력
			if(!hasNoZero(map)) {
				result = -1;
			} 
		}

		System.out.println(result);
	}

	
	
	private static int bfs() {
		
		// 초기에 익어있는 토마토를 큐에 담는다
		Queue<int[]> q = new LinkedList<int[]>();
		for(int[] curr : list) {
			q.add(curr);
		}
		
		// size : 하루 동안 탐색 할 토마토의 개수를 의미
		// size가 0이 되면 하루가 경과한 것임
		int size = q.size();
		
		while(!q.isEmpty()) {

			int[] first = q.poll();
			int h = first[0];
			int r = first[1];
			int c = first[2];
			size--;	// 토마토를 하나 뺄 때마다 size도 1씩 감소시킴
			
			// 4방 탐색하여 0인 곳을 1로 변경 후 큐에 추가
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d]; 
				
				if(isInMap(nr, nc)) {
					if(map[h][nr][nc] == 0) {
						map[h][nr][nc] = 1;
						q.add(new int[] {h, nr, nc});
					}
				}
			}
			
			// 위 아래 상자 탐색하여 0인 곳을 1로 변경 후 큐에 추가
			for(int d=0; d<2; d++) {
				int nh = h + dh[d];
				
				if(isInMap2(nh)) {
					if(map[nh][r][c] == 0) {
						map[nh][r][c] = 1;
						q.add(new int[] {nh, r, c});
					}
				}
			}
			
			// size가 0이 되면 일수를 +1 하고, size 재측정
			if(size==0) {
				days++;
				size = q.size();
			}

		}
		// 처음에 익어있던 건 제외해야 하므로 -1 
		return days-1;
	}

	
	// map에 0이 없으면 true, 0이 있으면 false를 반환
	private static boolean hasNoZero(int[][][] map) {
		boolean flag = true;
		outer: for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[h][r][c] == 0) {
						flag = false;
						break outer;
					}
				}
			}
		}
		return flag;
	}

	
	// 델타 배열로 사방 탐색 시 맵 범위를 벗어나지 않는 지 체크하는 메서드
	private static boolean isInMap(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<M;
	}
	
	// 위아래 상자 탐색용
	private static boolean isInMap2(int h) {
		return 0<=h && h<H;
	}

}