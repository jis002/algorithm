import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int[][] ingredients;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingredients = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken()); // 신맛
            ingredients[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        ans = Integer.MAX_VALUE;
        cook(0, 1, 0);

        System.out.println(ans);

    }

    private static void cook(int idx, int sour, int bitter) {
        if(idx == N) {
            if(sour != 1 && bitter != 0) { // 최소 1개 선택
                ans = Math.min(ans, Math.abs(sour-bitter));
            }
            return;
        }

        // 재료 선택함
        cook(idx+1, sour*ingredients[idx][0], bitter+ingredients[idx][1]);
        // 재료 선택안함
        cook(idx+1, sour, bitter);
    }
}
