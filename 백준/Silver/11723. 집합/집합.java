import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        Set<Integer> set = new HashSet<>();

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

            if(cmd.equals("add")) {
                set.add(x);
            } else if(cmd.equals("remove")) {
                set.remove(x);
            } else if(cmd.equals("check")) {
                bw.write(set.contains(x) ? "1\n" : "0\n");
            } else if(cmd.equals("toggle")) {
                if(set.contains(x)) {
                    set.remove(x);
                } else {
                    set.add(x);
                }
            } else if(cmd.equals("all")) {
                for(int j=0; j<=20; j++) {
                    set.add(j);
                }
            } else {
                set.clear();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
