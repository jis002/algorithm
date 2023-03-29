import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[1001];
		for(int i=2; i<1001; i++) {
			nums[i] = i;
		}
		for(int i=2; i<1001; i++) {
			if(nums[i]==0) continue;
			for(int j=i+i; j<1001; j+=i) {
				nums[j]=0;
			}
		}
		
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(nums[num]!=0) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}