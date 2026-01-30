class Solution {
    public int stockBuySell(int[] arr, int n) {
        int min_price=arr[0];
        int max_profit=0;
        for(int i=1;i<n;i++){
            if(arr[i]-min_price>0){
                max_profit=Math.max(max_profit,arr[i]-min_price);
            }
            min_price=Math.min(min_price,arr[i]);
        }
        return max_profit;
    }
}