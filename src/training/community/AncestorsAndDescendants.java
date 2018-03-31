package training.community;
import java.util.*;

public class AncestorsAndDescendants {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        int dots=-1 ; 
        String sep = " > " ; 
        StringBuilder output = new StringBuilder("") ;
        for (int i = 0; i < count; i++) {
            StringBuilder line = new StringBuilder(in.nextLine()) ;
            int temp=0 ; 
            while(line.charAt(temp)=='.') temp++ ;
            line.delete(0, temp) ;
            
            if (temp==0) { 
                if (dots>=0) System.out.println(output) ;
                dots=0 ; output = line ; }
            else if (temp<=dots) { 
                System.out.println(output) ; 
                int er = dots - temp + 1 ;
                while (er>0) {
                    int k ;
                    for(k=output.length()-1 ; k>=0 ; k--)
                        if (output.charAt(k)=='>') break ; 
                    output.delete(k-1,output.length()) ;
                    er-- ; } 
                dots=temp ; 
                output.append(sep) ; 
                output.append(line) ;  }
        else {
            output.append(sep) ; 
            output.append(line) ;
            dots++ ; } }

        System.out.println(output) ; }    
}
