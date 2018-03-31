package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class FoldingPaper {
    
    public static int u=1 , l=1 , d=1 , r=1 ;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();
        String side = in.nextLine();

        for(int i=0 ; i<order.length() ; i++)
            switch (order.charAt(i)) {
                case 'D':  u+=d ; d=1 ; l*=2 ; r*=2 ; break;
                case 'U':  d+=u ; u=1 ; l*=2 ; r*=2 ; break;
                case 'L':  r+=l ; l=1 ; d*=2 ; u*=2 ; break;
                case 'R':  l+=r ; r=1 ; d*=2 ; u*=2 ; break;
                default : break ; }
        
        switch (side) {
            case "D":  System.out.println(d) ; break;
            case "U":  System.out.println(u) ; break;
            case "L":  System.out.println(l) ; break;
            case "R":  System.out.println(r) ; break;
            default : break ; } }    
}
