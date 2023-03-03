import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = new int[1001];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxH = Integer.MIN_VALUE; // 가장 높은 기둥 높이
		List<Integer> maxList = new ArrayList<Integer>(); // 가장 높은 기둥의 인덱스를 담는 배열
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			arr[idx] = height;
			if(height >= maxH) {
				maxH = height;
				
				if(!maxList.isEmpty()) {
					if( arr[maxList.get(maxList.size()-1)] < maxH ) {
						maxList.clear();
					}
				}
				maxList.add(idx);
				
			}	
		}
		maxList.sort(null);
		
		int maxFirst = maxList.get(0); // 첫 번째 가장 높은 기둥
		int maxLast = maxList.get(maxList.size()-1); // 마지막 가장 높은 기둥
		int start = 0; // 0이 아닌 기둥을 만난 시작점
		int cur = 0; // 현 위치 
		int sum = 0; // 면적 합계
		
		// 가장 높은 층 좌측의 면적
		while(cur < maxFirst) {
			if(arr[cur] == 0) cur++;
			else {
				start = cur;
				while(arr[start]>=arr[cur]) {
					cur++;
				}
				sum += (cur-start)*arr[start];
			}
		}
		
		// 가장 높은 층 면적 더하기
		sum += maxH*(maxLast-maxFirst+1);
		
		// 가장 높은 층 우측의 면적
		cur = arr.length-1;
		while(cur > maxLast) {
			if(arr[cur] == 0) cur--;
			else {
				start = cur;
				while(arr[start]>=arr[cur]) {
					cur--;
				}
				sum += (start-cur)*arr[start];
			}
		}

		System.out.println(sum);
		
	}

}