import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=M; c++) {
				map[r][c] += Math.max(map[r-1][c], Math.max(map[r][c-1], map[r-1][c-1]));
			}
		}
		System.out.println(map[N][M]);
	}

}