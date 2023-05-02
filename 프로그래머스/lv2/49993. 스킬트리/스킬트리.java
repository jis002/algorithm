import java.util.*;

class Solution {
    
    static int answer;
    static List<Integer>[] tree;

    public int solution(String skill, String[] skill_trees) {
        
        char[] temp = skill.toCharArray();
        int[] arr = new int[temp.length];
        for(int i=0; i<temp.length; i++) {
            arr[i] = temp[i]-65;
        }
        
        String[] skillTrees = Arrays.copyOf(skill_trees, skill_trees.length);
        
        // tree 배열 초기화
        tree = new ArrayList[26];
        for(int i=0; i<26; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // tree 입력 받기
        int[] in = new int[26];
        for(int i=1; i<arr.length; i++) {
            tree[arr[i-1]].add(arr[i]);
            in[arr[i]]++;
        }
        
        answer = 0;
        
        for(String str : skillTrees) {
            int[] inCopy = Arrays.copyOf(in, in.length);
            topology(str, inCopy);
        }
        
        return answer;
    }
    
    
    public void topology(String str, int[] in) {
        boolean flag = true;
        for(int i=0; i<str.length(); i++) {
            int curr = str.charAt(i) - 65;
            if(in[curr] != 0) {
                flag = false;
                break;
            }
            for(int next : tree[curr]) {
                --in[next];
            }
        }
        if(flag) {
            answer++;
        }
    }
    
}