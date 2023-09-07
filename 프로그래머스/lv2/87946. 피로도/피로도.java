import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer;
    static int n;
    static int[] sel;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        n = dungeons.length;
        visited = new boolean[n];
        sel = new int[n];
        
        permutation(0, k, dungeons);
        
        return answer;
    }
    
    private void permutation(int idx, int k, int[][] dungeons) {
        if(idx == n) {
            int cnt = visitDungeons(k, dungeons);
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                sel[idx] = i;
                visited[i] = true;
                permutation(idx+1, k, dungeons);
                visited[i] = false;
            }
        }
    }
    
    private int visitDungeons(int k, int[][] dungeons) {
        // System.out.println(Arrays.toString(sel));
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(k >= dungeons[sel[i]][0]) {
                k -= dungeons[sel[i]][1];
                if(k >= 0) {
                    cnt++;
                } else {
                    return cnt;
                }
            } else {
                return cnt;
            }
        }
        return cnt;
    }
}