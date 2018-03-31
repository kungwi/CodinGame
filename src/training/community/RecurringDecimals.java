package training.community;
import java.util.*;

/**
 *
 * @author thales
 */
public class RecurringDecimals {
    
            public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt() , rem ;
            String answer = "0." ;
                 
            int p=n , q=1  ;
            while(p%2==0) { p=p/2 ; q=q*2; }
            while(p%5==0) { p=p/5 ; q=q*5; }
            rem = 1 ;
            
            if (q==n) 
                while(rem>0) { answer += rem*10/n ; rem=(rem*10)%n ; } 
            else if (q==1) {
                answer += "(" ;
                while(true) { answer += rem*10/n ; rem=(rem*10)%n ; if (rem==1) break ; } 
                answer += ")" ; }
            else {
                int len=0 ;
                while(rem>0) { rem=(rem*10)%q ; len++ ; }
 
                rem=1 ;
                while(len>0) { answer += rem*10/n ; rem=(rem*10)%n ; len-- ; }
                int temp = rem ;    
                answer += "(" ;
                while(true) { answer += rem*10/n ; rem=(rem*10)%n ; if (rem==temp) break ; }
                answer += ")" ; }    

            System.out.println(answer); }
    
}
