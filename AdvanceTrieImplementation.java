class Trie {
    node root;
    int maxlen=Integer.MIN_VALUE;
    public Trie() {
        root=new node();
    }

    public void insert(String word) {
        node curr=root;
        for(char ch:word.toCharArray()){
            if(!curr.contains(ch)){
                curr.put(ch,new node());
            }
            curr=curr.arr[ch-'a'];
            curr.incrS();
        }
        // curr.incrS();
        curr.incrW();
        curr.setEnd();
    }

    public int countWordsEqualTo(String word) {
        node curr=root;
        for(char ch:word.toCharArray()){
            if(!curr.contains(ch)){
                return 0;
            }
            curr=curr.arr[ch-'a'];
        }
        return curr.cnt2;
    }

    public int countWordsStartingWith(String prefix) {
        node curr=root;
        for(char ch:prefix.toCharArray()){
             if(!curr.contains(ch)){
                return 0;
            }
            curr=curr.arr[ch-'a'];
        }
        return curr.cnt1;
    }

    public void erase(String word) {
        node curr=root;
        if(countWordsEqualTo(word)==0) return;
        for(char ch:word.toCharArray()){
            curr=curr.arr[ch-'a'];
            curr.cnt1-=1;
        }
        // curr.cnt1-=1;
        curr.cnt2-=1;
        // if (curr.cnt2 == 0) {
        //     curr.flag = false;
        // }
    }
}
class node{
    node arr[];
    int cnt1,cnt2;
    boolean flag=false;
    node(){
        arr=new node[26];
        cnt1=0;
    }
    void incrS(){
        cnt1++;
    }
    void incrW(){
        cnt2++;
    }
    boolean contains(char ch){
        return arr[ch-'a']!=null;
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
    void put(char ch,node curr){
        arr[ch-'a']=curr; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
