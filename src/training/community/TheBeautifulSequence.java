package training.community;
import java.util.*;

public class TheBeautifulSequence {
    
    private static int[][] mat = new int[100000][2] ; 
    private static int bv=0 ;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0 ; i<n ; i++) { mat[i][0]=0 ; mat[i][1]=1 ; }

        for (int i = 0; i < n; i++) mat[i][0] = in.nextInt();
        
        for(int i=0 ; i<n ; i++) {
            int j=i-1 ;
            while(j>=0&&mat[j][0]>=mat[i][0]) { j-- ; mat[i][1]++ ; }
            j=i+1 ;
            while(j<n&&mat[j][0]>=mat[i][0]) { j++ ; mat[i][1]++ ; }
            int val = mat[i][0]*mat[i][1] ;
            if (val>bv) bv=val ; }
        
        System.out.println(bv) ; }    
}
