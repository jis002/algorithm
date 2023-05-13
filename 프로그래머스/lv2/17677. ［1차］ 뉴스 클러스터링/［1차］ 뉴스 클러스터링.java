import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        int answer = 0;
        
        char[] char1 = str1.toLowerCase().toCharArray();
        char[] char2 = str2.toLowerCase().toCharArray();
        
        // 다중집합
        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();
        
        for(int i=0; i<char1.length-1; i++) {
            if('a'-0 <= char1[i] && char1[i] <= 'z'-0 && 'a'-0 <= char1[i+1] && char1[i+1] <= 'z'-0) {
                String temp = Character.toString(char1[i]).concat(Character.toString(char1[i+1]));
                set1.add(temp);
            }
        }
        for(int i=0; i<char2.length-1; i++) {
            if('a'-0 <= char2[i] && char2[i] <= 'z'-0 && 'a'-0 <= char2[i+1] && char2[i+1] <= 'z'-0) {
                String temp = Character.toString(char2[i]).concat(Character.toString(char2[i+1]));
                set2.add(temp);
            }
        }
        
        //모두 공집합인 경우 유사도 = 1
        if(set1.size()==0 && set2.size()==0) {
            answer = 65536;
            return answer;
        }
        

        float intersect = 0F;  // 교집합 개수
        float union = 0F;  // 합집합 개수        
        
        for(int i=0; i<set1.size(); i++) {
            for(int j=0; j<set2.size(); j++) {
                if(set1.get(i).equals(set2.get(j))) {
                    set2.remove(j);
                    intersect++;
                    break;
                }     
            }
        }
        
        union = set1.size() + set2.size();
        // System.out.println("inter "+intersect);
        // System.out.println("union "+union);
        
        float za = intersect/union;
        answer = (int)(za * 65536);
        return answer;
    }
}