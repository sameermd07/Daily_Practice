class Solution {
    int mod=(int)1e9+7;
    int dp[][];
 public int countPartitions(int n, int diff, int[] arr) {
        int totSum=0;
        for(int i=0;i<n;i++){
            totSum+=arr[i];
        }
        if((totSum+diff)%2!=0){
            return 0;
        }
        int target=(totSum+diff)/2;
        dp=new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,arr,target,0);
    }
    public int helper(int i,int arr[],int k,int sum){
        if(i==arr.length){
            if(sum==k){
                return 1;
            }else{
                return 0;
            }
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
