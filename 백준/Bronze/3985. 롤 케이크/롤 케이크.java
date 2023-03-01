import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] cake = new int[L+1];
		int max1 = -1; // 가장 많이 받을거라 기대한 케이크 수 
		int res1 = -1; // 사람
		int max2 = -1; // 실제로 가장 많이 돌아간 케이크 수
		int res2 = -1; // 사람
		
		for(int i=1; i<=N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int cnt1 = end-start+1; // 기대한 케이크 수
			if(cnt1 > max1) {
				max1 = cnt1;
				res1 = i;
			}
			
			int cnt2 = 0; // 실제로 받은 케이크 수
			for(int j=start; j<=end; j++) {
				if(cake[j]==0) {
					cake[j] = i;
					cnt2++;
				}
			}
			if(cnt2 > max2) {
				max2 = cnt2;
				res2 = i;
			}

		}
		
		System.out.println(res1);
		System.out.println(res2);
		br.close();

	}

}