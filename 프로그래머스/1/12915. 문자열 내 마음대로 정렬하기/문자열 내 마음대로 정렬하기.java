import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2); // n번째 문자가 동일하면 전체 문자열 비교
                }
                return o1.charAt(n) - o2.charAt(n);
            }
        });
        return strings;
    }
}