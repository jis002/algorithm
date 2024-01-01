import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            long S = Long.parseLong(br.readLine());
            String answer = "YES";
            long sqrtS = (long) Math.sqrt(S) + 1;
            long limit = Math.min(sqrtS, 1000000);
            for(int j=2; j<limit; j++) {
                if(S % j == 0) {
                    answer = "NO";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
