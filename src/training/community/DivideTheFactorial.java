package training.community;
import java.util.*;

public class DivideTheFactorial {

    private static int[] prime = new int[500];
    private static int np ;
    
    private static int primePowerInFactorial(int p , int n) {
        int res = 0 , m=n ;
        while(m>0) { res+=m/p  ; m=m/p ; }
        return res ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();

        int n=5; np=2 ; prime[0]=2 ; prime[1]=3 ;
        while(n*n<=A) { 
            int i=0 ;
            boolean primeQ=true ;
            for(i=0 ; prime[i]*prime[i]<=n ; i++)
                if (n%prime[i]==0) { primeQ=false ; break ; }
            if (primeQ) { prime[np]=n ; np++ ; }
            n += 2 ; }

        int minpow = B ; n=0 ;
        while(A>1) {
            while((n<np)&&(A%prime[n]>0)) n++ ;
            if (n<np) {
                int powInFac = primePowerInFactorial(prime[n] , B) , powInA=0 ;
                while(!(A%prime[n]>0)) { A=A/prime[n] ; powInA++ ; }
                int mp = powInFac/powInA ;
                if (mp<minpow) minpow=mp ; }
            else {
                int powInFac = primePowerInFactorial(A , B) ;
                if (powInFac<minpow) minpow=powInFac ;
                break ; } }

        System.out.println(minpow); }    
}
