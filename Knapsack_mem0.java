class Solution {
    int dp[][];
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        dp=new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int x=helper(n-1,wt,val,n,W);
        // for(int i=0;i<=n;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return x;
    }
    public int helper(int i,int wt[],int val[],int n,int W){
        if(i==0){
            if(wt[0]<=W){
                return val[0];
            }else{
                return 0;
            }
        }
        if(W==0){
            return 0;
        }
        if(dp[i][W]!=-1) return dp[i][W];
        int take=0;
        if(wt[i]<=W){
            take=val[i]+helper(i-1,wt,val,n,W-wt[i]);
        }
        int notTake=helper(i-1,wt,val,n,W);
        return dp[i][W]=Math.max(take,notTake);
    }
}
