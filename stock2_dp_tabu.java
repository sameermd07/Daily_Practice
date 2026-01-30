class Solution {
    public int stockBuySell(int[] arr, int n) {
        int sum=0;
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]>0){
                sum+=arr[i]-arr[i-1];
            }
        }
        return sum;
    }
}

