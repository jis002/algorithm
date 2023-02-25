import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr1 = new int[N][M];
		int[][] arr2 = new int[N][M];
		
		// 첫번째 행렬 입력 받기
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			String[] strArr = str.split(" ");
			for(int j=0; j<M; j++) {
				arr1[i][j] = Integer.parseInt(strArr[j]);
			}
		}
		
		// 두번째 행렬 입력 받기
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			String[] strArr = str.split(" ");
			for(int j=0; j<M; j++) {
				arr2[i][j] = Integer.parseInt(strArr[j]);
			}
		}
		
		// 합 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int sum = arr1[i][j] + arr2[i][j];
				System.out.print(sum+" ");
			}
			System.out.println();
		}
		
		br.close();
	}

}