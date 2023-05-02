import java.util.*;

class Solution {
    
    public int[] solution(String today, String[] terms, String[] privacies) {

        String[] todayS = today.split("\\.|\\s");
        int todayN = Integer.parseInt(todayS[0])*10000
                    + Integer.parseInt(todayS[1])*100 
                    + Integer.parseInt(todayS[2]);
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
            String[] temp = terms[i].split(" ");            
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++) {
            String[] temp = privacies[i].split("\\.|\\s");
            
            int month = Integer.parseInt(temp[1]) + map.get(temp[3]);
            int yearAdd = 0;
            int monthAdd = month%12;
            
            if(month > 12) {
                yearAdd = month/12;
                if(month%12 == 0) {
                    yearAdd--;
                    monthAdd = 12;
                }
            } else if(month == 12) {
                monthAdd = month;
            }
            
            int expireDay = (Integer.parseInt(temp[0]) + yearAdd) * 10000
                        + monthAdd * 100 
                        + Integer.parseInt(temp[2]);
            
            System.out.println(expireDay);
            
            if(todayN >= expireDay) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}