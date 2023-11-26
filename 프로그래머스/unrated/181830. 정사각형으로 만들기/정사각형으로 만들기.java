import java.util.*;
import java.math.*;

class Solution {
    public int[][] solution(int[][] arr) {
        
        int rowLength = arr.length;
        int colLength = arr[0].length;
        int max = Math.max(rowLength, colLength);
        
        int[][] answer = new int[max][max];
        
        for(int i=0; i<rowLength; i++) {
            for(int j=0; j<colLength; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}