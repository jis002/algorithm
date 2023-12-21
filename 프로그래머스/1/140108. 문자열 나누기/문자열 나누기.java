class Solution {
    
    static int answer;
    
    public int solution(String s) {
        answer = 0;
        divideString(s);
        
        return answer;
    }
    
    private void divideString(String s) {
        if(s.length() <= 0) {
            return;
        }
        if(s.length() <= 1) {
            answer++;
            return;
        }
        
        char first = s.charAt(0);
        int countA = 1;
        int countB = 0;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == first) {
                countA++;
            } else {
                countB++;
            }
            if(countA == countB) {
                answer++;
                String ns = s.substring(i+1);
                divideString(ns);
                break;
            }
        }
        if(countA != countB) {
            answer++;
            return;
        }
    }
}