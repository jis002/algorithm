import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2]; // 1열: 몸무게, 2열: 키
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());	
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int cnt = 1;
			for(int j=0; j<N; j++) {
				if(i!=j && arr[i][0] < arr[j][0]) {
					if(arr[i][1] < arr[j][1]) {
						cnt++;
					}
				}
			}
			System.out.print(cnt+" ");
		}

	}

}