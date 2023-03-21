import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N; // 숫자 개수
	static int K; // 목표 합
	static int[] arr; 
	
	static boolean[] selected;
	static int sum; 
	static int cnt; // 조건을 충족하는 경우의 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			selected = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			sum = 0;
			
			combination(0);
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

	// idx : 몇 번째 원소인가
	private static void combination(int idx) {
//		System.out.println(Arrays.toString(selected) + " " + sum);
		if(sum == K) {
			cnt++;
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		// 해당 원소를 선택
		selected[idx] = true;
		sum += arr[idx];
		combination(idx+1);
		
		// 해당 원소 선택안함
		selected[idx] = false;
		sum -= arr[idx];
		combination(idx+1);
	
	}

}