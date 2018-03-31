
package training.community;
import java.util.*;

public class Elevator {
    private static int s , t , gcd ;
    
    private static void extended_euclid(int a, int b) { 
        int q, r, x1, x2, y1, y2;

        if (b == 0) {
            gcd = a ; s = 1 ; t = 0 ;
            return; }
    
        x2 = 1 ; x1 = 0 ; y2 = 0 ; y1 = 1;
        while (b > 0) {
            q = a / b ; r = a - q * b;
            s = x2 - q * x1 ; t = y2 - q * y1;
            a = b ; b = r;
            x2 = x1 ; x1 = s ; y2 = y1 ; y1 = t; }
        gcd = a ; s = x2 ; t = y2;
    return ; }
    
        private static int magn(int x , int y) {
        return Math.abs(x)+Math.abs(y) ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();

        if (k>m) {
            int temp=k ; k=m ; m=temp ;
            temp=a ; a=b ; b=temp ; }
            
        int target=m-k , scal ;   
        extended_euclid(a, b) ;
        scal = target / gcd ;

        int x1 = s*scal , y1=t*scal ;
        if ((target%gcd>0)||(k+a>n&&k-b<0)||(m+a>n&&m-b<0)) { 
            System.out.println("IMPOSSIBLE") ; }
        else {
            int  b1=b/gcd , a1=a/gcd , r=-1 ;
        
            while(x1<0||y1>0) { x1 = x1-r*b1 ; y1= y1+r*a1 ; r-- ; } 
        
            r=1 ;
            while(magn(x1-r*b1,y1+r*a1)<magn(x1-(r-1)*b1,y1+(r-1)*a1)&&
                x1-r*b1>=0&&y1+r*a1<=0) r++ ;
        
            int res= magn(x1-(r-1)*b1,y1+(r-1)*a1) ;
            System.out.println(res) ; } }    
    
}

