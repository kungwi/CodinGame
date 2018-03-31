package training.community;
import java.util.*;

public class FractalCarpet {
    
    private static Long pow3(int l) { 
        return l==0?1L:pow3(l-1)*3L ; }
    
    private static char mark(Long i , Long j , int lev) {
        Long dim = pow3(lev) ;
        Long mid = dim/3L ;   
        if (i==0||j==0||i==dim||j==dim) return '0' ;    
        if (i>=mid&&i<2*mid&&j>=mid&&j<2*mid) return '+' ;
        else return mark(i%mid , j%mid , lev-1) ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        Long x1 = in.nextLong();
        Long y1 = in.nextLong();
        Long x2 = in.nextLong();
        Long y2 = in.nextLong();
        Long i , j ;
        for(i=y1 ; i<=y2 ; i++) {
            for(j=x1 ; j<=x2 ; j++)
                System.out.print(mark(i,j,L)) ;
            System.out.println() ; } }    
}
