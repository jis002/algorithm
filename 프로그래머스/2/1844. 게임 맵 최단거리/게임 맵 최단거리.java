import java.util.*;

class Solution {
    
    static int answer;
    static int n, m;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        answer = bfs(0, 0, 1, maps);        
        return answer;
    }
    
    private int bfs(int r, int c, int count, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[] {r, c, count});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            r = curr[0];
            c = curr[1];
            count = curr[2];
            
            if(r==n-1 && c==m-1) {
                return count;
            }
            
            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isInMap(nr, nc) && !visited[nr][nc] && maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc, count+1});
                } 
            }
        }
        return -1;
    }
    
    
    private boolean isInMap(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < n && nc < m;  
    }
}