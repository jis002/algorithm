import java.math.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int max1 = 1;
        int max2 = 1;
        
        for(int i=0; i<sizes.length; i++) {
            // 명함의 가로 세로를 비교하여 큰 값을 big, 작은 값을 small이라 지정
            int big = sizes[i][0] >= sizes[i][1] ? sizes[i][0] : sizes[i][1];
            int small = sizes[i][0] >= sizes[i][1] ? sizes[i][1] : sizes[i][0];
            
            // big은 max1과 비교, small은 max2와 비교하여 더 큰 값으로 max값 갱신
            max1 = Math.max(max1, big);
            max2 = Math.max(max2, small);
        }
        
        int answer = max1 * max2;
        return answer;
    }
}