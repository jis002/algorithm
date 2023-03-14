import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> hash = new HashMap<>();
		for(int i=0; i<N; i++) {
			hash.put(br.readLine(), 1);
		}
		
		List<String> list = new ArrayList<>();
		for(int j=0; j<M; j++) {
			String x = br.readLine();
			if(hash.containsKey(x)) {
				list.add(x);
			}
		}
		list.sort(null);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(list.size() + "\n");
		for(String s : list) {
			bw.write(s);
			bw.newLine();
		}
		
		bw.close();
		br.close();
		
	}

}