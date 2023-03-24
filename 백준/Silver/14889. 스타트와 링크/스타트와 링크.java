import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;	// 전체 인원
	static int M;	// 한 팀의 인원
	static int[][] map; // 시너지 맵
	static boolean[] visited;	// true면 A팀, false면 B팀
	static int[] teamA;
	static int[] teamB;
	static int differ;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = N/2;
		visited = new boolean[N];
		teamA = new int[M];
		teamB = new int[M];
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;

		selectTeam(0, 0);
		System.out.println(min);
	}

	private static void selectTeam(int idx, int sidx) {
		if(sidx==M) {
			int a = 0;
			int b = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]==true) {
					teamA[a++] = i+1;
				} else {
					teamB[b++] = i+1;
				}
			}
			getDiffer();
			return;
		}
		
		if(idx==N) return;
		
		visited[idx] = true;
		selectTeam(idx+1, sidx+1);
		visited[idx] = false;
		selectTeam(idx+1, sidx);
	}
	
	private static void getDiffer() {
		int synergyA = 0;
		int synergyB = 0;
		differ = 0;
		for(int i=0; i<M-1; i++) {
			for(int j=i+1; j<M; j++) {
				if(i!=j) {
					int a1 = teamA[i]-1;
					int a2 = teamA[j]-1;
					int b1 = teamB[i]-1;
					int b2 = teamB[j]-1;
					synergyA = synergyA + map[a1][a2] + map[a2][a1];
					synergyB = synergyB + map[b1][b2] + map[b2][b1];
					differ = Math.abs(synergyA-synergyB);
				}
			}
		}
		min = Math.min(min, differ);		
	}

}