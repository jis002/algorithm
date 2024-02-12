import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] answers;
    static int[] numbers;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answers = new int[10];
        numbers = new int[10];
        for(int i=0; i<10; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        checkAnswers(0);

        System.out.println(ans);
    }

    static void checkAnswers(int idx) {
        if(idx == 10) {
            int cnt = 0;
            for(int i=0; i<10; i++) {
                if(i>=2 && numbers[i-2] == numbers[i-1] && numbers[i-1] == numbers[i]) return;
                if(numbers[i] == answers[i]) cnt++;
            }
            if(cnt >= 5) ans++;
            return;
        }

        for(int i=1; i<=5; i++) {
            numbers[idx] = i;
            checkAnswers(idx+1);
        }
    }

}
