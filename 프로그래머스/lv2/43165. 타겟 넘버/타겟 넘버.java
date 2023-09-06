import java.util.*;

class Solution {
    
    static int answer;
    static int n; // number 개수
    static int tg; // target
    static char[] sel; // +, - 부호를 담는 배열
    static int[] numbersCopy;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length;
        tg = target;
        numbersCopy = Arrays.copyOfRange(numbers, 0, n);
        sel = new char[n];
        
        dfs(0);
        
        return answer;
    }
    
    // sidx: sel 배열 인덱스
    static void dfs(int sidx) {
        if(sidx == n) {
            // 합계 = target 이면 answer++;
            if(isTarget()) answer++;
            return;
        }
                
        sel[sidx] = '+';
        dfs(sidx+1);
        sel[sidx] = '-';
        dfs(sidx+1);
    }
    
    static boolean isTarget() {
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(sel[i] == '+') {
                sum += numbersCopy[i];
            } else {
                sum -= numbersCopy[i];
            }
        }
        return sum == tg ? true : false; 
    }
    
    
}