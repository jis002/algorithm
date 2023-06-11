import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			switch (com) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				list.add(x);
				break;
			case "pop":
				if(list.size()>0) {
					System.out.println(list.get(0));
					list.remove(0);
				} else {
					System.out.println("-1");
				}
				break;
			case "size":
				System.out.println(list.size());
				break;
			case "empty":
				if(list.size()>0) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
				break;
			case "front":
				if(list.size()>0) {
					System.out.println(list.get(0));
				} else {
					System.out.println("-1");
				}
				break;
			case "back":
				if(list.size()>0) {
					System.out.println(list.get(list.size()-1));
				} else {
					System.out.println("-1");
				}
				break;
			}
		}
	}
}