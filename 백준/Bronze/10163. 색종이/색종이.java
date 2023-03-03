import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[][] map = new int[102][102];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[N+1]; // i번째 색종이 넓이를 담는 배열
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int dr = Integer.parseInt(st.nextToken());
			int dc = Integer.parseInt(st.nextToken());
			
			for(int p=r; p<r+dr; p++) {
				for(int q=c; q<c+dc; q++) {
					map[p][q] = i;
				}
			}
		}
		
		for(int i=1; i<cnt.length; i++) {
			for(int p=0; p<102; p++) {
				for(int q=0; q<102; q++) {
					if(map[p][q] == i) {
						cnt[i]++;
					}
				}
			}
			System.out.println(cnt[i]);
		}

	}

}