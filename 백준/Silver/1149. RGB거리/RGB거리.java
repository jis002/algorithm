import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<=N; i++) {
			map[i][0] = Math.min(map[i-1][1]+map[i][0], map[i-1][2]+map[i][0]);
			map[i][1] = Math.min(map[i-1][0]+map[i][1], map[i-1][2]+map[i][1]);
			map[i][2] = Math.min(map[i-1][0]+map[i][2], map[i-1][1]+map[i][2]);
		}
		int ans = Math.min(map[N][0], Math.min(map[N][1], map[N][2]));		
		
		System.out.println(ans);
	}

}