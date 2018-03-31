package training.community;
import java.util.*;

public class ElementaryCellularAutomaton {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int N = in.nextInt();
        StringBuilder pres = new StringBuilder(in.next());
        
        int[] code = new int[8] ;
        for(int i=0 ; i<8 ; i++) { code[i] = R%2 ; R=R/2 ; }
        
        for(int i=0 ; i<N ; i++) {
            System.out.println(pres);
            String next = "" ;
            for(int k=0 ; k<pres.length() ; k++) {
                int val=0 , pr=k-1 , nx ;
                if (pr<0) pr += pres.length() ;
                nx=(k+1)%pres.length() ;
           
                if (pres.charAt(pr)=='@') val=1 ;
                val=2*val ; if (pres.charAt(k)=='@') val+=1 ;
                val=2*val ; if (pres.charAt(nx)=='@') val+=1 ;
                
                if (code[val]==1) next += "@";
                else next += "." ; }
            pres = new StringBuilder(next); } }    
}
