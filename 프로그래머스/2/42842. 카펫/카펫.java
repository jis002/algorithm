import java.util.*;
import java.math.*;

class Solution {
    
    static int brownS;
    
    public int[] solution(int brown, int yellow) {
        brownS = brown; 
        int target = brown + yellow;
        int[] answer = findFactors(target);
        
        return answer;
    }
    
    
    private int[] findFactors(int target) {
        int[] answer = new int[2];
        
        // 곱해서 brown+yellow 개수가 되는 수의 조합 구하기
        for(int i=1; i<=Math.sqrt(target); i++) {
            if(target % i == 0) {
                int row = target/i;
                
                // {row, i}가 정답인지 확인하기
                if(isAnswer(row, i)) {
                    answer[0] = row;
                    answer[1] = i;
                    break;
                };
            } 
        }
        return answer;
    }
    
    private boolean isAnswer(int row, int col) {
        return brownS == (row + col - 2) * 2 ? true : false;
    }
}