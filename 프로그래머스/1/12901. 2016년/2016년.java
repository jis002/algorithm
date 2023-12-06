class Solution {
    public String solution(int a, int b) {
        
        String answer = "";
        int[] daysOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int days = b;
        for(int i=1; i<a; i++) {
            days += daysOfMonth[i];
        }
        
        if(days % 7 == 0) {
            answer = "THU";
        } else if(days % 7 == 1) {
            answer = "FRI";
        } else if(days % 7 == 2) {
            answer = "SAT";
        } else if(days % 7 == 3) {
            answer = "SUN";
        } else if(days % 7 == 4) {
            answer = "MON";
        } else if(days % 7 == 5) {
            answer = "TUE";
        } else {
            answer = "WED";
        }
        
        return answer;
    }
}