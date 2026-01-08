class Solution {
    public int countDistinctSubstring(String s) {
        //your code goes here
        int count=0;
        node root=new node();
        for(int i=0;i<s.length();i++){
            node curr=root;
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                if(!curr.contains(s.charAt(j))){
                    curr.arr[ch-'a']=new node();
                    count++;
                }
                curr=curr.arr[ch-'a'];
            }
        }
        return count+1;
    }
}
class node {
    node arr[];
    boolean isend;
    node(){
        arr=new node[26];
        isend=false;
    }
    boolean contains(char ch){
        return arr[ch-'a']!=null;
    }
}