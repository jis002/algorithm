import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int k = Integer.parseInt(st.nextToken());
			binarySearch(k);
		}
	}

	private static void binarySearch(int k) {
		boolean res = false;
		
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			int middle = (left+right)/2;
			if(k == arr[middle]) {
				res = true;
				break;
			} else if(k < arr[middle]) {
				right = middle-1;
			} else {
				left = middle+1;
			}
		}
		if(res) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}