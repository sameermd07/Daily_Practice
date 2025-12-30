class Solution {
    public void heapify(int[] nums, int ind, int val) {
        if(nums[ind]<val){
            nums[ind]=val;
            heapify_down(nums,ind);
        }else{
            nums[ind]=val;
            heapify_up(nums,ind);
        }
    }
    public void heapify_down(int nums[],int ind){
        int left=2*ind+1;
        int right=2*ind+2;
        int smallest=ind;
        if(left<nums.length && nums[left]<nums[smallest]){
            smallest=left;
        }
        if(right<nums.length && nums[right]<nums[smallest]){
            smallest=right;
        }
        if(smallest!=ind){
            int temp=nums[smallest];
            nums[smallest]=nums[ind];
            nums[ind]=temp;
            heapify_down(nums,smallest);
        }
    }
    void heapify_up(int nums[],int ind){
        int par=(ind-1)/2;
        if(par>=0 && nums[par]>nums[ind]){
            int temp=nums[par];
            nums[par]=nums[ind];
            nums[ind]=temp;
            heapify_up(nums,par);
        }
    }
}