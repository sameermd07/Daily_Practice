import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[]=new int[n];
            PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->(b-a));
            for(int i=0;i<n;i++){
                pq.offer(sc.nextInt());
            }
            int cnt=0;
            boolean found=false;
            while(!pq.isEmpty()){
                int ar=pq.poll();
                k-=ar;
                ar/=2;
                cnt++;
                if(ar>0){
                    pq.offer(ar);
                }
                if(k<=0){
                    found=true;
                    break;
                }
            }
            if(found){
                System.out.println(cnt);
            }else{
                System.out.println(-1);
            }
        }
    }
}