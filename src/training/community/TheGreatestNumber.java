package training.community;

import java.util.*;

public class TheGreatestNumber {
    
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            in.nextLine();
            String input = in.nextLine();
            
            boolean minus = false , dot=false ;
            int[] freq = {0,0,0,0,0,0,0,0,0,0} ;
            int mind=9 , maxd=0 ;

            for(int i=0 ; i<input.length() ; i++) {
                if (input.charAt(i)==' ') continue ;
                if (input.charAt(i)=='-') { minus=true ; continue ; }
                if (input.charAt(i)=='.') { dot=true ; continue ; }
                int val=input.charAt(i)-'0' ;
                freq[val]++ ;
                if (val<mind) mind=val ;
                if (val>maxd) maxd=val ; }
            
            String output="" ;
            if (maxd==0) output += "0" ;  
            else if (minus) {
                output += "-" ;
                if (dot) {
                    output += Integer.toString(mind)+".";
                    freq[mind]--;
                    for(int i=0 ; i<10 ; i++) {
                        while(freq[i]>0) {
                        freq[i]-- ;
                        output += Integer.toString(i) ; } } }
                else { 
                    for(int i=1 ; i<10 ; i++) {
                        while(freq[i]>0) {
                            freq[i]-- ;
                            output += Integer.toString(i) ; } } } }
            else {
                if (dot) {
                    freq[mind]-- ;
                    for(int i=9 ; i>=0 ; i--) {
                        while(freq[i]>0) {
                            freq[i]-- ;
                            output += Integer.toString(i) ; } }            
                    if (mind>0) output += "."+Integer.toString(mind); }
                else {
                    for(int i=9 ; i>=0 ; i--) {
                        while(freq[i]>0) {
                            freq[i]-- ;
                            output += Integer.toString(i) ; } } } }

            System.out.println(output); }
}
