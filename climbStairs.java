import java.io.*;
import java.util.*;

public class climbStairs {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]jumps = new int[n];
        
        for(int i=0;i<n;i++) {
            jumps[i]=scn.nextInt();
        }
        
        int ans = CSMinMovesMem(0,n,jumps,new int[n+1]);
        
        // int tabAns = CSMinMovesTab(jumps);
        
        System.out.println(ans);
    }
     public static int CSMinMovesMem(int src,int dest,int[]jumps,int[]qb) {
        if(src == dest) {
            return 0;
        }
        
        if(qb[src] != 0) {
            return qb[src];
        }
        
        int min=Integer.MAX_VALUE;
        for(int step=1; step <= jumps[src] && src + step <= dest;step++) {
            int moves = CSMinMovesMem(src + step, dest,jumps,qb);
            
            if(moves < min) {
                min = moves;
            }
        }
        
        if(min == Integer.MAX_VALUE) {
            qb[src] = min;
            return min;
        }
        
        int ans = min + 1;
        qb[src] = ans;
        
        return ans;
    }
}