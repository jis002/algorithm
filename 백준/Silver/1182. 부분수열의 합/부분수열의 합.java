import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int S;
    static int[] nums;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        combination(0, 0);

        if(S == 0) ans--; // 선택한 부분집합이 공집합인 경우 -1
        System.out.println(ans);
    }

    private static void combination(int cur, int sum) {
        if(cur == N) {
            if(sum == S) ans++;
            return;
        }

        // 선택하는 경우
        combination(cur+1, sum + nums[cur]);
        // 선택하지 않는 경우
        combination(cur+1, sum);
    }

}
