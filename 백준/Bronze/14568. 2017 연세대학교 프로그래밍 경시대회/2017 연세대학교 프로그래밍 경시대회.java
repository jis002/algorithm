import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int x=2; x<=N-2; x=x+2) { // x는 짝수
            for(int y=1; y<=N-2; y++) {
                for(int z=1; z<=N-2; z++) {
                    if(x+y+z == N && z >= y+2) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
