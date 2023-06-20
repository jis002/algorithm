import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("Case #").append(t).append(": ");
			
			Stack<String> stack = new Stack<>();
			String[] words = br.readLine().split(" ");
			
			for(int i=0; i<words.length; i++) {
				stack.add(words[i]);
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			sb.setLength(sb.length()-1);
			
			System.out.println(sb.toString());
		}
	}
}