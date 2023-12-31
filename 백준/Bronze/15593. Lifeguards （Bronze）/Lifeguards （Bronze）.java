import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        int[] times = new int[1000]; // 0:0~1, 1:1~2, ..., 999:999~1000
        int ans = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lgs = new int[N][2]; // 라이프가드별 시간 범위

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lgs[i][0] = str;
            lgs[i][1] = end;

            for(int j=str; j<end; j++) {
                times[j]++;
            }
        }

        for(int i=0; i<N; i++) {
            int[] copyTimes = Arrays.copyOf(times, 1000);
            int cnt = 0;
            for(int j=lgs[i][0]; j<lgs[i][1]; j++) { // 라이프가드 커버 범위를 하나씩 제거
                copyTimes[j]--;
            }
            for(int k=0; k<1000; k++) {
                if(copyTimes[k]!=0) cnt++;
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
