package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class HighestTruncatedPyramid {
    
    public static int triangle(int N) {
        double eps = 0.000001 ;
        double dia = Math.floor(Math.sqrt(2*N+0.25)-0.5+eps) ;
        int ans = (int)dia ;
        return ans ; }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        int k = triangle(N) , a=0 ; 
        for(int i=k ; i>=0 ; i--) { 
            int num = 2*N - i*(i+1) ;
            int den = 2*(i+1) ;
            if ((num%den==0)&&(num!=0)) {
                a = num/den ;
                break ; } }
        
        while(N>0) {
            for(int i=1 ; i<=a ; i++) System.out.print("*");
            System.out.println() ;
            N -= a ; a++ ; } }
}
