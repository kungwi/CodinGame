package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class NumberOfLettersInANumberBinary {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        long n = in.nextLong();

        int ones , len ;
        while(n>0) { 
            if ((num==13)||(num==18)) break ;
        
            ones=0 ; len=0 ;
            long temp=num ;
            while(temp>0) { 
                len++ ; if (temp%2==1) ones++ ; 
                temp = temp / 2 ; }
            num = 4*len-ones ;
            n-- ; }
        
        System.out.println(num); }    
}
