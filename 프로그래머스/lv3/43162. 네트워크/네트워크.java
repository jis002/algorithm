import java.util.*;

class Solution {    
    
    static int answer;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        n = computers.length;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                bfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int i, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = true;
            
            for(int k=0; k<n; k++) {
                if(computers[curr][k] == 1 && !visited[k]) {   
                    q.add(k);
                }
            }
        }
    }
    
}