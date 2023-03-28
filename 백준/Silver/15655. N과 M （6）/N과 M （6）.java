import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] sel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		sel = new int[M];
		
		combination(0, 0);
		
	}

	private static void combination(int idx, int sidx) {
		if(sidx==M) {
			StringBuilder sb = new StringBuilder();
			for(int i : sel) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
			return;
		}
		
		if(idx==N) {
			return;
		}
		
		sel[sidx] = arr[idx];
		combination(idx+1, sidx+1);
		combination(idx+1, sidx);
		
	}
}