import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        List<Integer> nextList = new ArrayList<>();
        int startIdx = 0;
        int lastIdx = arr.length;
        
        for(int i=0; i<query.length; i++) {
            if(i%2==0) {
                lastIdx = startIdx + query[i];
            } else {
                startIdx += query[i];
            }
        }
        
        int[] answer = new int[lastIdx - startIdx + 1];
        for(int i=0; i<answer.length; i++) {
            answer[i] = arr[startIdx+i];
        }
        
        return answer;
    }
}