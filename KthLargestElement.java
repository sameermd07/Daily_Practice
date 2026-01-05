class Solution {
    public int kthLargestElement(int[] nums, int k) {
        
        for(int i=(nums.length/2)-1;i>=0;i--){
            helper(nums,i);
        }
        for(int i=1;i<=k;i++){
            int temp=nums[nums.length-i];
            nums[nums.length-i]=nums[0];
            nums[0]=temp;
        // System.out.println(nums.length-i);
            helper2(nums,0,i);
        }
        // System.out.println(Arrays.toString(nums));
        return nums[nums.length-k];
    }
    public void helper(int nums[],int i){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left<nums.length && nums[left]>nums[i]){
            largest=left;
        }
        if(right<nums.length && nums[right]>nums[largest]){
            largest=right;
        }
        if(largest!=i){
            // System.out.println(nums[largest]+" "+largest);
            int temp=nums[largest];
            nums[largest]=nums[i];
            nums[i]=temp;
            // System.out.println(Arrays.toString(nums));
            helper(nums,largest);
        }
    }
    public void helper2(int nums[],int i,int k){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left<nums.length-k && nums[left]>nums[i]){
            largest=left;
        }
        if(right<nums.length-k && nums[right]>nums[largest]){
            largest=right;
        }
        if(largest!=i){
            // System.out.println(nums[largest]+" "+largest);
            int temp=nums[largest];
            nums[largest]=nums[i];
            nums[i]=temp;
            // System.out.println(Arrays.toString(nums));
            helper2(nums,largest,k);
        }
    }
}