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
            PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(b[1]-a[1]==0?a[0]-b[0]:b[1]-a[1]));
            for(int i=0;i<n;i++){
                pq.offer(new int[]{i,sc.nextInt()});
            }
            // System.out.println(Arrays.toString(pq.peek()));
            while(!pq.isEmpty()){
                int ar[]=pq.poll();
                ar[1]-=k;
                if(ar[1]<=0){
                    System.out.print((ar[0]+1)+" ");
                }else{
                    pq.offer(new int[]{ar[0],ar[1]});
                }
            }
            System.out.println();
        }
    }
}