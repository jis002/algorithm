import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int[][] works;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        works = new int[N][2];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1];

        for(int curr=N-1; curr>=0; curr--) {
            // 현재 작업 선택
            if(curr + works[curr][0] <= N) {
                dp[curr] = Math.max(dp[curr], dp[curr + works[curr][0]] + works[curr][1]);
            }
            // 현재 작업 선택하지 않음
            dp[curr] = Math.max(dp[curr], dp[curr+1]);
        }

        System.out.println(dp[0]);

//        System.out.println(recur(0));
    }


    // 탑다운 방식은 시간 초과
    private static int recur(int curr) {
        if(curr > N) {
            return Integer.MIN_VALUE; // 엄청 작은 값 아무거나 넣어서 최대값이 되지 못하게 함
        }
        if(curr == N) { 
            return 0; // 모든 작업이 끝나 추가 이익을 얻을 수 없음
        }
        if(dp[curr] != 0) {
            return dp[curr];
        }

        return dp[curr] = Math.max(recur(curr+works[curr][0]) + works[curr][1], recur(curr+1));
    }

}
