package training.community;
import java.util.*;

public class TheCasinoPart1 {
    
    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        int ROUNDS = in.nextInt();
        int CASH = in.nextInt();
        in.nextLine();
        for (int i = 0; i < ROUNDS; i++) {
            long bet = (CASH+3)/4 ;
            String PLAY = in.nextLine();
            
            Scanner partial = new Scanner(PLAY) ;       
            int num = partial.nextInt() ; 
            String CALL = partial.next() ;
            
            if (CALL.compareTo("ODD")==0) {
                if (num%2==1) CASH += bet ;
                else CASH -= bet ; }
            else if (CALL.compareTo("EVEN")==0) {
                if (num%2==1||num==0) CASH -= bet ;
                else CASH += bet ; }
            else {
                int bank = partial.nextInt() ; 
                if (num==bank) CASH += bet*35 ;
                else CASH -= bet ; } }
        
        System.out.println(CASH);
    }    
}
