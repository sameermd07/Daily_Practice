import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String str[]=new String[n];
        Node root=new Node();
        for(int i=0;i<n;i++){
            str[i]=sc.next();
            insert(root,str[i]);
        }
        int q=sc.nextInt();
        while(q-->0){
            String word=sc.next();
            System.out.println(isthere(root,word));
        }
    }
    public static void insert(Node root,String str){
        Node temp=root;
        for(int i=str.length()-1;i>=0;i--){
            int idx=str.charAt(i)-'a';
            if(temp.children[idx]!=null){
                temp=temp.children[idx];
                temp.cnt=Math.max(temp.cnt,str.length());
            }else{
                Node x=new Node();
                temp.children[idx]=x;
                temp=temp.children[idx];
                temp.cnt=Math.max(temp.cnt,str.length());
            }
        }
    }

    public static int isthere(Node root,String pre){
        Node temp=root;
        for(int i=pre.length()-1;i>=0;i--){
            int idx=pre.charAt(i)-'a';
            if(temp.children[idx]==null){
                break;
            }else{
                temp=temp.children[idx];
            }
        }
        return temp.cnt;
    }
}
class Node{
    Node children[];
    int cnt;
    Node(){
        children=new Node[26];
        for(int i=0;i<26;i++){
            children[i]=null;
            cnt=0;
        }
    }
}