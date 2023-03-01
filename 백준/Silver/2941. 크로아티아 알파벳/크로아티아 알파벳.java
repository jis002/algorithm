import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int i = str.length() - 1;
		int cnt = 0;
		
		while( i >= 0 ) {
			if( str.charAt(i) == '=' ) {
				if( i-1>=0 && (str.charAt(i-1) == 'c' || str.charAt(i-1) == 's') ) {
					i -= 2;
				} else if ( i-1>=0 && str.charAt(i-1) == 'z') {
					if ( i-2>=0 && str.charAt(i-2) == 'd') {
						i -= 3;
					} else {
						i -= 2;
					}
				}
			} else if( str.charAt(i) == '-') {
				i -= 2;
			} else if( str.charAt(i) == 'j') {
				if( i-1>=0 && (str.charAt(i-1) == 'l' || str.charAt(i-1) == 'n') ) {
					i -= 2;
				} else {
					i--;
				}
			} else {
				i--;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}