import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarves = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++) {
            int height = Integer.parseInt(br.readLine());
            dwarves[i] = height;
            sum += height;
        }
        Arrays.sort(dwarves);

        outer: for(int i=0; i<8; i++) {
            for(int j=i; j<9; j++) {
                if(i!=j && sum - dwarves[i] - dwarves[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) System.out.println(dwarves[k]);
                    }
                    break outer;
                }
            }
        }

    }
}
