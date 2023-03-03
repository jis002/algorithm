import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int max = Integer.MIN_VALUE; // 온도합 최대값
		
		for(int i=0; i<N-K+1; i++) {
			int sum = arr[i];
			for(int j=1; j<K; j++) {
				int val = i+j;
				sum += arr[val];
			}
			max = sum > max ? sum : max;
		}
		System.out.println(max);	
		
	}
}