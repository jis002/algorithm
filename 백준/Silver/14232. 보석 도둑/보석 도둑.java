import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        long cnt = 0L;
        StringBuilder sb = new StringBuilder();

        long sqrt = (long) Math.sqrt(k);
        for(long i=2L; i<=sqrt; i++) {
            while(k%i == 0) {
                sb.append(i).append(" ");
                cnt++;
                k = k/i;
            }
            if(k==1) break;
        }
        if(k!=1) {
            sb.append(k);
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(sb.toString().trim());
    }
}
