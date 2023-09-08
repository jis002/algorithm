import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            // '(' 를 만나면 스택에 담기
            if(c == '(') {
                stack.push('(');
            } else { // ')' 를 만나면 스택에서 하나 꺼내서 없애기
                if(!stack.isEmpty()) {
                    stack.pop();
                } else { // 스택에서 꺼낼 게 없으면 false
                    return false; 
                }
            }
        }
        
        // stack에 남은 게 있으면 false
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}