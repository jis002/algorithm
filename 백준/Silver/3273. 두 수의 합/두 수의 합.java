import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int x = Integer.parseInt(br.readLine());
        int ans = 0;

        int str = 0; // 시작 idx
        int end = n-1; // 끝 idx
        while(str < end) {
            if(nums[str] + nums[end] == x) {
                ans++;
                str++;
                end--;
            } else if(nums[str] + nums[end] < x) {
                str++;
            } else {
                end--;
            }
        }

        System.out.println(ans);
    }
}
