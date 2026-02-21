class Solution {
    int dp[][];
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        dp=new int[n][W+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,wt,val,n,W);
    }

    public int helper(int i,int wt[],int val[],int n,int W){
        if(i==n){
            return 0;
        }
        if(dp[i][W]!=-1) return dp[i][W];
        int notTake=helper(i+1,wt,val,n,W);
        int take=0;
        if(wt[i]<=W){
            take=val[i]+helper(i,wt,val,n,W-wt[i]);
        }
        return dp[i][W]=Math.max(take,notTake);
    }
}
