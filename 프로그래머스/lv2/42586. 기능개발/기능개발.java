import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        int n = speeds.length;
        
        for(int i=0; i<n; i++) {
            int differ = 100-progresses[i];
            int date = differ%speeds[i] == 0 ? differ/speeds[i] : differ/speeds[i]+1;
            q.add(date);
        }

        List<Integer> list = new ArrayList<>(); // 하루에 배포하는 작업 수를 받는 리스트
        int cnt = 1;
        int pre = q.poll();
        int s = q.size(); // 큐의 size가 달라지지 않도록 미리 저장
        
        for(int i=0; i<s; i++) {
            int curr = q.poll();
            if(pre >= curr) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                pre = curr;
            }
        }
        list.add(cnt); // 마지막 cnt를 더해줌
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }     
        
        return answer;
    }
}