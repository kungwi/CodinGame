package training.community;
import java.util.*;

public class ArmyAnts {
    
        private static String replChar(String s , int i , char c) {
            char[] temp = s.toCharArray();
            temp[i] = c ;
            return String.valueOf(temp); }

        public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N1 = in.nextInt() , N2 = in.nextInt();
        String S1 = in.next();
        String S2 = in.next();
        int T = in.nextInt();

        String St = "" ;
        St = St.concat(S1) ;
        St = St.concat(S2) ;
        
        for(int i=0 ; i<N1 ; i++) {
            if (T-i>=N2) St = replChar(St,N1+N2-1-i,S1.charAt(i)) ; 
            else if (T<=i) St = replChar(St,N1-1-i,S1.charAt(i)) ; 
            else St = replChar(St,N1-1+T-2*i,S1.charAt(i)) ; }
        
        for(int i=0 ; i<N2 ; i++) {
            if (T-i>=N1) St = replChar(St, i , S2.charAt(i)) ;
            else if (T<=i)  St = replChar(St, N1+i, S2.charAt(i)) ; 
            else St = replChar(St, N1-T+2*i, S2.charAt(i)) ;  }
        
        System.out.println(St);
    }   
}