import java.util.*;

public class Solution {
    
    static int[] dp;
    
    public int solution(int n) {
        
        int cnt = 1;
        while(n>2) {
            if(n%2==1) {
                ++cnt;
            }
            n/=2;
        }
        int ans = cnt;
        
        /*
        dp = new int[n+1];
        
        dp[1] = 1;
        if(n>=2) {
            dp[2] = 1;
            godp(n);
        }
        */
        
        /*
        dp[1] = 1;
        if(n>=2) dp[2] = 1;
        
        for(int i=3; i<=n; i++) {
            if(i%2==0) {
                dp[i] = dp[i/2];
            } else {
                dp[i] = dp[i-1]+1;
            }
        }
        */
        
        // int ans = dp[n];

        return ans;
    }

    /*
    public int godp(int n) {
        if(dp[n]==0) {
            if(n%2==0) {
                return dp[n] = godp(n/2);
            } else {
                return dp[n] = godp(n-1)+1;
            }
        }
        return dp[n];
    }
    */
    
}