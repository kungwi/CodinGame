package training.community;

import java.util.*;

public class CarmichaelNumbers {
    
    public static void main(String args[]) {
        int pos , pr=5 , k ;
        int[] prime = new int[65] ;
        prime[0]=2 ; prime[1]=3 ; pos=2 ;
        for(pr=5 ; pr*pr<100000 ; pr+=2) {
            boolean primeQ = true ;
            for(k=1 ; prime[k]*prime[k]<pr+1 ; k++) {
                if (pr%prime[k]==0) { primeQ=false ; break ; } }
            if (primeQ) { prime[pos]=pr ; pos ++ ; } }
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() ;

        int m = n ;
        boolean carm = true , primeQ =true ;
 
        for(k=0 ; prime[k]*prime[k]<=n ; k++) {
            if (n%prime[k]==0) {
                primeQ=false ;
                n=n/prime[k] ;
                if (n%prime[k]==0) { carm=false ; break ; }
                if ((m-1)%(prime[k]-1)>0) { carm=false ; break ; } } }
        
        if ((m-1)%(n-1)>0) carm=false ;
        
        if (carm&&(!primeQ)) System.out.println("YES");
        else System.out.println("NO");
    }    
}
