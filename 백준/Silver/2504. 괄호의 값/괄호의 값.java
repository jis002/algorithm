import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		int ans = 0;
		int value = 1;
		
		for(int i=0; i<x.length(); i++) {
			
			if(x.charAt(i)=='(') {
				stack.push('(');
				value *= 2;
			} else if(x.charAt(i)=='[') {
				stack.push('[');
				value *= 3;
			
			} else if(x.charAt(i)==')') {
				if(stack.isEmpty() || stack.peek()!='(') {
					ans = 0;
					break;
				} else if(x.charAt(i-1) == '('){
					ans += value;
				}
				stack.pop();
				value /= 2;
				
			} else if(x.charAt(i)==']') {
				if(stack.isEmpty() || stack.peek()!='[') {
					ans = 0;
					break;
				} else if(x.charAt(i-1) == '['){
					ans += value;
				}
				stack.pop();
				value /= 3;
			}
		}
		
		System.out.println(stack.isEmpty() ? ans : 0);
		
	}
}