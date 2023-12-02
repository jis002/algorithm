import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int answer = bridge_length;        
        int sum = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }
        
        Queue<Integer> trucks = new LinkedList<>();
        for(int i : truck_weights) {
            trucks.add(i);
        }
        
        while(!trucks.isEmpty()) {
            
            sum -= bridge.poll();
            
            if(sum + trucks.peek() <= weight) {
                sum += trucks.peek();
                bridge.offer(trucks.poll());
            } else {
                bridge.offer(0);
            }

            answer++;
        }
        
        return answer;
    }
}