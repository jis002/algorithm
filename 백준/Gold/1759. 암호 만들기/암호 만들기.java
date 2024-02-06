import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int L;
    static int C;
    static String[] alphabets;
    static StringBuilder password;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = br.readLine().split(" ");
        Arrays.sort(alphabets);

        password = new StringBuilder();
        combination(0, 0, 0);
    }

    // moCnt: 선택한 모음의 수, jaCnt: 선택한 자음의 수
    private static void combination(int cur, int moCnt, int jaCnt) {
        if(moCnt + jaCnt == L) {
            if(moCnt >= 1 && jaCnt >=2) {
                System.out.println(password);
            }
            return;
        }
        if(cur == C) return;

        // 선택하는 경우
        if(alphabets[cur].equals("a") || alphabets[cur].equals("e") || alphabets[cur].equals("i") || alphabets[cur].equals("o") || alphabets[cur].equals("u")) {
            // 모음 선택
            password.append(alphabets[cur]);
            combination(cur+1, moCnt+1, jaCnt);
        } else {
            // 자음 선택
            password.append(alphabets[cur]);
            combination(cur+1, moCnt, jaCnt+1);
        }

        // 선택하지 않는 경우
        password.deleteCharAt(password.length()-1);
        combination(cur+1, moCnt, jaCnt);
    }

}
