package training.community;
import java.util.*;

public class TheUltimateTest {

    private static int ln , K ;
    private static String N ;
  
    private static int val(char c) { return c-'0' ; }
    private static int pow3(int n) { if (n==0) return 1 ; else return 3*pow3(n-1) ; }
    private static int eval(int n) {
        int m=n , l=0 ;
        int[] trinDig = new int[15] , trinRev = new int[15] ;
        for(int i=0 ; i<ln-1 ; i++) trinRev[i]=0 ;
        while(m>0) { trinRev[l++]=m%3 ; m=m/3 ; }
        for(int i=0 ; i<ln-1 ; i++) trinDig[i] = trinRev[ln-2-i] ;
    
        String s = "" ; s += N.charAt(0) ;
    
        for(int i=0 ; i<ln-1 ; i++) {
            if (trinDig[i]==1) s += '+' ;
            else if (trinDig[i]==2) s += '-' ;
            s += N.charAt(i+1) ; }
        
        int pos=0 , prev=0 , sign=1 , pres=0 ;
        while(pos<s.length()) {
            if (s.charAt(pos)=='-') { prev=prev+sign*pres ; pres=0 ; sign=-1 ; }
            else if (s.charAt(pos)=='+') { prev=prev+sign*pres ; pres=0 ; sign=1 ; }
            else pres=10*pres+val(s.charAt(pos)) ;  
            pos++ ; }
        
        prev=prev+sign*pres ;    
    
        if (prev==K) System.out.println(s);
    return 0 ; }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N = in.nextLine(); ln=N.length() ;
        K = in.nextInt();
        int lm = pow3(ln-1) ;
        for(int n=0 ; n<lm ; n++) eval(n) ;
    }    
}
