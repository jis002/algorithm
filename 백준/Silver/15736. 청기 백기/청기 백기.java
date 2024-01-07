import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        // 거듭제곱수인 경우에만 백기
        for(int i=1; i<Math.sqrt(N)+1 & i*i<=N; i++) {
            answer++;
        }
        System.out.println(answer);
    }
}
