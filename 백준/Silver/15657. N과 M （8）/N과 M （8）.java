import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] sel;
	static StringBuilder sb;
	
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
		sb = new StringBuilder();
		
		sel = new int[M];
		
		select(0);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
	}

	private static void select(int sidx) {
		if(sidx==M) {
			for(int i : sel) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(sidx==0) {
				sel[sidx] = arr[i];
				select(sidx+1);
			} else if(sidx!=0) {
				if(arr[i]>=sel[sidx-1]) {
					sel[sidx] = arr[i];
					select(sidx+1);
				}
			}
			
		}
	}
}