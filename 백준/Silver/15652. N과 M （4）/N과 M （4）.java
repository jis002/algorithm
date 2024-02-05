import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int M;
    static int[] nums;
    static int[] selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        selected = new int[M];
        for(int i=0; i<N; i++) {
            nums[i] = i+1;
        }

        sb = new StringBuilder();
        permutation(0, 0);
        System.out.println(sb.toString());
    }

    private static void permutation(int idx, int sidx) {
        if(sidx == M) {
            for(int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        if(idx == N) return;

        selected[sidx] = nums[idx];
        permutation(idx, sidx+1);
        permutation(idx+1, sidx);
    }
}
