import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 스위치의 개수
		
		// 스위치 기초 상태 입력 받기
		int[] switches = new int[N];
		String[] temp = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			switches[i] = Integer.parseInt(temp[i]);
		}
		
		int T = Integer.parseInt(br.readLine()); // 학생 수
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken()); // 학생 성별
			int num = Integer.parseInt(st.nextToken()); // 받은 번호
			
			if(gender==1) { // 남학생일 때
				for(int i=0; i<N; i++) {
					if((i+1)%num == 0) {
						if(switches[i]==0) {
							switches[i]=1;
						} else {
							switches[i]=0;
						}
					}
				}
			} else { // 여학생일 때
				int d = -1;
				num = num-1;
				for(int i=0; i<N/2; i++) {
					if(0<=num-i && num+i<N) {
						if(switches[num-i] != switches[num+i]) {
							break; 						
						} else {
							d = i;
						}
					}
				}
				
				for(int i = num-d; i<=num+d; i++) {
					if(switches[i]==0) {
						switches[i]=1;
					} else {
						switches[i]=0;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.printf("%d ", switches[i]);
			if((i+1)%20 == 0) {
				System.out.println();
			}
		}
		
		br.close();
	}

}