import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			int n = str.length();
			
			String ans = "YES";
			
			for(int i=0; i<n; i++) {
				if(str.charAt(i)=='(') {
					stack.add('(');
				} else { // ')'를 만나면
					if(!stack.isEmpty()) {
						stack.pop();
					} else { // 스택이 비어있으면
						ans = "NO";
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) ans = "NO";
			
			System.out.println(ans);
		}
		br.close();
	}
}