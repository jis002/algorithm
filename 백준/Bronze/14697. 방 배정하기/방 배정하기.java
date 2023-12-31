import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        outer: for(int i=0; i<=N/A; i++) {
            for(int j=0; j<=N/B; j++) {
                for(int k=0; k<=N/C; k++) {
                    if(N - (i*A + j*B + k*C) == 0) {
                        answer = 1;
                        break outer;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
