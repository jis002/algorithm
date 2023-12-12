import java.util.*;
import java.math.*;

class Solution {
    public int solution(int number, int limit, int power) {
        
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=1; j<=Math.sqrt(i); j++) {
                if(i%j==0) {
                    set.add(j);
                    set.add(i/j);
                }
            }
            answer += set.size() > limit ? power : set.size();
        }
        
        return answer;
    }
}