import java.util.*;

class Solution {
    public int solution(String A, String B) {
        
        int max = A.length();
        int answer = 0;
        
        if(A.equals(B)) return answer;
        
        String currA = A;
        
        while(answer < max) {
            answer++;
            
            StringBuilder sb = new StringBuilder();
            sb.append(currA.charAt(max-1));
            for(int i=0; i<max-1; i++) {
                sb.append(currA.charAt(i));
            }
            currA = sb.toString();
            
            if(currA.equals(B)) {
                return answer;
            }
        }
        
        if(answer == max) return -1;
        return answer;
    }
}