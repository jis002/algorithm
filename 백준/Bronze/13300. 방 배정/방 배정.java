import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 행:학년 열:성별인 2차원 배열
		int[][] students = new int[7][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st2.nextToken());
			int grade = Integer.parseInt(st2.nextToken());
			students[grade][gender]++;
		}
		
		// 몇 개의 방이 필요한지 확인하기
		int cnt = 0; // 필요한 방 개수를 담을 변수
		for(int i=1; i<7; i++) {
			for(int j=0; j<2; j++) {
				while( students[i][j] > 0 ) {
					students[i][j] -= K;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		br.close();
		
	}

}