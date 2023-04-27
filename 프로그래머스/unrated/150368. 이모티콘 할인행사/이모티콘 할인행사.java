class Solution {
    static int N,M,maxRegist, maxRevenue;
    static int[] sales,Emoticons;
    static int[][] Users;
    public int[] solution(int[][] users, int[] emoticons) {
        N = emoticons.length;
        M = users.length;
        sales = new int[N];
        
        Users=users;
        Emoticons=emoticons;
        maxRegist = 0;
        maxRevenue = 0;
        
        func(0);
        
        int[] answer = {maxRegist,maxRevenue};
        return answer;
    }
    
    public void func(int idx){
        if(idx==N){
            run();
            return;
        }
        for(int i=10;i<=40;i+=10){
            sales[idx]=i;
            func(idx+1);
        }
    }
    
    public void run(){
        int revenue = 0;
        int regist = 0;
        for(int i=0;i<M;i++){
            int a = Users[i][0];
            int b = Users[i][1];
            int temp = 0;
            for(int j=0;j<N;j++){
                if(sales[j]>=a) temp+=Emoticons[j]*(100-sales[j])/100;
                if(temp>=b){
                    temp = 0;
                    regist++;
                    break;
                }
            }
            revenue+=temp;
        }
        if(regist>maxRegist){
            maxRegist=regist;
            maxRevenue=revenue;
        }
        if(regist==maxRegist) maxRevenue=Math.max(maxRevenue,revenue);
    }
}