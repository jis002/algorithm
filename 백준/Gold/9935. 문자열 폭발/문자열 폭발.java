import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String target = br.readLine();
		int n = input.length();
		int m = target.length();
		
		Stack<Character> stack = new Stack<>();
		
		//input을 하나씩 순회하면서 stack에 넣는다
		for(int i=0; i<n; i++) {
			char current = input.charAt(i);
			stack.add(current);
			
			//만약 해당 문자가 target의 마지막 글자와 일치하면
			if(current == target.charAt(m-1)) {
				//stack의 사이즈가 target 길이보다 큰지 확인
				if(stack.size() >= m) {
					boolean flag = true; //폭발문자열이면 true
					//stack내 글자들이 target과 일치하는 지 확인
					for(int j=0; j<m; j++) {
						if(stack.get(stack.size() - m + j) != target.charAt(j)) {
							flag = false;
							break;
						}
					}
					
					//폭발문자열이면 stack에서 pop
					if(flag) {
						for(int j=0; j<m; j++) {
							stack.pop();
						}
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(stack.isEmpty()) {
			sb.append("FRULA");
		} else {
			for(char c : stack) {
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
	}
}