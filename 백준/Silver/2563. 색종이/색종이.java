import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					arr[r+i][c+j] = 1;
				}
			}
		}
		
		// 값이 1인 경우 색종이가 있는 영역이므로 넓이+1
		int sum = 0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(arr[i][j] == 1) {
					sum++;
				}
			}
		}
		System.out.println(sum);
		
	}

}