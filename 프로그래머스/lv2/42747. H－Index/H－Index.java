// 1. idx가 인용횟수인 count 배열을 만든다 (크기 100001)
// 2. citations를 순회하면서 count 배열을 업데이트

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        int[] count = new int[10001];
        
        for(int i=0; i<n; i++) {
            count[citations[i]]++;     
        }
        
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(n-sum >= i) {
                answer = i;
            }
            sum += count[i];
        }
        
        if(sum==0) answer = n;
                
        return answer;
    }
}