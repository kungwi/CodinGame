package training.community;
import java.util.*;

public class TheUrinalProblem {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String B = in.nextLine();

        int[] left = new int[110] , right = new int[110] ; 
        int ind , opt ;

        if (B.charAt(0)=='U') left[0]=100 ; else left[0]=0 ;
        for(int k=1 ; k<N ; k++) 
            if (B.charAt(k)=='U') left[k]=left[k-1]+1 ;
            else left[k]=0 ;

        if (B.charAt(N-1)=='U') right[N-1]=100 ; else right[N-1]=0 ;
        for(int k=N-2 ; k>=0 ; k--) 
            if (B.charAt(k)=='U') right[k]=right[k+1]+1 ;
            else right[k]=0 ;    
        
        ind=-1 ; opt=-1 ;    
        for(int k=0 ; k<N ; k++) {
            int tmp = left[k]<right[k] ? left[k] : right[k] ;
            if (tmp>opt) { opt=tmp ; ind = k ; } }
        
        System.out.println(ind) ; }    
}
