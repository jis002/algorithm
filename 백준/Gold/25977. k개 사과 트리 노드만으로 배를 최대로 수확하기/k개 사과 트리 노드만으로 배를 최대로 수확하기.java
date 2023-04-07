import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int max; // 수확 가능한 배의 개수 최대값
	static List<Integer>[] list; // 노드 연결관계를 담는 리스트
	static int[] type; // 각 노드의 과일타입을 담는 배열. 0:없음, 1:사과, 2:배
	
	static int[] selectedApple; // 방문하기로 결정한 사과 조합
	static List<Integer> apples; // 사과 노드가 담긴 리스트
	static int cnt; // 각 사과 조합에서 수확 가능한 배의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 각 노드별 연결된 노드 입력 받기
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[p].add(v);
		}
		
		Set<Integer> set = new HashSet<>(); // 사과 노드가 담긴 집합
		// 각 노드의 과일 타입 입력 받기
		type = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			type[i] = Integer.parseInt(st.nextToken());
			if(type[i]==1) {
				set.add(i);
			}
		}
		// 사과 노드가 담긴 리스트 
		apples = new ArrayList<>();
		for(int node : set) {
			apples.add(node);
		}
		
		max = Integer.MIN_VALUE;
		
		// 방문할 사과노드 조합을 선택한다 
		int pear = 0;
		if(apples.size()>K) { // 사과노드가 K개를 초과하는 경우 사과 노드 조합 고르기
			if(type[0]==1) { // 0번 노드가 사과인 경우, 0을 포함하여 K개의 사과 노드 조합 만들기
				selectedApple = new int[K];
				selectedApple[0] = 0;
				combination(1, 1, K);
			} else { // 0번 노드가 사과가 아닌 경우, K개의 사과 노드 조합 만들기 
				selectedApple = new int[K];
				combination(0, 0, K);
			}
		} else { // 사과노드가  K개 이하면 배 개수 바로 구하기
			for(int i : type) {
				if(i==2) pear++;
			}
		}
		
		max = Math.max(max, pear);		
		System.out.println(max);
		
		
	} //main

	
	// 방문할 사과 노드 조합 구하기
	// idx : 사과list내 인덱스
	// sidx : 사과노드 선택할 자리
	// smax : 사과노드 최대 선택 가능한 개수
	private static void combination(int idx, int sidx, int smax) {
		if(sidx == smax) {
			cnt = 0;
			if(type[0]==2) {
				cnt++;
			}
			dfs(0);
			max = Math.max(max, cnt);
			return;
		}
		if(idx==apples.size()) {
			return;
		}
		
		selectedApple[sidx] = apples.get(idx);
		// 선택함
		combination(idx+1, sidx+1, smax);
		// 선택하지 않음
		combination(idx+1, sidx, smax);
	}


	// 방문할 사과 노드가 정해지면, 수확 가능한 배 개수 구하기
	private static void dfs(int curr) {

		for(int next : list[curr]) {
			if(type[next]==2) {
				cnt++;
				dfs(next);
			} else if(type[next]==0) {
				dfs(next);
			} else if(type[next]==1) {
				for(int s : selectedApple) {
					if(next == s) {
						dfs(next);
					}
				}
			}
		}
		
	}

	
}