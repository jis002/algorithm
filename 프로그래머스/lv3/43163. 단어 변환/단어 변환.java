import java.util.*;
import java.math.*;

class Solution {
    
    static int N; // 단어 개수
    static int len; // 단어 길이
    static int min; // 최저 변환 값
    static boolean visited[];
    
    public int solution(String begin, String target, String[] words) {
        N = words.length;
        len = begin.length();
        min = Integer.MAX_VALUE;
        visited = new boolean[N];
        
        dfs(0, 0, begin, target, words);
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    
    static void dfs(int idx, int cnt, String begin, String target, String[] words) {
        if(idx >= N) {
            return;
        }
        
        if(begin.equals(target)) {
            min = Math.min(min, cnt);
            return;
        }
        
        for(int i=0; i<N; i++) {
            
            if(min <= cnt || visited[i] || !canBeChanged(begin, words[i])) {
                continue;
            }
            
            visited[i] = true;
            dfs(i, cnt+1, words[i], target, words);
            visited[i] = false;
        }
    }
    
    // begin과 target이 변경 가능하면 true를 반환
    static Boolean canBeChanged(String begin, String target) {
        int differedCnt = 0;
        for(int i=0; i<len; i++) {
            if(begin.charAt(i) != target.charAt(i)) {
                differedCnt++;
            }
            if(differedCnt >= 2) {
                return false;
            }
        }
        return true;
    }
}