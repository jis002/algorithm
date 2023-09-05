import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> hm = new HashMap<>();

        for(String phone : phone_book) {
            hm.put(phone, 1);
        }
        
        outer: for(String phone : phone_book) {    
            String tmp = "";
            for(int i=0; i<phone.length()-1; i++) {
                tmp += phone.charAt(i);
                if(hm.containsKey(tmp)) {
                    answer = false;
                    break outer;
                }
            }
        }
        
        return answer;
    }
}