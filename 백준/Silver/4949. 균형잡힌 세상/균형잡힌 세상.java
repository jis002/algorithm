import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(true) {
			
			Stack<Character> stack = new Stack<>();
			String result = "yes";
			
			String str = br.readLine();
			if(str.equals(".")) break;

			int n = str.length();
			
			for(int i=0; i<n; i++) {
				if(str.charAt(i)=='(') {
					stack.add('(');
				} else if(str.charAt(i)=='[') {
					stack.add('[');
				} else if(str.charAt(i)==')') {
					if(!stack.isEmpty() && stack.peek()=='(') {
						stack.pop();
					} else {
						result = "no";
						break;
					}
				} else if(str.charAt(i)==']') {
					if(!stack.isEmpty() && stack.peek()=='[') {
						stack.pop();
					} else {
						result = "no";
						break;
					}	
				}
			}
			
			if(!stack.isEmpty()) result = "no";
			System.out.println(result);
			
		}

	}

}