import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int p = (int) ((-1*A) - Math.sqrt(A*A - B));
        int q = (int) ((-1*A) + Math.sqrt(A*A - B));

        if(p==q) {
            System.out.println(p);
        } else {
            System.out.println(p+" "+q);
        }
    }
}
