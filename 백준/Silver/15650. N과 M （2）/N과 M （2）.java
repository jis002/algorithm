import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] sel;
	static StringBuilder sb; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[M];
		sb = new StringBuilder();
		
		backTrack(1, 0);
		
		System.out.println(sb.toString());
	}

	private static void backTrack(int idx, int sidx) {
		if(sidx == M) {
			Arrays.sort(sel);
			for(int i : sel) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		if(idx == N+1) {
			return;
		}
		
		// 선택한다 
		sel[sidx] = idx;
		backTrack(idx+1, sidx+1);
		// 선택하지 않는다
		backTrack(idx+1, sidx);
		
	}

}