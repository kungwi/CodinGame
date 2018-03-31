package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class MagicStones {
    
    private static int[] level = new int[1100] ;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in); 
        for(int i=0 ; i<1100 ; i++) level[i] = 0 ;
        
        int N = in.nextInt();
        for (int i = 0; i < N; i++) { 
            int lev = in.nextInt();
            level[lev]++ ; } 

        int ans=0 ;
        for(int i=0 ; i<1100-1 ; i++) { 
            level[i+1] += level[i]/2 ;
            level[i] = level[i]%2 ;
            ans+= level[i] ; }
        
        System.out.println(ans) ; }
}
