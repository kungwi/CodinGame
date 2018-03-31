package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class LongestPalindrome {
    
    private static String s ;
    
    private static String SearchEven(int p) {
        String ans=""+s.charAt(p)+s.charAt(p+1) ;
        int k=1 ;
        while ((p-k>=0)&&(p+k+1<s.length())) {
            if (s.charAt(p-k)==s.charAt(p+k+1))
                ans = s.charAt(p-k)+ans+s.charAt(p+k+1) ;
            else break ;
            k++ ; }
        return ans ; }

    private static String SearchOdd(int p) {
        String ans=""+s.charAt(p) ;
        int k=1 ;
        while ((p-k>=0)&&(p+k<s.length())) {
            if (s.charAt(p-k)==s.charAt(p+k))
                ans = s.charAt(p-k)+ans+s.charAt(p+k) ;
            else break ; 
            k++ ; }
        return ans ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in) ;
        s = in.next();
        String sf ;
        Queue answer = new LinkedList() ;
        answer.clear() ;
        int best = 0 ;
        
        for(int i=0 ; i<s.length()-1 ; i++) {
            sf = SearchOdd(i) ;
            if (sf.length()==best) answer.add(sf) ;
            else if (sf.length()>best) {
                best = sf.length() ;
                answer.clear();
                answer.add(sf) ; }
            if (s.charAt(i)==s.charAt(i+1)) {
                sf = SearchEven(i) ;
                if (sf.length()==best) answer.add(sf) ; 
                else if (sf.length()>best) {
                    best = sf.length() ;
                    answer.clear();
                    answer.add(sf) ; } } }
        
        while(!answer.isEmpty()) 
            System.out.println(answer.poll()) ; }
}
