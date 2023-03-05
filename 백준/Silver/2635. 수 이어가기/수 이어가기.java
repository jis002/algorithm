import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> answer = new ArrayList<Integer>();
		
		int max = Integer.MIN_VALUE;
		
		for(int i=n/2; i<=n; i++) {
			list.add(n);
			list.add(i);
			
			while(true) {
				int tmp = list.get(list.size()-2)-list.get(list.size()-1);
				if(tmp < 0) {
					break;
				} else {
					list.add(tmp);
				}
			}
			
			if(list.size() > max) {
				max = list.size();
				answer.clear();
				answer.addAll(list);
			}
			list.clear();
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()).append("\n");
		for(int val : answer) {
			sb.append(val+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}