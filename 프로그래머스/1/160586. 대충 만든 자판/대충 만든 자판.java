import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] counts = new int[26];
        int[] answer = new int[targets.length];
        
        
        for(int i=0; i<targets.length; i++) {
            int sum = 0;
            
            outer: for(int j=0; j<targets[i].length(); j++) {
                int idx = targets[i].charAt(j) - 'A';
                
                if(counts[idx] == -1) {
                    sum = -1;
                    break outer;
                
                } else if(counts[idx] == 0) {
                    int cnt = Integer.MAX_VALUE;

                    for(int b=0; b<keymap.length; b++) {
                        for(int c=0; c<keymap[b].length(); c++) {

                            if(keymap[b].charAt(c) == targets[i].charAt(j)) {
                                cnt = Math.min(cnt, c+1);
                            }
                        }
                    }
                    counts[idx] = cnt == Integer.MAX_VALUE ? -1 : cnt;
                    if(counts[idx] == -1) {
                        sum = -1;
                        break outer;
                    }
                    sum += counts[idx];
                    
                } else {
                    sum += counts[idx];
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}