import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] map;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		max = Integer.MIN_VALUE;
		outer: for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(c<N-1) {
					changeRow(r, c);
				}
				if(r<N-1) {
					changeCol(r, c);
				}
				if(max == N) break outer;
			}
		}
		
		System.out.println(max);
		
	}

	
	
	private static void changeRow(int r, int c) {
		//좌우 바꾸기
		char tmp = map[r][c];
		map[r][c] = map[r][c+1];
		map[r][c+1] = tmp;

		
		//연속된 최대값 구하기
		max = Math.max(max, findMax());
		
		//맵 복구
		tmp = map[r][c];
		map[r][c] = map[r][c+1];
		map[r][c+1] = tmp;
	}

	
	private static void changeCol(int r, int c) {
		//상하 바꾸기
		char tmp = map[r][c];
		map[r][c] = map[r+1][c];
		map[r+1][c] = tmp;
		
		//연속된 최대값 구하기
		max = Math.max(max, findMax());
		
		//맵 복구
		tmp = map[r][c];
		map[r][c] = map[r+1][c];
		map[r+1][c] = tmp;
	}
	
	
	private static int findMax() {
		int res = 0;
		 
		for(int r=0; r<N; r++) {
			int cnt = 1;
			for(int c=1; c<N; c++) {
				if(map[r][c] == map[r][c-1]) {
					cnt++;
				} else {
					cnt = 1;
				}
				res = Math.max(res, cnt);
				if(res==N) return res;
			}
		}
		
		for(int c=0; c<N; c++) {
			int cnt = 1;
			for(int r=1; r<N; r++) {
				if(map[r][c] == map[r-1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}
				res = Math.max(res, cnt);
				if(res==N) return res;
			}
		}
		
		return res;
	}

}