import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int cntA, cntB, cntC;
        cntA = cntB = cntC = 0;
        int[] arrA = {1, 2, 3, 4, 5};
        int[] arrB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arrC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == arrA[i%arrA.length]) {
                cntA++;
            }
            if(answers[i] == arrB[i%arrB.length]) {
                cntB++;
            }
            if(answers[i] == arrC[i%arrC.length]) {
                cntC++;
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        
        int maxCnt = Math.max(cntA, Math.max(cntB, cntC));
        
        if(maxCnt == cntA) {
            resultList.add(1);
        }
        if(maxCnt == cntB) {
            resultList.add(2);
        }
        if(maxCnt == cntC) {
            resultList.add(3);
        }
        
        int[] answer = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}