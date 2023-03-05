import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		
		int K = Integer.parseInt(br.readLine());		
		
		int cnt = 1;
		int r = R-1; // 행 좌표
		int c = 0; // 열 좌표
		
		map[r][c] = cnt++;
		
		if(K!=1 && K<=R*C) {
			outer: while(true) {

				while( 0<r && map[r-1][c]==0 ) {
					r--;
					map[r][c] = cnt++;
					if(cnt==K+1) break outer;
				}
				
				while( c+1<C && map[r][c+1]==0 ) {
					c++;
					map[r][c] = cnt++;
					if(cnt==K+1) break outer;
				}
				
				while( r+1<R && map[r+1][c]==0 ) {
					r++;
					map[r][c] = cnt++;
					if(cnt==K+1) break outer;
				}
				
				while( 0<c && map[r][c-1]==0 ) {
					c--;
					map[r][c] = cnt++;
					if(cnt==K+1) break outer;
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		if(K<=R*C) {
			StringBuilder sb = new StringBuilder();
			sb.append(c+1).append(" ").append(R-r);
			bw.write(sb.toString());
			bw.flush();
		} else {
			bw.write("0");
			bw.flush();
		}
		bw.close();
		br.close();
	}

}