import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int[] nums;
	static char[] signs;
	static int N;
	static int max;
	static int min;
	
	static char[] selSigns;
	static boolean[] visitedSigns;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		signs = new char[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for(int i=0; i<4; i++) {
			int signCnt = Integer.parseInt(st.nextToken());
			if(signCnt != 0 && i == 0) {
				for(int j=0; j<signCnt; j++) {
					signs[idx++] = '+';
				}
			} else if(signCnt != 0 && i == 1) {
				for(int j=0; j<signCnt; j++) {
					signs[idx++] = '-';
				}
			} else if(signCnt != 0 && i == 2) {
				for(int j=0; j<signCnt; j++) {
					signs[idx++] = '*';
				}
			} else if(signCnt != 0 && i == 3) {
				for(int j=0; j<signCnt; j++) {
					signs[idx++] = '/';
				}
			}
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		selSigns = new char[N-1];
		visitedSigns = new boolean[N-1];
		permutation(0);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	
	static void permutation(int idx) {
		if(idx == N-1) {
			int res = calculate();
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(visitedSigns[i] != true) {
				visitedSigns[i] = true;
				selSigns[idx] = signs[i];
				permutation(idx+1);
				visitedSigns[i] = false;
			}
		}
	}
	
	
	static int calculate() {
		int res = nums[0];
		for(int i=1; i<N; i++) {
			char sign = selSigns[i-1];
			int num = nums[i];
			switch (sign) {
			case '+':
				res += num;
				break;
			case '-':
				res -= num;
				break;
			case '*':
				res *= num;
				break;
			case '/':
				res /= num;
				break;
			}
		}
		return res;
	}
}