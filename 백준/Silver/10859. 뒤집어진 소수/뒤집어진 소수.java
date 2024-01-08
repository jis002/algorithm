import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        boolean flag = progress(N);
        if(flag) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean progress(long N) {
        // N이 소수인지 확인
        boolean isPrime1 = isPrimeNumber(N);
        if(!isPrime1) return false;

        // N을 뒤집은 숫자 구하기
        boolean isNumber = true;
        StringBuilder sb = new StringBuilder();
        while(N > 0) {
            int temp = (int) (N % 10);
            if(temp == 0 || temp == 1 || temp == 2 || temp == 5 || temp == 8) {
                sb.append(temp);
            } else if(temp == 6) {
                sb.append(9);
            } else if(temp == 9) {
                sb.append(6);
            } else {
                isNumber = false;
                break;
            }
            N /= 10;
        }
        if(!isNumber) return false;
        long rN = Long.parseLong(sb.toString());

        // 뒤집은 수가 소수인지 확인
        return isPrimeNumber(rN);
    }

    private static boolean isPrimeNumber(long n) {
        if(n==1) return false;
        if(n==2) return true;
        for(int i=2; i<Math.sqrt(n)+1; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
