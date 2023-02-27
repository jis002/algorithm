import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 개수
		int[][] arr = new int[101][101];
		
		int cnt = 0;
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					arr[r+i][c+j] = 1;
				}
			}
		}

		// 4방 탐색용 델타배열
		int[] dr = {-1,	1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(arr[i][j]==1) {
					for(int d=0; d<dr.length; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];	
						// 사방 중 하나라도 0이면
						if(nr<0 || nc<0 || 101<=nr && 101<=nc)
							continue;	
						if(arr[nr][nc] == 0) {
							cnt++;
						}
					}
				}	
			}
		}
		System.out.println(cnt);
			
	}

}