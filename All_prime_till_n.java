class Solution {
        public ArrayList<Integer> primeTillN(int n) {
            //your code goes here
            int prime[]=new int[n+1];
            Arrays.fill(prime,1);
            for(int i=2;i<=n;i++){
                if(prime[i]==1){
                    helper(i,n,prime);
                }
            }
            ArrayList<Integer> nums=new ArrayList<>();
            for(int i=2;i<=n;i++){
                if(prime[i]==1) nums.add(i);
            }
            return nums;
        }
        public void helper(int x,int n,int prime[]){
            // int i=2;
            for(int i=2;i<=n;i++){
                if(x*i>n) break;
                prime[x*i]=0;
            }
        }
}
