import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[] visited;
	static int[] itemsA;
	static int[] itemsB;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = N/2;
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}	
			}
			
			visited = new boolean[N];
			itemsA = new int[M];
			itemsB = new int[M];
			
			ans = Integer.MAX_VALUE;
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			combination(0, 0, 0);
			
			sb.append(ans);
			System.out.println(sb.toString());
		}
	}

	
	private static void combination(int idx, int aidx, int bidx) {
		if(aidx==M || bidx==M) {
			if(aidx==M) {
				for(; idx<N; idx++) {
					itemsB[bidx++] = idx;
				}
			} else {
				for(; idx<N; idx++) {
					itemsA[aidx++] = idx;
				}
			}
			ans = Math.min(ans, getDiffer());
			return;
		}
		
		if(idx==N) {
			return;
		}
		
		// A아이템 선택
		itemsA[aidx] = idx;
		combination(idx+1, aidx+1, bidx);
		itemsB[bidx] = idx;
		combination(idx+1, aidx, bidx+1);
		
	}


	private static int getDiffer() {
		// A아이템, B아이템에서 각 2개씩 선택하는 조합
		int synergyA = 0;
		int synergyB = 0;
		for(int i=0; i<M-1; i++) {
			for(int j=i+1; j<M; j++) {
				synergyA += map[itemsA[i]][itemsA[j]];
				synergyA += map[itemsA[j]][itemsA[i]];
				synergyB += map[itemsB[i]][itemsB[j]];
				synergyB += map[itemsB[j]][itemsB[i]];
			}
		}
		return Math.abs(synergyA-synergyB);
	}
}