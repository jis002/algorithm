import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] map;	
	static int[] arr;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			arr = new int[N];
			min = Integer.MAX_VALUE;
			
			powerSet(0);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+" "+min+"\n");
			bw.write(sb.toString());
			bw.flush();
		}
		
	}

	private static void powerSet(int idx) {
		if(idx == N) {
			int cnt=0;
			List<Integer> listA = new ArrayList<>();
			List<Integer> listB = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(arr[i]==1) {
					cnt++;
					listA.add(i);
				} else {
					listB.add(i);
				}
			}
			if(cnt==N/2) {
				int differ = getDifference(listA, listB);
				min = Math.min(differ, min);
			}
			return;
		}
		
		arr[idx] = 1;
		powerSet(idx+1);
		arr[idx] = 0;
		powerSet(idx+1);
	}

	private static int getDifference(List<Integer> listA, List<Integer> listB) {
		int synergyA = getSynergy(listA);		
		int synergyB = getSynergy(listB);
		return Math.abs(synergyA-synergyB);
	}

	private static int getSynergy(List<Integer> list) {
		int c = list.size();
		int sum = 0;
		for(int i=0; i<c-1; i++) {
			for(int j=i+1; j<c; j++) {
				int x = list.get(i);
				int y = list.get(j);
				sum += map[x][y];
				sum += map[y][x];
			}
		}
		return sum;
	}

}