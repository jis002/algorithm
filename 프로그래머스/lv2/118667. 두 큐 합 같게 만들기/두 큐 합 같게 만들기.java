import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        
        int answer = 0;
        
        long sum1 = 0;
        long sum2 = 0;
                
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
                
        for(int i=0; i<queue1.length; i++) {
            sum1 += (long)queue1[i];
            q1.add((long)queue1[i]);
        }
        for(int i=0; i<queue2.length; i++) {
            sum2 += (long)queue2[i];
            q2.add((long)queue2[i]);
        }
        
        long total = queue1.length + queue2.length;
        long target = total/2;
        long limit = (long)((total)*2+2);
        
        if(total%2==1) {
            return answer = -1;
        }
        
        while(true) {
            
            if(limit==0) {
                answer = -1;
                break;
            }
            
        	if(sum1>sum2) {
        		long num = q1.poll();
        		q2.add(num);
        		sum1 -= num;
        		sum2 += num;
        		++answer;
        	} else if (sum1<sum2) {
        		long num = q2.poll();
        		q1.add(num);
        		sum2 -= num;
        		sum1 += num;
        		++answer;
        	}
            
            if(sum1==sum2) {
                break;
            }
            
            --limit;
        }
        
        return answer;
    }
}