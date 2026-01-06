class Trie {
    Node root;
    Trie() {
        root=new Node();
    }

    void insert(String word) {
        Node curr=root;
        for(char ch:word.toCharArray()){
            if(!curr.contains(ch)){
                curr.put(ch,new Node());
            }
            curr=curr.get(ch);
        }
        curr.setEnd();
    }

    boolean search(String word) {
        Node curr=root;
        for(char ch:word.toCharArray()){
            if(!curr.contains(ch)){
                return false;
            }
            curr=curr.get(ch);
        }
        return curr.isEnd();
    }

    boolean startsWith(String prefix) {
        Node curr=root;
        for(char ch:prefix.toCharArray()){
            if(!curr.contains(ch)){
                return false;
            }
            curr=curr.get(ch);
        }
        return true;
    }
}
class Node{
    Node arr[];
    Node(){
        arr=new Node[26];
    }
    boolean contains(char ch){
        return arr[ch-'a']!=null;
    }
    void put(char ch,Node node){
            arr[ch-'a']=node;       
    }
    Node get(char ch){
        return arr[ch-'a'];
    }
    boolean flag=false;
    void setEnd(){
        flag=true;
    }
    boolean  isEnd(){
        return flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */