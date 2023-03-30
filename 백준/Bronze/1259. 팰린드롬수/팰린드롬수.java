import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) break;
			
			int N = str.length();
			int M = N/2;
			boolean flag = true;
			for(int i=0; i<M; i++) {
				if(str.charAt(i)!=str.charAt(N-1-i)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}