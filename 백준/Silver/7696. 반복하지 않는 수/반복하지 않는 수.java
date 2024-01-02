import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int[] nums;
    static int maxIdx;

    public static void main(String[] args) throws IOException {

        nums = new int[1000002];
        maxIdx = 1;
        nums[1] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            // 이미 계산한 적 있는 값인 경우 바로 출력
            if(nums[n] != 0) {
                System.out.println(nums[n]);
                continue;
            }

            int idx = maxIdx;
            int no = nums[idx];

            int[] arr = new int[10];
            while(idx<=n) {
                boolean flag = true;
                Arrays.fill(arr, 0); // 메모리 절약
                int key = no;
                while(key>0) {
                    int temp = key%10;
                    key /= 10;
                    if(++arr[temp] > 1) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    nums[idx] = no++;
                    idx++;
                } else {
                    no++;
                }
            }
            maxIdx = Math.max(maxIdx, idx-1); // 중복 계산 최소화를 위한 maxIdx 갱신
            System.out.println(nums[n]);
        }
    }
}
