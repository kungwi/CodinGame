package training.community;
import java.util.*;

public class SimplifySelectionRanges {

    private static String replChar(String s , int i , char c) {
        char[] temp = s.toCharArray();
        temp[i] = c ;
        return String.valueOf(temp); }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String N = in.nextLine();

        int[] num = new int[105] ;
        for(int i=0 ; i<=100 ; i++) num[i]=0 ;
        
        for(int i=0 ; i<N.length() ; i++) 
            if (N.charAt(i)<'0'&&N.charAt(i)>30) N = replChar(N,i,' ') ;
        for(int i=0 ; i<N.length() ; i++) 
            if (N.charAt(i)>'9'&&N.charAt(i)<127) N = replChar(N,i,' ') ;
         
        Scanner partial = new Scanner(N) ;
        int q , n=0 ; 
        while(partial.hasNext()) { q=partial.nextInt() ; num[q]=1 ; n++ ; }

        if (n==0) return ;
        int pos=0 ; while(num[pos]==0) pos++ ;
        System.out.print(pos); int range=1 ; pos++ ;
 
        while(pos<=100) {
            while(num[pos]==1) { pos++ ; range++ ; }
            if (range>2) { 
                System.out.print("-") ;
                System.out.print(pos-1); }
            else if (range==2) { 
                System.out.print(",") ;
                System.out.print(pos-1); }
        
            range=1 ;
            while(num[pos]==0) { pos++ ; if (pos>100) break ; }
            if (pos>100) break ;
            System.out.print(",") ;
            System.out.print(pos);
            pos++ ; }   
        
        System.out.println();
    }    
}
