import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] nums = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = n-1;
        int closetSum = Integer.MAX_VALUE;
        int[] ans = new int[2];

        while(s < e) {
            int sum = nums[s] + nums[e];
            if(Math.abs(sum) <= Math.abs(closetSum)) {
                closetSum = sum;
                ans[0] = nums[s];
                ans[1] = nums[e];
            }
            if(sum < 0) {
                s++;
            } else if(sum > 0) {
                e--;
            } else {
                ans[0] = nums[s];
                ans[1] = nums[e];
                break;
            }
        }

        System.out.println(ans[0]+" "+ans[1]);
    }
}
