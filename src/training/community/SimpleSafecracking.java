package training.community;
import java.util.*;

public class SimpleSafecracking {
    
    public static void main(String args[]) {
        int i ,j;
        String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"} ;

        Scanner in = new Scanner(System.in);
        String msg = in.nextLine();
        msg = msg.substring(msg.indexOf(':')+2).replace('-', ' ') ;
        in = new Scanner(msg) ;
        while(in.hasNext()) {
            msg=in.next() ;
            char[] temp = msg.toCharArray();
            int res=-1 ;
            for(i=0 ; i<26 ; i++) {
                for(j=0 ; j<msg.length() ; j++) {
                    temp[j]++ ;
                    if (temp[j]>'z') temp[j]='a' ; } 
                for(j=0 ; j<10 ; j++) 
                    if (String.valueOf(temp).compareTo(num[j])==0) { res=j ; break ; } 
                if (res>=0) break ; } 
            System.out.print(res) ; }

        System.out.println();
    }    
}
