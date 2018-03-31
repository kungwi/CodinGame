package training.community;
import java.util.*;

public class Gravity {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        int[] h = new int[105] ;
        for(int i=0 ; i<=width ; i++) h[i]=0 ;
        for (int i = 0; i < height; i++) {
            String line = in.next();
            for(int j=0 ; j<line.length() ; j++) 
                if (line.charAt(j)=='#') h[j+1]++ ; }

        for(int i=1 ; i<=height ; i++) {
            for(int j=1 ; j<=width ; j++) {
                if (height-i>=h[j]) System.out.print(".") ;
                else System.out.print("#") ; }
            System.out.println(); }
    }    
}
