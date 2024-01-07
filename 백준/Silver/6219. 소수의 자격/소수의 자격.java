import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] nums = new boolean[B+1];
        Arrays.fill(nums, true);
        nums[0] = nums[1] = false;

        int end = (int) Math.sqrt(B);
        for(int i=2; i<=end+1; i++) {
            if(!nums[i]) continue;
            for(int j=i*i; j<=B; j+=i) {
                nums[j] = false;
            }
        }

        int answer = 0;
        String target = String.valueOf(D);
        for(int i=A; i<=B; i++) {
            if(nums[i]) {
                String str = String.valueOf(i);
                if(str.contains(target)) answer++;
            }
        }

        System.out.println(answer);
    }
}
