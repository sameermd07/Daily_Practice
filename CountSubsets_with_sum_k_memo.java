class Solution {
    int dp[][];
    int mod=(int)1e9+7;
    public int perfectSum(int[] arr, int K) {
        dp=new int[arr.length][K+1];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,arr,K,0);
    }
    public int helper(int i,int arr[],int k,int sum){
        if(sum==k){
            return 1;
        }

        if(i==arr.length || sum>k){
            return 0;
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum]%mod;
        }
        dp[i][sum]=helper(i+1,arr,k,sum+arr[i])+helper(i+1,arr,k,sum);
        return dp[i][sum]%mod;
    }
}

