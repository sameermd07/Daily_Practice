class Solution {
    int mod=(int)1e9+7;
    public int targetSum(int n, int target, int[] arr) {
        int tot_sum=0;
        for(int i=0;i<n;i++){
            tot_sum+=arr[i];
        }
        int x=target+tot_sum;
        if(x%2!=0){
            return 0;
        }
        int dp[][]=new int[n][10000];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,arr,x/2,0,dp);
    }
    public int helper(int i,int arr[],int target,int sum,int dp[][]){
        if(i==arr.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }
        if(sum>target){
            return 0;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        dp[i][sum]=helper(i+1,arr,target,sum+arr[i],dp)%mod+helper(i+1,arr,target,sum,dp)%mod;
        return dp[i][sum]%mod;
    }
}

