import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static int[] ans; // 출력 순으로 트리 순서를 재구성한 배열
	public static int idxAns; // ans 배열의 인덱스. 재귀함수에서 활용.

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++) {
			int K = Integer.parseInt(br.readLine());
			int n = (int)(Math.pow(2, K)) - 1;
			int[] node = new int[n]; // 중위 순회 순서로 입력하는 배열

			// 중위 순회 순서로 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				node[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = new int[n+1]; // 자식 노드의 인덱스로 편하게 이동하기 위해 n+1사이즈로 초기화.
			idxAns = 1;
			
			// 출력해야 하는 순서대로 ans 배열을 채우는 재귀함수
			search(0, n-1, idxAns, node);
			
			// 출력
			System.out.print("#"+t+" ");
			int num = 0;
			int i = 1;
			for(int lev=0; lev<K; lev++) {
				num += (int)Math.pow(2, lev); // 레벨 별로 출력할 원소 개수
				for( ; i<=num; i++) {
					System.out.printf(ans[i]+" ");
				}
				System.out.println();
			}	
		}
	} // main
	
	

	private static void search(int startIdx, int endIdx, int idxAns, int[] node) {		
		// 현재 루트 노드 
		int idx = (startIdx + endIdx)/2;
		ans[idxAns] = node[idx];
		
		if( startIdx == endIdx ) {
			return;
		}
		
		// 좌측에서 루트 노드 찾기 
		search(startIdx, idx-1, idxAns*2, node);
		// 우측에서 루트 노드 찾기
		search(idx+1, endIdx, idxAns*2+1, node);
	}


}
