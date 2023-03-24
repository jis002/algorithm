import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int D;	// 행 개수
	static int W;	// 열 개수
	static int[][] film;
	static int[][] copy;	// 필름 원본 상태를 보관
	static int K;	// 합격 기준. 연속해야 할 속성 개수
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			copy = new int[D][W];
			
			for(int r=0; r<D; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<W; c++) {
					film[r][c] = copy[r][c] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			ans = K;
			
			dfs(0, 0);				
			sb.append(ans);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
	}

	
	
	// idx : 탐색중인 행
	// count : 몇번 투약했는 지
	private static void dfs(int idx, int count) {
	// 기저 조건
		if(count >= ans) return;
		
		if(idx==D) {
			if(satisfied()) {
				ans = Math.min(ans, count);
//				System.out.println("a "+Arrays.deepToString(film)+" "+count);
			}
			return;
		}
		
	// 재귀 조건
		// 투약 안함
		dfs(idx+1, count);
		
		// A 투약
		for(int c=0; c<W; c++) {
			film[idx][c] = 0;
		}
		dfs(idx+1, count+1);
		
		// B 투약
		for(int c=0; c<W; c++) {
			film[idx][c] = 1;
		}
		dfs(idx+1, count+1);
		
		// 배열 원복
		for(int c=0; c<W; c++) {
			film[idx][c] = copy[idx][c];
		}
	}


	private static boolean satisfied() {
		boolean flag = false;
		for(int c=0; c<W; c++) {
			flag = false;
			int cnt = 1;
			for(int r=0; r<D-1; r++) {
				if(film[r][c]==film[r+1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if(cnt==K) {
					flag = true;
					break;
				}
				if(cnt!=K) {
					flag = false;
				}
			}
			if(flag==false) break;
		}
		return flag;
	}

}