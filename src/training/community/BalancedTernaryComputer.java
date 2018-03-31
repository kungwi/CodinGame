package training.community;
import java.util.*;


/**
 *
 * @author thales
 */
public class BalancedTernaryComputer {
    
    private static String reverse(String s) {
        String r="" ;    
        for(int i=s.length()-1 ; i>=0 ; i--) r += s.charAt(i) ;
    return r ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ans="" ;

        if (n==0) ans += '0' ;
        
        while(n!=0) {
            int res = (n+999999)%3 ;
            if (res==2) { ans+= 'T' ; n=(n+1)/3 ; }
            else  { ans += (char)('0'+res) ; n=(n-res)/3 ; } }

        System.out.println(reverse(ans));
    }
    
}
