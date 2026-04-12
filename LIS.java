class Solution {
     ArrayList<Integer>arr;
    public int LIS(int[] nums) {
       arr=new ArrayList<>();
        arr.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(arr.get(arr.size()-1)<nums[i]){
                arr.add(nums[i]);
            }else{
                int idx=binarySearch(0,arr.size()-1,nums[i]);
                arr.set(idx,nums[i]);
            }
        } 
        return arr.size();
    }
    public int binarySearch(int low,int high,int target){
        while(low<high){
            int mid=(low+high)/2;
            if(arr.get(mid)<target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return high;
    }
}

