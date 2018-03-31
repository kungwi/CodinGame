package training.community;

import java.util.*;

public class TheFastest {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), bh=99, bm=99, bs=99 ;
        for (int i = 0; i < N; i++) {
            String t = in.next();
            int h , m ,s ;
            h = 10*(t.charAt(0)-'0') + t.charAt(1)-'0' ;
            m = 10*(t.charAt(3)-'0') + t.charAt(4)-'0' ;
            s = 10*(t.charAt(6)-'0') + t.charAt(7)-'0' ;
            
            if (h>bh) { } 
            else if (h<bh) { bh=h; bm=m; bs=s ; }
            else {
                if (m>bm) { } 
                else if (m<bm) {bm=m; bs=s; }
                else { 
                    if (s>bs) { } 
                    else { bs=s ; } } } }
        
        String answer = "" ;
        if (bh<10) answer += "0" ; answer += Integer.toString(bh) + ":" ;
        if (bm<10) answer += "0" ; answer += Integer.toString(bm) + ":" ;
        if (bs<10) answer += "0" ; answer += Integer.toString(bs) ; 
        
        System.out.println(answer);
    }    
}
