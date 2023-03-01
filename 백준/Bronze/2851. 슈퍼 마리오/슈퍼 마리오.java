import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n번째 버섯까지 먹은 경우 점수를 담을 배열
		int[] scores = new int[11];
		// 100과 차이가 가장 작은 값을 구하기 위한 변수 
		int min = Integer.MAX_VALUE;
		int idx = -1;	// 100과 차이가 가장 작은 값을 갖는 인덱스
		
		for(int i=1; i<11; i++) {
			scores[i] = scores[i-1] + Integer.parseInt(br.readLine());
			int abs = Math.abs(100-scores[i]);
			if(abs <= min) {
				min = abs;
				idx = i;
			}
		}
		
		System.out.println(scores[idx]);
		br.close();
	}
}