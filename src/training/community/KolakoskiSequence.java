package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class KolakoskiSequence {
 
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        String answer = "" ;
        int pos=1 , symb=b ;
        for(int i=0 ; i<a ; i++) answer += a ;
        
        while(answer.length()<n) {
            int freq ;
            if (pos==answer.length()) freq=symb ;
            else freq = answer.charAt(pos)-'0' ;
            for(int i=0 ; i<freq ; i++) 
                answer += symb ;
            pos++ ;
            if (symb==b) symb=a ; else symb=b ; }
        
        System.out.println(answer.substring(0,n)) ; } 
}
