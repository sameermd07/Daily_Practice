class Solution {
    node root=new node();
    int max=Integer.MIN_VALUE;
    public int findMaximumXOR(int[] nums) {
        for(int i:nums){
            insert(i);
        }
        for(int i:nums){
            find(i);
        }
        return max;
    }
        void insert(int ele){
            node curr=root;
            for(int i=31;i>=0;i--){
                int x;
                if(((1<<i)&ele)!=0){
                    x=1;
                }else{
                    x=0;
                }
                if(!curr.contains(x)){
                    curr.arr[x]=new node();
                }
                curr=curr.arr[x];
            }
        }
        void find(int ele){
            node curr=root;
            for(int i=31;i>=0;i--){
                int x;
                int y;
                if(((1<<i)&ele)!=0){
                    x=1;
                    y=0;
                }else{
                    x=0;
                    y=1;
                }
                if(curr.contains(y)){
                    ele=ele^(y<<i);
                    curr=curr.arr[y];
                }else{
                    ele=ele^(x<<i);
                    curr=curr.arr[x];
                }
            }
            max=Math.max(max,ele);
        }
}
class node {
    node arr[];
    node(){
        arr=new node[2];
    }
    boolean contains(int x){
        return arr[x]!=null;
    }
}