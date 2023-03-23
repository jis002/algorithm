import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		backTrack(0);
		
		System.out.println(sb.toString());
	}

	private static void backTrack(int sidx) {
		if(sidx == M) {
			for(int i : sel) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			sel[sidx] = i;
			backTrack(sidx+1);
		}
		
	}

}