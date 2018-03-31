package training.community;
import java.util.*;

/**
 *
 * @author thales
 */
public class TheTwoEggProblem {
    
    public static int answer(int N) {
        double eps = 0.000001 ;
        double dia = Math.ceil(Math.sqrt(2*N+0.25)-0.5-eps) ;
        int ans = (int)dia ;
        return ans ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt() ;
        System.out.println(answer(N)) ; }
}
