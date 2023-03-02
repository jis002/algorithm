import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		List<Integer> rowLine = new ArrayList<>();
		List<Integer> colLine = new ArrayList<>();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st2.nextToken());
			
			if(c==0) { // 가로 자르기
				rowLine.add(Integer.parseInt(st2.nextToken()));
				
			} else { // 세로 자르기
				colLine.add(Integer.parseInt(st2.nextToken()));	
			}
		}
		
		rowLine.add(M);
		colLine.add(N);
		
		int[] rowArr = new int[rowLine.size()];
		for(int i=0; i<rowLine.size(); i++) {
			rowArr[i] = rowLine.get(i);
		}
		
		int[] colArr = new int[colLine.size()];
		for(int i=0; i<colLine.size(); i++) {
			colArr[i] = colLine.get(i);
		}
		
		Arrays.sort(rowArr);
		Arrays.sort(colArr);
		
		int maxR = rowArr[0]; // 세로가 가장 넓은 종이의 세로 길이
		int maxC = colArr[0]; // 가로가 가장 넓은 종이의 가로 길이
		
		for(int i=0; i<rowArr.length-1; i++) {
			if(rowArr[i+1]-rowArr[i] > maxR) {
				maxR = rowArr[i+1]-rowArr[i];
			}
		}
		for(int j=0; j<colArr.length-1; j++) {
			if(colArr[j+1]-colArr[j] > maxC) {
				maxC = colArr[j+1]-colArr[j];
			}
		}
		
		int result = maxR * maxC;
		System.out.println(result);
		
	}

}