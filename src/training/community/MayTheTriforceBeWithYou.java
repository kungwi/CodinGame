package training.community;
import java.util.*;

public class MayTheTriforceBeWithYou {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt() , i , j ;
        String answer="." ;
        for(i=2 ; i<=2*N-1 ; i++) answer += " " ; 
        answer += "*\n" ;
    
        for(i=2 ; i<=N ; i++) {
            for(j=1 ; j<=2*N-i ; j++) answer += " " ;
            for(j=1 ; j<=2*i-1 ; j++) answer += "*" ;
            answer += "\n" ; }
    
        for(i=1 ; i<=N ; i++) {
            for(j=1 ; j<=N-i ; j++) answer += " " ;
            for(j=1 ; j<=2*i-1 ; j++) answer += "*" ;
            for(j=1 ; j<=2*N+1-2*i ; j++) answer += " " ;
            for(j=1 ; j<=2*i-1 ; j++) answer += "*" ;
            answer += "\n" ; } 
        
        System.out.print(answer); }    
}
