import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		if(M==1 && N==1) {
			System.out.println("-1");
			
		} else {
			
			int sum = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			//소수 찾기
			for(int i=M; i<=N; i++) {	
				boolean isPrime = true;
				for(int j=2; j<=Math.sqrt(i); j++) {
					if(i%j == 0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime && i!=1) {
					pq.add(i);
					sum += i;
				}
			}
			
			if(pq.size()==0) {
				System.out.println("-1");
			} else {
				System.out.println(sum);
				System.out.println(pq.poll());
			}
		}
	}
}