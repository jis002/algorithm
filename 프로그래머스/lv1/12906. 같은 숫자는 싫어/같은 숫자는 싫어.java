import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Queue<Integer> q = new LinkedList<>();
        
        int curr = arr[0];
        q.add(curr);
        for(int i=1; i<arr.length; i++) {
            if(curr != arr[i]) {
                q.add(arr[i]);
            }
            curr = arr[i];
        }
        
        int[] answer = new int[q.size()];
        for(int i=0; i<answer.length; i++) {
            if(!q.isEmpty()) answer[i] = q.poll();
        }
        
        return answer;
    }
}