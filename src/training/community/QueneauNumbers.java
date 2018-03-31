package training.community;
import java.util.*;

public class QueneauNumbers {
    
    private static int qeneau(int m , int n) {
        if (m%2==1) return n-(m-1)/2 ; else return m/2 ; }
    
    private static int[] q = {0,0,1,1,0,1,1,0,0,1,0,1,0,0,1,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,1} ;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        if (q[N]==0) System.out.println("IMPOSSIBLE") ;
        else {
            int[] perm = new int[31] ;
            for(int i=1 ; i<=N ; i++) perm[i]=i ;
        
            for(int i=1 ; i<=N ; i++) {
                for(int j=1 ; j<=N ; j++)
                    perm[j]=qeneau(perm[j],N) ;
                System.out.print(perm[1]) ;
                for(int j=2 ; j<=N ; j++) System.out.print(","+perm[j]) ;
                System.out.println() ; } } }    
}
