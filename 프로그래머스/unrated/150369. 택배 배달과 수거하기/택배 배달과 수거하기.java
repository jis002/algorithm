import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        long answer = 0;
        int capD = cap;
        int capP = cap;
        int maxD = 0;
        int maxP = 0;
        
        for(int i=n-1; i>=0; i--) {
            if(deliveries[i] !=0) {
                maxD = i+1;
                break;
            }
        }
        
        for(int i=n-1; i>=0; i--) {
            if(pickups[i] !=0) {
                maxP = i+1;
                break;
            }
        }
        

        while(true) {
                        
            if(maxD != -1) {
                for(int i=maxD-1; i>=0; i--) {
                    if(capD !=0 && deliveries[i] !=0) {
                        if(capD > deliveries[i]) {
                            capD -= deliveries[i];
                            deliveries[i] = 0;
                        } else {
                            deliveries[i] -= capD;
                            capD = 0;
                            break;
                        }
                    }
                }
            }
            
            if(maxP != -1) {
                for(int i=maxP-1; i>=0; i--) {
                    if(capP !=0 && pickups[i] != 0) {
                        if(capP > pickups[i]) {
                            capP -= pickups[i];
                            pickups[i] = 0;
                        } else {
                            pickups[i] -= capP;
                            capP = 0;
                            break;
                        }
                    }
                }
            }
            
            int max = Math.max(maxD, maxP);
            
            answer += max;
            
            capD = capP = cap;

            // System.out.println(Arrays.toString(deliveries));
            // System.out.println(Arrays.toString(pickups));
            
            boolean flag1 = true;
            for(int i=maxD-1; i>=0; i--) {
                if(deliveries[i] !=0) {
                    maxD = i+1;
                    flag1 = false;
                    break;
                }
            }
            if(flag1) maxD = -1;
            
            boolean flag2 = true;
            for(int i=maxP-1; i>=0; i--) {   
                if(pickups[i] !=0) {
                    maxP = i+1;
                    flag2 = false;
                    break;
                }
            }
            if(flag2) maxP = -1;
            
            // 종료 조건
            if(maxD==-1 && maxP==-1) break;
        }
        
        answer *= 2;
        return answer;
    }
}