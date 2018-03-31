package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class BruceLee {

    public static String ASCIIfromBinary(String bin) {
        String ans = "" ;
        int len = bin.length()/7 , i , j ;
        for(i=0 ; i<len ; i++) {
            int val = 0 ;
            for(j=0 ; j<7 ; j++) val = 2*val+(bin.charAt(i*7+j)-'0') ;
            char c = (char)val ;
            ans += c ; }
        return ans ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String ENCRYPT = in.nextLine();

        boolean error = false ;
        for(char c : ENCRYPT.toCharArray()) 
            if ((c!=' ')&&(c!='0')) { error = true ; break ; }
        
        Scanner s = new Scanner(ENCRYPT) ;
        String bin = "" ;
        
        while(!error) {
            if (!s.hasNext()) break ;
            String bs = s.next() ;
            if (bs.length()>2) { error=true ; break ; }
            char b ;
            if (bs.length()==1) b='1' ; else b='0' ;
            if (!s.hasNext()) { error=true ; break ; }
            bs = s.next() ;
            for(char c : bs.toCharArray()) bin += b ; }
        
        if (bin.length()%7>0) error = true ; 
        
        if (error) System.out.println("INVALID");
        else System.out.println(ASCIIfromBinary(bin));
    }
}
