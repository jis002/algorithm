/* 궁수가 공격하는 적은 거리가 가장 가까운 적이고,
 * 여럿 있는 경우에는 가장 왼쪽에 있는 적
 * 
 * 1. N개 중 3개를 뽑는 조합 구하기
 * 2. 궁수와 적과의 거리 파악하기
 *  - 다음 범위에서 d값이 최소가 되는 거
 *  - 열 우선 탐색으로 진행
 * 	- 열 범위 : c-D+1열~c+D-1열 , 행 범위 : N-D~N행 
 *  - d값이 현재 최소값과 동일할 때마다 좌표를 저장한다  
 *  - c가 제일 작은 좌표를 구한다
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int D; // 공격 거리 제한
	static int[][] map;
	static int[][] copy; // 원본 보관용
	
	static int cnt;
	static int sum;
	static int ans;
	
	static int[] sel; // 0~2번 궁수의 위치를 담는 조합
	static List<int[]> enemy;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());			
			for(int c=0; c<M; c++) {
				map[r][c] = copy[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		sel = new int[3];
		ans = Integer.MIN_VALUE;
		
		combination(0, 0);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(ans));
		bw.close();
		
	}
	
	

	// idx : 0~N-1
	// sidx : 0~2
	private static void combination(int idx, int sidx) {
		if(sidx == 3) {
			sum = 0;
			findEnemy(0);
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					map[r][c] = copy[r][c];
				}
			}	
			ans = Math.max(ans, sum);
			return;
		}
		
		if(idx == M) {
			return;
		}
		
		sel[sidx] = idx;
		combination(idx+1, sidx+1);
		combination(idx+1, sidx);
	}

	
	// 가장 가까운 적의 좌표 찾기
	private static void findEnemy(int idx) {
		
		if(idx==N) {
			return;
		}
		
		enemy = new ArrayList<>(); // 공격할 적의 좌표를 담는다
		cnt = 0;
		for(int i=0; i<3; i++) {
			// 궁수 i의 행좌표 : N, 열좌표 : sel[i]
			int minD = D;
			int minY = -1;
			int minX = M+1;
			for(int r=N-1; r>N-D-1; r--) {
				for(int c=(sel[i]-D+1); c<(sel[i]+D); c++) {
					if(isInMap(r, c) && map[r][c]==1) {
						int dis = Math.abs(r-N) + Math.abs(c-sel[i]);
						if(minD==dis) {
							if(c<minX) {
								minX = c;
								minY = r;
							}
						} else if(minD>dis) {
							minD = dis;
							minX = c;
							minY = r;
						}
					}
				}
			}
			if(minY != -1) {
				enemy.add(new int[] {minY, minX});
			}
		}
		
		for(int[] arr : enemy) {
			if(map[arr[0]][arr[1]] == 1) {
				map[arr[0]][arr[1]]= 0;
				cnt++;
			}
		}
		sum += cnt;
		
		for(int c=0; c<M; c++) {
			for(int r=N-1; r>0; r--) {
				map[r][c] = map[r-1][c];
			}
			map[0][c] = 0;
		}
		
		findEnemy(idx+1);		
	}
	

	private static boolean isInMap(int r, int c) {
		return 0<=r && 0<=c && r<N && c<M;
	}

}