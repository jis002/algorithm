import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();
        
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(c==' ') {
                sb.append(" ");
            } else if(65 <= c && c <= 90) { // 대문자 범위 : 65~90
                char newC = c+n <= 90 ? (char)(c+n) : (char)(c+n-26); 
                sb.append(newC);
            } else if(97 <= c && c <= 122) { // 소문자 범위 : 97~122
                char newC = c+n <= 122 ? (char)(c+n) : (char)(c+n-26);
                sb.append(newC);
            } 
        }      
        
        return sb.toString();
    }
}