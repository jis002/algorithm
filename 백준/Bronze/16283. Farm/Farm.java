import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int S = 0;
        for(int x=1; x<=1000; x++) {
            if(a*x + b*(n-x) == w) {
                if(n-x <= 0) continue;
                S = x;
                cnt++;
                if(cnt == 2) break;
            }
        }

        if(cnt == 1) {
            System.out.printf("%d %d", S, n-S);
        } else {
            System.out.println(-1);
        }
    }
}
