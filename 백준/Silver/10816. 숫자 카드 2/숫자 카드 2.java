import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr1 = new int[10000001];	//양수 카운트
		int[] arr2 = new int[10000001];	//음수 카운트
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num >= 0) {
				arr1[num]++;
			} else {
				arr2[-num]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num >= 0) {
				sb.append(arr1[num]).append(" ");
			} else {
				sb.append(arr2[-num]).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}