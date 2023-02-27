// stack 2개로 풀기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.length();
		// 리스트로 문자 입력 받기
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for(int i=0; i<n; i++) {
			left.push(str.charAt(i));
		}
		
		int cursor = n; // 커서의 현재 위치
		int M = Integer.parseInt(br.readLine()); // 명령어의 개수
		
		while(M>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String type = st.nextToken(); // 명령 유형
			
			if(type.equals("L")) {
				// 왼쪽 원소를 하나 오른쪽으로 옮김.
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
			} else if(type.equals("D")) {
				// 오른쪽 원소를 하나 왼쪽으로 옮김.
				if(!right.isEmpty()) {
					left.push(right.pop());
				}
			} else if(type.equals("B")) {
				// 왼쪽 원소 하나 삭제
				if(!left.isEmpty()) {
					left.pop();
				}
			} else { // type = P
				char input = st.nextToken().charAt(0);
				// input을 커서 왼쪽 스택에 추가
				left.push(input);
			}
		
			// 명령을 1회 수행할 때마다 M이 1씩 줄어든다
			M--;
		}

		
		// 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while(!left.isEmpty()) {
			sb.append(left.pop());
		}
		sb.reverse(); // 왼쪽 스택에서 받은 건 좌우반전
		
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}