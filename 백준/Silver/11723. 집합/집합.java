import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Set<Integer> set = new HashSet<>();
		Set<Integer> setFull = new HashSet<>();
		for(int i=1; i<=20; i++) {
			setFull.add(i);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x = 0;
			
			if(st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());
			}
			
			switch (cmd) {
			case "add":
				set.add(x);
				break;
			case "remove":
				if(!set.isEmpty()) set.remove(x);
				break;
			case "check":
				if(set.contains(x)) bw.write("1");
				else bw.write("0");
				bw.newLine();
				break;
			case "toggle":
				if(set.contains(x)) set.remove(x);
				else set.add(x);
				break;
			case "all":
				set = setFull;
				break;
			case "empty": 
				set.clear();
				break;
			}
		}
		
		bw.close();
		br.close();
	} 

}