import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = 0;

        for(int i=0; i<=K; i++) {
            if(N-i < 0 || M-(K-i) < 0) continue;
            int wCnt = N-i;
            int mCnt = M-(K-i);
            max = mCnt*2 <= wCnt ? Math.max(max, mCnt) : Math.max(max, wCnt/2);
        }

        System.out.println(max);
    }
}
