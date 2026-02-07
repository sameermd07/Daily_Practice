class Solution {
    Boolean dp[][];
    public boolean equalPartition(int n, int[] arr) {
        int target=0;
      for(int i=0;i<n;i++){
        target+=arr[i];
      }
      if(target%2!=0) return false;
      dp=new Boolean[arr.length][target+1];
      return helper(0,0,arr,target/2);
    }
    public boolean helper(int i,int sum,int arr[],int target){
        if(sum==target){
            return true;
        }
        if(i==arr.length || sum>target){
            return false;
        }
        
        if(dp[i][sum]!=null){
            return dp[i][sum];
        }
        boolean left=helper(i+1,sum+arr[i],arr,target);
        boolean right=helper(i+1,sum,arr,target);
        dp[i][sum]=left||right;
        return dp[i][sum];
    }
}

