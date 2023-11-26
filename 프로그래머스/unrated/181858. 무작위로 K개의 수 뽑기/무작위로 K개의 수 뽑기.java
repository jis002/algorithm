import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        
        int idx = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(idx == k-1) break;
            
            if(answer[idx] == -1) {
                answer[idx] = arr[i];
            } else if(answer[idx] != -1) {
                Boolean flag = false;
                for(int j=0; j<=idx; j++) {
                    if(answer[j] == arr[i]) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    answer[++idx] = arr[i];
                }
            }
        }
        
        return answer;
    }
}