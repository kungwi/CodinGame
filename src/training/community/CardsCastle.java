package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class CardsCastle {
   
        public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        if (in.hasNextLine()) in.nextLine();
        
        String[] castle = new String[H] ;
        
        for (int i = H-1 ; i>=0 ; i--) 
            castle[i] = in.nextLine();
        
        boolean stable = true ;
        
        for (int i=0 ; i<H ; i++) { 
            for(int j=0 ; j<castle[i].length() ; j++) {
                if (castle[i].charAt(j)=='/') { 
                    if (j==castle[i].length()-1) { 
                        stable=false ; break ; }
                    if (castle[i].charAt(j+1) != '\\' ) {
                        stable=false ; break ; } 
                    if (i>0) {
                        if (castle[i-1].charAt(j) != '\\' ) {
                            stable=false ; break ; } } } 
                if (castle[i].charAt(j)=='\\') { 
                    if (j==0) { 
                        stable=false ; break ; }
                    if (castle[i].charAt(j-1) != '/' ) {
                        stable=false ; break ; } 
                    if (i>0) {
                        if (castle[i-1].charAt(j) != '/' ) {
                            stable=false ; break ; } } } }
            if (!stable) break ; } 

        if (stable) System.out.println("STABLE");
        else System.out.println("UNSTABLE"); }
}
