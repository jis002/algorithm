import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> nums = new ArrayList<>();
            while(st.hasMoreTokens()) {
                nums.add(Integer.parseInt(st.nextToken()));
            }

            int max = 1;
            for(int j=0; j<nums.size()-1; j++) {
                for(int k=j+1; k<nums.size(); k++) {
                    int gcd = gcd(Math.min(nums.get(j), nums.get(k)), Math.max(nums.get(j), nums.get(k)));
                    max = Math.max(max, gcd);
                }
            }
            System.out.println(max);
        }
    }

    // 최대공약수 구하기 a<=b
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
