class Solution {
    public String solution(int a, int b) {
        
        String answer = "";
        int[] daysOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int days = b;
        for(int i=1; i<a; i++) {
            days += daysOfMonth[i];
        }
        
        int d = days % 7;
        answer = dayOfWeek[d];
        
        return answer;
    }
}