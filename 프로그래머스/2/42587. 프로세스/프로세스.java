import java.util.*;
import java.math.*;

class Solution {
    
    class Process {
        int index;
        int priority;
        
        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int highestPriority = 1;
        int[] priorityCount = new int[10];
        
        Queue<Process> processQ = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            highestPriority = Math.max(highestPriority, priorities[i]);
            priorityCount[priorities[i]]++;
            Process process = new Process(i, priorities[i]);
            processQ.add(process);
        }
        
        outer: for(int i=highestPriority; i>0; i--) {
            for(int j=0; j<priorities.length; j++) {
                if(processQ.isEmpty()) break outer;
                if(priorityCount[i] == 0) break;
                
                Process current = processQ.poll();
                if(current.priority == i && current.index == location) {
                    answer++;
                    priorityCount[i]--;
                    break outer;
                } else if(current.priority == i && current.index != location) {
                    answer++;
                    priorityCount[i]--;
                } else {
                    processQ.add(current);
                }
            }
        }
        
        return answer;
    }
}