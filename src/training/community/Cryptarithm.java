package training.community;
import java.util.*;

public class Cryptarithm {
    private static String[] add = new String[5] ;
    private static String res ;
    private static boolean found=false ;
    private static int[] number = new int[26] ; 
    private static int N , mxsz=0 ;

    private static boolean checkQ(){
        int i , curry=0 ;
        for(i=0 ; i<mxsz ; i++) {
            int sm=curry ;
            for(int j=0 ; j<N ; j++) 
                if (add[j].length()>i) 
                    sm += number[add[j].charAt(i)-'A'] ;
                if (sm>9) {curry = sm/10 ; sm=sm%10 ; }
                else curry=0 ;
                if (sm!=number[res.charAt(i)-'A']) return false ; }

        if (curry>0&&(number[res.charAt(mxsz)-'A']!=curry)) return false ;
        else if (curry==0&&res.length()>mxsz) return false ;
    return true ; }      
    
    private static void findNext(int p) {
        boolean[] digit = new boolean[10] ;
        int np=p ;

        while(np<26&&number[np]==-2) np++ ;
        if (np==26) { found=checkQ() ; return ; }
        for(int i=0 ; i<10 ; i++) digit[i]=false ;
        for(int i=0 ; i<np ; i++) 
            if (number[i]>=0) digit[number[i]] = true ;
    
        for(int i=0 ; i<10 ; i++)
            if (!digit[i]) { 
                number[np]=i ;
                findNext(np+1) ;
                if (found) return ; } }    
    
    public static void main(String args[]) {
        boolean[] digit = new boolean[10] ;
        for(int i=0 ; i<26 ; i++) number[i]=-2 ;
        for(int i=0 ; i<10 ; i++) digit[i]=true ;

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String word = in.next() ;
            StringBuilder temp = new StringBuilder(word) ;
            add[i] = temp.reverse().toString() ;
            if (add[i].length()>mxsz) mxsz = add[i].length() ;
            for(int j=0 ; j<add[i].length() ; j++)
                number[add[i].charAt(j)-'A'] = -1 ; }
        
        StringBuilder temp = new StringBuilder(in.next()) ;
        res = temp.reverse().toString() ;
        
        for(int j=0 ; j<res.length() ; j++)
            number[res.charAt(j)-'A'] = -1 ;
    
        findNext(0) ;    
        
        for(int i=0 ; i<26 ; i++)
            if (number[i]>=0) {
                char c = (char)(i+'A') ;
                System.out.println(c+" "+number[i]) ; } }    
}
