import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int[][] meetings;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        meetings = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        ans = Integer.MIN_VALUE;
        getMaxPrice(0, 0);

        System.out.println(ans);

    }

    private static void getMaxPrice(int day, int price) {
        if(day >= N) {
            ans = Math.max(ans, price);
            return;
        }

        // day일의 상담 선택
        if(day + meetings[day][0] <= N) {
            getMaxPrice(day + meetings[day][0], price + meetings[day][1]);
        }
        // day일의 상담 선택 안함
        getMaxPrice(day+1, price);
    }
    
}
