class Solution {
    node root=new node();
    public String completeString(List<String> nums) {
        //your code goes here
        String s="";
        int maxlen=Integer.MIN_VALUE;
        for(String i:nums){
            insert(i);
        }
        for(String i:nums){
            if(isExists(i)){
                if (i.length() > maxlen ||
   (i.length() == maxlen && i.compareTo(s) < 0)) {
    s = i;
    maxlen = i.length();
}

            }
        }
        return s;
    }
    public void insert(String word){
        node curr=root;
        for(char ch:word.toCharArray()){
            if(!curr.contains(ch)){
                curr.arr[ch-'a']=new node();
            }
            curr=curr.arr[ch-'a'];
        }
        curr.isend=true;
    }
    public boolean isExists(String word){
        node curr=root;
        for(char ch:word.toCharArray()){
            if(!curr.contains(ch)){
                return false;
            }
            curr=curr.arr[ch-'a'];
            if(!curr.isend){
                return false;
            }
        }
        return true;
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