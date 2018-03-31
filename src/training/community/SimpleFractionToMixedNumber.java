package training.community;
import java.util.*;

public class SimpleFractionToMixedNumber {

    public static long gcd(long a , long b) {
        if (b==0) return a ; else return gcd(b,a%b) ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String xY = in.next();
            xY=xY.replace('/', ' ') ;
            Scanner partial = new Scanner(xY) ;
            long num = partial.nextLong() , den = partial.nextLong() ;
            
            boolean minus = false ;
            if (num*den<0) { 
                minus=true ; 
                if (den<0) den=-den ; else num=-num ; }

            if (den==0) System.out.println("DIVISION BY ZERO") ;
            else {
                long gd = gcd(num,den) ;
                num = num/gd ; den=den/gd ;
                if (minus) System.out.print("-") ;
                if (num<den&&num>0) { 
                    System.out.print(num) ;
                    System.out.print("/") ;
                    System.out.println(den) ; }
                else {
                    long intp = num/den , frap = num%den ;
                    System.out.print(intp) ;
                    if (frap>0) { 
                        System.out.print(" ") ;
                        System.out.print(frap) ;
                        System.out.print("/") ;
                        System.out.print(den) ; }
                    System.out.println() ; } } } }  
}
