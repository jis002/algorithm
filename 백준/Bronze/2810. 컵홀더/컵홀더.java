import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		int cntS = 0;
		int cntL = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='S') cntS++;
			else cntL++;
		}
		
		if(cntL>0) {
			cntL = cntL/2 +1;
		}
		
		int result = cntS + cntL;
		System.out.println(result);
	
		br.close();
	}

}