package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class nQueens {

    private static int[] sol ;
    private static int nsol = 0 ;
    private static int n ;
    
    private static boolean validQ(int num , int pos) {
        for(int i=pos-1 ; i>=0 ; i--) 
            if ((sol[i]==num)||(pos-i==Math.abs(num-sol[i]))) return false ;
        return true ; }
    
    private static void solve(int pos) {
        if (pos==n) { nsol++ ; return ; }
        for(int i=0 ; i<n ; i++) 
            if (validQ(i,pos)) { 
                sol[pos]=i ;
                solve(pos+1) ; } }
     
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        sol = new int[n] ;
        solve(0) ;
        System.out.println(nsol); }
}
