import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int n = 0;
        
        for(int[] command : commands) {
            int m = command[1]-command[0]+1;
            int[] sArr = new int[m];
            int a = 0;
            for(int k=command[0]; k<=command[1]; k++) {
                sArr[a++] = array[k-1];
            }
            Arrays.sort(sArr);
            
            answer[n++] = sArr[command[2]-1];
        }
        
        return answer;
    }
}