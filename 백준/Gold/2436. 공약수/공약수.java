import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int A;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        // B의 약수 구하기
        for(int i=1; i<=(int) Math.sqrt(B); i++) {
            if(B%i == 0) {
                // 두 수는 A를 약수로 가져야 함
                if(i%A==0) list.add(i);
                if((B/i)%A==0) list.add(B/i);
            }
        }

        // 후보 중 두 수를 골라 A를 최대공약수로, B를 최소공배수로 갖는 지 확인
        Collections.sort(list);
        int diff = Integer.MAX_VALUE;
        int ans1 = A;
        int ans2 = B;
        for(int i=0; i<list.size()-1; i++) {
            int x = list.get(i);
            for(int j=i+1; j<list.size(); j++) {
                int y = list.get(j);

                int GCD = gcd(x, y);
                if(GCD != A) continue;

                int LCM = lcm(x, y, GCD);
                if(LCM == B) {
                    if(y-x < diff) {
                        ans1 = x;
                        ans2 = y;
                        diff = y-x;
                    }
                }
            }
        }
        System.out.println(ans1+" "+ans2);
    }


    // a <= b
    private static int lcm(int a, int b, int GCD) {
        return a / GCD * b;
    }

    private static int gcd(int a, int b) {
        int temp = 0;
        while(b%a != 0) {
            temp = b%a;
            b = a;
            a = temp;
        }
        return a;
    }
}
