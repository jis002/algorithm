import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = {0, 0};
        
        int m = words.length; // 전체 단어 수
        Set<String> set = new HashSet<>();
        int size = 1; // set의 사이즈
        set.add(words[0]);
        char last = words[0].charAt(words[0].length()-1);
        
        int num = 0;
        int turn = 0;
        
        for(int i=1; i<m; i++) {
            set.add(words[i]);
            if(set.size()==size || last!=words[i].charAt(0)) {
                num = i%n+1;
                turn = i/n+1;
                break;
            } else {
                last = words[i].charAt(words[i].length()-1);
                ++size;
            }
        }
        
        if(num!=0) {
            answer[0] = num;
            answer[1] = turn;
        } 
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}