class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        HashMap<Integer,Integer>hm1=new HashMap<>();
        HashMap<Integer,Integer>hm2=new HashMap<>();
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==x){
                min=Math.min(min,i+1);
            }
            hm1.put(sum,i);
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=nums[i];
            if(sum==x){
                min=Math.min(min,n-i);
            }
            hm2.put(sum,i);
        }
        for(int key:hm1.keySet()){
            int req=x-key;
            if(hm2.containsKey(req)){
                if(hm1.get(key)<hm2.get(req)){
                    min=Math.min(min,n-hm2.get(req)+hm1.get(key)+1);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}