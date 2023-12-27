import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int b=1; b<=500; b++) {
            for(int a=1; a<=500; a++) {
                if(b*b + N == a*a) ans++;
            }
        }

        System.out.println(ans);
    }
}
