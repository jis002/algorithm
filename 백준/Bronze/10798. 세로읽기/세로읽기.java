/* 배열로 풀어보기 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		char [][] arr = new char[5][15];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0; j<15; j++) {			
				if(j<ch.length) {
					arr[i][j] = ch[j];
				} else {
					arr[i][j] = '#';
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<15; j++) {
			for(int i=0; i<5; i++) {
				if(arr[i][j] != '#')
				sb.append(arr[i][j]);
			}	
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();

	}

}