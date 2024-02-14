import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int K;
    static int[][] bag;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bag = new int[N][2];
        dp = new int[N+1][K+1];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken()); // 무게
            bag[i][1] = Integer.parseInt(st.nextToken()); // 가치
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recur(0,  0));

    }

    private static int recur(int curr, int weight) {
        if(weight > K) {
            return Integer.MIN_VALUE; // 무게 초과시 무조건 답이 될 수 없게함
        }
        if(curr == N) {
            return 0;
        }
        if(dp[curr][weight] != -1) {
            return dp[curr][weight];
        }

        return dp[curr][weight] = Math.max(recur(curr+1, weight), recur(curr+1, weight + bag[curr][0]) + bag[curr][1]);
    }
}
