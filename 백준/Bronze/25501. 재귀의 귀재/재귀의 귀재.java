import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// tc별로 recursion 함수를 호출하는 횟수를 세는 배열
	static int[] count = new int[1001];
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String s = br.readLine();
			int p = isPalindrome(s, t);
			int cnt = count[t];
			System.out.printf("%d %d\n", p, cnt);
		}

	}

	
	private static int isPalindrome(String s, int t) {
		return recursion(s, 0, s.length()-1, t);
	}

	
	private static int recursion(String s, int i, int j, int t) {
		count[t]++; // recursion 함수를 호출하는 횟수 세기
		if(i >= j) return 1;
		if(s.charAt(i) != s.charAt(j)) {
			return 0;
		}
		else return recursion(s, i+1, j-1, t);
	}	

}