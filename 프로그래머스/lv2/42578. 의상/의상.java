import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1. hashMap을 만들어 key에 의상종류, value에 의상 이름 담기
        // 2. 의상 종류별 의상 개수 세기
        // 3. 2를 토대로 경우의 수 도출
        
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], new ArrayList<String>()));
            hm.get(cloth[1]).add(cloth[0]);
        }
        
        int answer = 1;
        
        for(Map.Entry<String, List<String>> entry : hm.entrySet()) {
            answer *= (entry.getValue().size()+1);
        }
        
        return answer-1;
    }
}