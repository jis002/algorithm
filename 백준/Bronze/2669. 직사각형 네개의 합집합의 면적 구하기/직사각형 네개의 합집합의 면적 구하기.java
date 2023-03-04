import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int[][] map = new int[101][101];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int r=y1; r<y2; r++) {
				for(int c=x1; c<x2; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j]==1) ans++;
			}
		}
		System.out.println(ans);
		
		br.close();
	}

}