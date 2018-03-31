package training.community;
import java.util.*;

public class Rubik {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long res ;
        if (N==1) res = 1 ;
        else res = 2*N*N+2*(N-2)*N+2*(N-2)*(N-2) ;

        System.out.println(res) ; }    
}
