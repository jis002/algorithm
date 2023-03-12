import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int cnt = 1;
		while(!q.isEmpty()) {
			if(cnt%K!=0) {
				q.offer(q.poll());
				cnt++;
			} else {
				sb.append(q.poll()).append(", ");
				cnt++;
			}
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}