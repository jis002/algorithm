import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			int cnt = 0;
			outer: for(int w=0; w<W; w++) {
				for(int h=0; h<H; h++) {
					++cnt;
					
					if(cnt==N) {
						sb.append(h+1);
						if(w+1<10) {
							sb.append(0).append(w+1);
						} else {
							sb.append(w+1);
						};
						break outer;
					}
				}
			}
			System.out.println(sb.toString());
		}

	}

}