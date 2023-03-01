import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[] rowCnt = new int[5]; // 1,2,...,5행에 호출된 수 카운트
	public static int[] colCnt = new int[5]; // 1,2,...,5열에 호출된 수 카운트
	public static int[] diaCnt = new int[2]; // 좌하향, 우상향 대각선 라인에서 호출된 수 카운트
	
	
	public static void main(String[] args) throws IOException {
		
		int[][] map = new int[5][5];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				String input = st.nextToken();
				if(input != null && !input.isEmpty()) {
					map[i][j] = Integer.parseInt(input);
				}
			}
		}
			
		Queue<Integer> nums = new LinkedList<Integer>();
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				String input = st.nextToken();
				if(input != null && !input.isEmpty()) {
					nums.add(Integer.parseInt(input));
				}
			}
		}
		
		int bingo = 0; // 빙고 라인 개수
		int count = 0;

		while(bingo<3) {
			count++;
			int num = nums.poll();
			for(int r=0; r<5; r++) {
				for(int c=0; c<5; c++) {
					if(map[r][c] == num) {
						map[r][c] = 0;
						int i = r;
						int j = c;
						// 빙고 개수 카운트
						bingo = checkRow(map, i) + checkCol(map, j) + checkDia(map, i, j);
					}
				}
			}
		}
		System.out.println(count);
		
		br.close();
	}

	
	public static int checkRow(int[][] map, int i) {
		// 해당 행이 아직 모두 불린게 아닐 때에만 rowCnt[i] 새로 계산
		if (rowCnt[i] == 0) {
			int cnt = 0;
			for(int c=0; c<5; c++) {
				if(map[i][c] == 0) {
					cnt++;
				}
			}
			if(cnt==5) {
				rowCnt[i] = 1;
			}
		} 

		int sum = 0;
		for(int c : rowCnt) {
			sum += c;
		}
		return sum;
	}
	
	
	public static int checkCol(int[][] map, int j) {
		// 해당 열이 아직 모두 불린게 아닐 때에만 colCnt[j] 새로 계산
		if (colCnt[j] == 0) {
			int cnt = 0;
			for(int r=0; r<5; r++) {
				if(map[r][j] == 0) {
					cnt++;
				}
			}
			if(cnt==5) {
				colCnt[j] = 1;
			}
		} 

		int sum = 0;
		for(int c : colCnt) {
			sum += c;
		}
		return sum;
	}
	


	public static int checkDia(int[][] map, int i, int j) {
		// 좌하향, 우상향 대각선이 아직 빙고가 아닐때에만 체크
		if(diaCnt[0]!=1 && diaCnt[1]!=1) {
			// i==j 이거나 i+j==4일때만 새로 계산
			if(i==j) {
				int cnt = 0;
				for(int r=0; r<5; r++) {
					for(int c=0; c<5; c++) {
						if(r==c && map[r][c] == 0) {
							cnt++;
						}
					}
				}
				if(cnt==5) {
					diaCnt[0] = 1;
				}
			}
			
			if(i+j==4) {
				int cnt = 0;
				for(int r=0; r<5; r++) {
					for(int c=0; c<5; c++) {
						if(r+c==4 && map[r][c] == 0) {
							cnt++;
						}
					}
				}
				if(cnt==5) {
					diaCnt[1] = 1;
				}
			}
		}

		int sum = 0;
		for(int c : diaCnt) {
			sum += c;
		}
		return sum;
	}
	
	
}