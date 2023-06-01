import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[1001];
		int idx = 0;
		int i = 1;
		
		outer: while(idx<1001) {
			for(int cnt=1; cnt<=i; cnt++) {
				if(idx==1000) break outer;
				nums[++idx] = i;
			}
			i++;
		}
		
		int ans = 0;
		for(int j=A; j<=B; j++) {
			ans += nums[j];
		}
		System.out.println(ans);
	}
}