import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n+1];
        int[] B = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int ap = 0; // A배열 포인터
        int bp = 0; // B배열 포인터
        StringBuilder sb = new StringBuilder();

        while(ap < n && bp < m) {

            while(A[ap] <= B[bp]) {
                sb.append(A[ap++]).append(" ");
                if(ap >= n) break;
            }

            while(A[ap] >= B[bp]) {
                sb.append(B[bp++]).append(" ");
                if(bp >= m) break;
            }
        }
        
        // 남은 숫자 처리
        while(ap < n) {
            sb.append(A[ap++]).append(" ");
        }
        while(bp < m) {
            sb.append(B[bp++]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
