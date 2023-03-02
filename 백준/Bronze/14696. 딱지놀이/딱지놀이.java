import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0; n<N; n++) {
			// 각 모양의 개수를 세는 카운팅 배열. 4:별, 3:동그라미, 2:세모, 1:네모
			int[] cntA = new int[5];
			int[] cntB = new int[5];
			
			StringTokenizer stA = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(stA.nextToken());
			for(int i=0; i<A; i++) {
				int tmp = Integer.parseInt(stA.nextToken());
				cntA[tmp]++;
			}
			
			StringTokenizer stB = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(stB.nextToken());
			for(int i=0; i<B; i++) {
				int tmp = Integer.parseInt(stB.nextToken());
				cntB[tmp]++;
			}
			
			// idx 4->3->2->1 순으로 많은 사람 비교
			String winner = "D";
			
			if( cntA[4] > cntB[4] ) {
				winner = "A";
			} else if (cntA[4] < cntB[4] ){
				winner = "B";
			} else { // 별 개수 동점이면
				if( cntA[3] > cntB[3] ) {
					winner = "A";
				} else if (cntA[3] < cntB[3] ){
					winner = "B";
				} else { // 동그라미 개수 동점이면
					if( cntA[2] > cntB[2] ) {
						winner = "A";
					} else if (cntA[2] < cntB[2] ){
						winner = "B";
					} else { // 세모 개수 동점이면
						if( cntA[1] > cntB[1] ) {
							winner = "A";
						} else if (cntA[1] < cntB[1] ){
							winner = "B";
						}
					}
				}
			}
			
			System.out.println(winner);	
		}
		
	}

}