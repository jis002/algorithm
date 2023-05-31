import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int position = 0;
			
			while(n > 0) {
				if((n & 1) == 1) { // 둘 다 1인 경우 1 
					System.out.print(position+" ");
				}
				n = n >> 1; //n을 오른쪽으로 한 비트씩 이동
				position++;
			}
		}
	}
}