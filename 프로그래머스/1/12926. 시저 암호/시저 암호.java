import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();
        
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(c==' ') {
                sb.append(" ");
            } else if('A' <= c && c <= 'Z') { 
                char newC = c+n <= 'Z' ? (char)(c+n) : (char)(c+n-26); 
                sb.append(newC);
            } else if('a' <= c && c <= 'z') {
                char newC = c+n <= 'z' ? (char)(c+n) : (char)(c+n-26);
                sb.append(newC);
            } 
        }      
        
        return sb.toString();
    }
}