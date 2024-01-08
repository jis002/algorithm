import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int[] sums;

    public static void main(String[] args) throws IOException {

        sums = new int[1001]; // 누적합을 담는 배열
        sums[1] = 3;
        int last = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int N = Integer.parseInt(br.readLine());

            // 이미 구한 값인 경우 즉시 출력
            if(sums[N] != 0) {
                System.out.println(sums[N]);
                continue;
            }

            for(int j=last+1; j<=N; j++) {
                sums[j] = sums[j-1];
                for(int k=1; k<j; k++) {
                    if(coprime(j, k)) sums[j] += 2; // 점의 x, y좌표가 서로소인 경우 볼 수 있음
                }
            }
            last = N;
            System.out.println(sums[N]);
        }
    }

    // 서로소인지 확인하는 메서드
    private static boolean coprime(int a, int b) {
        int temp = 0;
        while(a%b != 0) {
            temp = a%b;
            a = b;
            b = temp;
        }
        return b == 1;
    }
}
