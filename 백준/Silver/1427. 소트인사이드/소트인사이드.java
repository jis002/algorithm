import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] nums = new int[str.length()];
		int n = nums.length;
		for(int i=0; i<n; i++) {
			nums[i] = str.charAt(i)-'0';
		}
		
		// 선택 정렬
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) { 
				if(nums[j] > nums[i]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		
		for(int i : nums) {
			System.out.print(i);
		}
	
	}

}