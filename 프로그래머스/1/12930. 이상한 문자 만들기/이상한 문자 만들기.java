import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        
        int idx = 0;
        for(String str : arr) {
            idx = str.equals(" ") ? 0 : idx+1; 
            if(idx%2 != 0) {
                answer += str.toUpperCase();
            } else {
                answer += str.toLowerCase();
            }
        }
        
        return answer;
    }
}