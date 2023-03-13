import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[8];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String res = "mixed";
		for(int i=0; i<8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dis = new int[7];
		for(int i=0; i<7; i++) {
			if(arr[i] > arr[i+1]) {
				dis[i] = 1;
				if(i==6 && dis[i]==dis[i-1]) {
					res = "descending";
				}
			} else if (arr[i] < arr[i+1]){
				dis[i] = 2;
				if(i==6 && dis[i]==dis[i-1]) {
					res = "ascending";
				}
			}
			if(i!=0 && dis[i]!=dis[i-1]) {
				break;
			}
		}
		
		System.out.println(res);
		
	}

}