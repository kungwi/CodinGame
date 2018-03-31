package training.community;
import java.util.*;

public class BustSpeedingVehicles {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int N = in.nextInt();
        in.nextLine();
        String preplate = " " ; 
        long predst=0 ;  
        long pret=0 ; 
        boolean valid = true , first=true ;
        for (int i = 0; i < N; i++) {
            String R = in.nextLine();
            Scanner partial = new Scanner(R) ;
            String plate = partial.next() ; 
            long dst = partial.nextLong() , t = partial.nextLong() ;
            
            if (plate.compareTo(preplate)==0) { 
                long left = (dst-predst)*3600 , right=L*(t-pret) ;
                if (left>right) { 
                    System.out.println(plate + " " + dst) ;
                    valid = false ; }
                predst=dst ; pret=t ; }
            else { 
                pret = t ; preplate = plate ; predst=dst ; } }

        if (valid) System.out.println("OK"); }    
}
