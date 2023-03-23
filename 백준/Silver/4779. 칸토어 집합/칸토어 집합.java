import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int N;
	static boolean[] arr;
	static StringBuilder sb;
	static int size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			N = sc.nextInt();
			arr = new boolean[(int) Math.pow(3, N)];
			size = arr.length;
			sb = new StringBuilder();
			
			makeBlank(0, size);
			
			for(int k=0; k<arr.length; k++) {
				if(arr[k]) {
					sb.append(" ");
				} else {
					sb.append("-");
				}
			}
			System.out.println(sb.toString());
		}
	}

	public static void makeBlank(int st, int ed) {
		// 기저 조건
		if((ed-st+1)<3) {
			return;
		}
		
		// 재귀 조건
		int a = st+((ed-st+1)/3);
		int b = st+((ed-st+1)/3*2);
		for(int i=a; i<b; i++) {
			arr[i] = true;
		}
		makeBlank(b, ed); // 오른쪽
		makeBlank(st, a); // 왼쪽
	}
	

}