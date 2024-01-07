import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long answer = 0L;

        answer = calculate(B) - calculate(A-1); // f(A) + f(A+1) + f(A+2) + ... + f(B)와 같음

        System.out.println(answer);
    }

    private static long calculate(long n) {
        long sum = n;
        for(long i=2; i<=n; i*=2) {
            // n/i: n까지의 숫자 중 i의 배수인 숫자의 개수
            // i/2: 해당 단계에서의 2의 거듭제곱 값
            // 예: n=6, i=4인 경우, 6/4: 6이하 숫자 중 4로 나누어 떨어지는 수의 개수, 4/2: 4보다 한 단계 작은 2의 거듭제곱 값
            sum += (n/i) * i/2;
        }
        return sum;
    }
}
