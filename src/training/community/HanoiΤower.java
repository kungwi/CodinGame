package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class HanoiΤower {
    
    private static int pow2(int n) {
        if (n==0) return 1 ;
        else return 2*pow2(n-1) ; }

    private static int nOfTurns(int n) { return pow2(n)-1 ; }
    
    private static int pole(int move , int disk , int n) {
        int pos = ((move+pow2(disk))/pow2(disk+1))%3 ;
        if ((n-disk)%2==0) return pos ;
        else return (3-pos)%3 ; }
    
    private static String printDisk(int disk , int pole , int n) {
        String pr="" ;
        for(int i=0 ; i<n-disk-1 ; i++) pr+=" " ;
        if (disk==-1) pr += "|" ;
        else { for(int i=0 ; i<=disk ; i++) pr+="##" ; pr+="#" ; }
        if (pole<2) for(int i=0 ; i<n-disk-1 ; i++) pr+=" " ;
        return pr ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();        
        
        int[][] poles = new int[3][N] ;
        int[] pos = {0,0,0} ;
        for(int p=0 ; p<3 ; p++)
            for(int i=0 ; i<N ; i++)
                poles[p][i] = -1 ;
        
        for(int d=N-1 ; d>=0 ; d--) {
            int p = pole(T,d,N) ;
            poles[p][pos[p]] = d ;
            pos[p] ++ ; }    
        
        String[] output = new String[N] ;
        for(int lev=0 ; lev<N ; lev++) {
            output[lev] = printDisk(poles[0][lev],0,N)+" " ;
            output[lev] += printDisk(poles[1][lev],1,N)+" " ;
            output[lev] += printDisk(poles[2][lev],2,N) ; }
        
        for(int l=N-1 ; l>=0 ; l--) System.out.println(output[l]);
        System.out.println(nOfTurns(N)); } 
}
