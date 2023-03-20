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
	static int[][] map;
	
	// 4방 탐색용 델타 배열
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int cnt = 0;
	static List<int[]> list = new ArrayList<int[]>(); // 초기에 익은 사과가 있는 좌표를 담는 리스트
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로 칸 수
		N = Integer.parseInt(st.nextToken()); // 세로 칸 수
		map = new int[N][M];
		
		int firstCnt = 0;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==0) {
					firstCnt++;
				} else if(map[r][c]==1) {
					list.add(new int[] {r, c});
				}
			}
		}

		int result = -1;

		// 처음에 안 익은 토마토가 없다면 0 출력
		if(firstCnt == 0) {
			result = 0;
			
		// 처음에 안 익은 토마토가 있다면	
		} else {
			result = bfs2();
			
			if(!hasNoZero(map)) {
				result = -1;
			} 
		}

		System.out.println(result);
		
	}


	private static int bfs2() {
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int[] curr : list) {
			q.add(curr);
		}
		
		int size = q.size();
		
		while(!q.isEmpty()) {

			int[] first = q.poll();
			int r = first[0];
			int c = first[1];
			size--;
			
			// 4방 탐색하여 0인 곳을 1로 변경
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d]; 
				
				if(isInMap(nr, nc)) {
					if(map[nr][nc] == 0) {
						map[nr][nc] = 1;
						q.add(new int[] {nr, nc});
					}
				}
			}
			
			if(size==0) {
				cnt++;
				size = q.size();
			}

		}
		return cnt-1;
	}

	
	// map에 0이 없으면 true, 0이 있으면 false를 반환
	private static boolean hasNoZero(int[][] map) {
		boolean flag = true;
		outer: for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) {
					flag = false;
					break outer;
				}
			}
		}
		return flag;
	}

	// 델타 배열로 사방 탐색 시 맵 범위를 벗어나지 않는 지 체크하는 메서드
	private static boolean isInMap(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<M;
	}

}