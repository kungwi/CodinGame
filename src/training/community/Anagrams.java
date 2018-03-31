package training.community;
import java.util.*;

public class Anagrams {
    
    public static void main(String args[]) {
        int[] len= new int[100] ;
        int nw=0 ;
        Scanner in = new Scanner(System.in);
        String phrase = in.nextLine();
        Scanner partial = new Scanner(phrase) ;
        String wrd ; 
        while(partial.hasNext()) {
            wrd = partial.next() ; len[nw++] = wrd.length() ; }
        int[] blank = new int[100] ; 
        blank[0]=len[nw-1] ;
        for(int i=1 ; i<nw-1 ; i++) 
            blank[i]=blank[i-1]+len[nw-1-i] ;
        
        StringBuilder sb = new StringBuilder(phrase);
        for(int i=0 ; i<sb.length() ; i++) 
            if (sb.charAt(i)==' ') sb.deleteCharAt(i) ;
        
        int pos=0 , init ;
        while((pos<sb.length())&&((sb.charAt(pos)-'A'+1)%4!=0)) pos++ ;  
        
        if (pos<sb.length()) {
            init = pos ;
            char prev=sb.charAt(init) , next ; 

            pos++ ;
            while(pos<sb.length()) {
                if((sb.charAt(pos)-'A'+1)%4==0) {
                    next=sb.charAt(pos) ; 
                    sb.replace(pos, pos+1, ""+prev) ; 
                    prev=next ; }
                pos++ ; }
        
            sb.replace(init, init+1, ""+prev) ; } 
        
        pos = sb.length()-1 ;
        while((pos>=0)&&((sb.charAt(pos)-'A'+1)%3!=0)) pos-- ;  
        
        if (pos>=0) {
            init = pos ;
            char prev = sb.charAt(init) , next ; 
            pos-- ;
            while(pos>=0) {
                if((sb.charAt(pos)-'A'+1)%3==0) {
                    next=sb.charAt(pos) ; 
                    sb.replace(pos, pos+1, ""+prev) ;  
                    prev=next ; }
                pos-- ; }
            sb.replace(init, init+1, ""+prev) ; } 
        
        int st=0 , en=sb.length()-1 ;
        while(st<en) { 
            while(st<en&&(sb.charAt(st)-'A'+1)%2==1) st++ ;
            while(st<en&&(sb.charAt(en)-'A'+1)%2==1) en-- ;
            if (st<en) { 
                char temp=sb.charAt(st) ;
                sb.replace(st, st+1, ""+sb.charAt(en)) ; 
                sb.replace(en, en+1, ""+temp) ; 
                st++ ; en-- ; } }  
        for(int i=nw-2 ; i>=0 ; i--) 
            sb.insert(blank[i], " ") ;
        
        System.out.println(sb); }    
}
