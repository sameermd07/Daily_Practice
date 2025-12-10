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
            int arr1[]=new int[n];
            int arr2[]=new int[n];
            for(int i=0;i<n;i++){
                arr1[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                arr2[i]=sc.nextInt();
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            helper(arr1,arr2,n,k);
        }
    }
        public static void helper(int A[],int B[],int n,int k){
            PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->((A[b[0]]+B[b[1]])-(A[a[0]]+B[a[1]])));
            for(int i=0;i<n;i++){
                pq.offer(new int[]{i,n-1});
            }
            int cnt=0;
            while(cnt<k && !pq.isEmpty()){
                int arr[]=pq.poll();
                System.out.print(A[arr[0]]+B[arr[1]]+" ");
                if(arr[1]>0){
                    pq.offer(new int[]{arr[0],arr[1]-1});
                }
                cnt++;
            }
            System.out.println();
        }
    }