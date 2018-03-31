package training.community;
import java.util.*;

public class EgyptianMultiplication {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[] res = new int[100] ; int n=0 ;
        if (a<b) { int temp=a ; a=b ; b=temp ; }
        int r = a * b ;
        System.out.println(a + " * " + b) ;
        while (b>0) {
            System.out.print("= ") ;
            if (b%2==1) { 
                b-- ; res[n]=a ; n++ ; 
                System.out.print(a + " * " + b) ; 
                for(int i=0 ; i<n ; i++) System.out.print(" + " + res[i]) ;
                System.out.println() ; } 
            else {
                b=b/2 ; a=2*a ;
                System.out.print(a + " * " + b) ;  
                for(int i=0 ; i<n ; i++) System.out.print(" + " + res[i]) ;
                System.out.println() ; } }

        System.out.println("= " + r) ; }    
}
