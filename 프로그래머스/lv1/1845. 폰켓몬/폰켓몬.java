import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int max = nums.length/2;
        
        Set<Integer> hs = new HashSet<>();
        
        for(int num : nums) {
            hs.add(num);
        }
        
        return hs.size() < max ? hs.size() : max;
    }
}