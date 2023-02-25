import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		int[][] arr = new int[9][9];
		int max = -1;
		int maxR = -1;
		int maxC = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int r=0; r<9; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<9; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]>max) {
					max = arr[r][c];
					maxR = r+1;
					maxC = c+1;
				}
			}
		}
		System.out.printf("%d\n%d %d", max, maxR, maxC);
		
	}
}