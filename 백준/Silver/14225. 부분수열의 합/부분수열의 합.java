import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int[] numbers;
    static boolean[] sums;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        sums = new boolean[2000001];
        findMinSum(0, 0);

        for(int i=1; i<2000001; i++) {
            if(!sums[i]) {
                ans = i;
                break;
            }
        }
        
        System.out.println(ans);
    }

    private static void findMinSum(int idx, int sum) {
        if(idx == N) {
            sums[sum] = true;
            return;
        }

        // 현재 수를 포함
        findMinSum(idx+1, sum+numbers[idx]);
        // 현재 수 포함안함
        findMinSum(idx+1, sum);
    }

}
