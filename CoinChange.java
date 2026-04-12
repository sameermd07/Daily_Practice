class Solution {
    int mod=(int)1e9+7;
    int dp[][];
    public int count(int coins[],int n, int amount) {
        dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int x=helper(coins.length-1,amount,coins)%mod;
        if(x==mod){
            return -1;
        }
        return x;
    }
    int helper(int i,int amount,int arr[]){
        if(i<0){
            if(amount==0){
                return 1;
            }
            return 0;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int take=0;
        if(arr[i]<=amount){
            take=(helper(i,amount-arr[i],arr)%mod);
        }
        int notTake=(helper(i-1,amount,arr)%mod);
        return dp[i][amount]=(take+notTake)%mod;
    }
}

