import java.util.*;

class Solution {    
    
    static int answer;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        n = computers.length;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(!visited[i] && computers[i][j] == 1) {
                    bfs(i, j, n, computers);
                    answer++;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) answer++;
        }
        
        return answer;
    }
    
    static void bfs(int i, int j, int n, int[][] computers) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0];
            int v = curr[1];
            visited[u] = visited[v] = true;
            computers[u][v] = computers[v][u] = 0;
            
            for(int k=0; k<n; k++) {
                if(computers[u][k] == 1 && u!=k) {   
                    q.add(new int[] {u, k});
                }
                
                if(computers[v][k] == 1 && v!=k) {   
                    q.add(new int[] {v, k});
                }
            }
        }
    }
    
}