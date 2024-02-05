import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static String[] signs;
    static int[] nums;
    static int[] sel;
    static boolean[] visited;
    static Long max;
    static Long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        signs = new String[N];
        sel = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            signs[i] = st.nextToken();
        }

        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;


        visited = new boolean[10];
        nums = new int[10];
        for(int i=0; i<10; i++) {
            nums[i] = i;
        }

        backtracking( 0);
        String ansMin = min.toString();

        if(ansMin.length() == N) {
            ansMin = "0" + ansMin;
        }

        System.out.println(max);
        System.out.println(ansMin);
    }

    private static void backtracking(int sidx) {
        if(sidx == N+1) {
            StringBuilder sb = new StringBuilder();
            for(int no : sel) {
                sb.append(no);
            }
            Long ans = Long.parseLong(sb.toString());
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }

        for(int i=0; i<10; i++) {
            if(visited[i]) continue;
            if(sidx > 0) {
                if(signs[sidx-1].equals(">") && sel[sidx-1] <= nums[i]) continue;
                if(signs[sidx-1].equals("<") && sel[sidx-1] >= nums[i]) continue;
            }
            visited[i] = true;
            sel[sidx] = nums[i];
            backtracking(sidx+1);
            visited[i] = false;
        }
    }
}
