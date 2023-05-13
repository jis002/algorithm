import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int answer = 0;
        
        // cacheSize가 0 인 경우 바로 return 
        if(cacheSize == 0) {
            return cities.length * 5; 
        }
        
        Queue<String> q = new LinkedList<>();
        for(int i=0; i<cities.length; i++) {
            q.add(cities[i].toLowerCase());
        }
        
        List<String> list = new ArrayList<>();
        list.add(q.poll());
        answer += 5;
        
        //도시를 모두 확인
        while(!q.isEmpty()) {
            if(q.isEmpty()) break; 
            String city = q.poll();            
            boolean miss = true;
            
            for(int i=0; i<list.size(); i++) {    
                if(list.get(i).equals(city)) {
                    list.remove(i);
                    list.add(city);
                    answer++;
                    miss = false;
                    break;
                }
            }

            if(miss) {
                if(list.size() == cacheSize) {
                    list.remove(0);    
                }             
                list.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}