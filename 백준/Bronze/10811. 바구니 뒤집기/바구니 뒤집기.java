import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 바구니 뒤집기
 * 1. 배열 입력 받기
 *  startIdx = 입력받은수-1, endIdx =입력받은수-x 
 * 2. 배열을 뒤집을 범위 길이 구하기 : d = endIdx - startIdx
 * 3. midIdx = d/2
 *  3-1. d가 홀수이면, 
 *    for i from 0 to mid 
 *    swap (midIdx-i, midIdx+i)
 *  3-2. d가 짝수이면
 *    for i from 0 to mid
 *    swap (midIdx-i, midIdx-1+i)  
 */
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st1.nextToken())-1; 
			int end = Integer.parseInt(st1.nextToken())-1;
			int d = end-start+1;  // 뒤집을 바구니 개수
			int mid = d/2;
			if(d%2 == 1) { // d가 홀수 
				for(int j=0; j<=mid; j++) {
					int tmp = arr[start+mid-j];
					arr[start+mid-j] = arr[start+mid+j];
					arr[start+mid+j] = tmp;
				}
			} else { // d가 짝수
				for(int j=0; j<mid; j++) {
					int tmp = arr[start+mid-1-j];
					arr[start+mid-1-j] = arr[start+mid+j];
					arr[start+mid+j] = tmp;
				}
			}
		}
		for(int value : arr) {
			System.out.print(value+" ");
		}
	}
}