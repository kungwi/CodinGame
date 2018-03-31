package training.community;

import java.util.*;

public class MinimalNumberOfSwaps {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in) ;
        int n = in.nextInt(), ones=0 , pos=0 , res=0;
        int[] zeroPos = new int[500] ;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x==1) ones++ ; else zeroPos[pos++]=i ; }

        int tmp=0 ;
        while(((tmp<pos)&&(zeroPos[tmp]<ones))) { res++ ; tmp++ ; }

        System.out.println(res);
    }    
}
