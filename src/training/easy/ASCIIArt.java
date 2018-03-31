package training.easy;

import java.util.*;
import java.io.*;
import java.math.*;

public class ASCIIArt {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        String[] letters = new String[H] ;
        for (int i = 0; i < H; i++) {
            letters[i] = in.nextLine();
        }

        for(int j=0 ; j<H ; j++) {
            for(int i=0 ; i<T.length() ; i++) {
                int pos = -1 ;
                if (('a'<=T.charAt(i))&&(T.charAt(i)<='z')) pos = T.charAt(i)-'a' ;
                else if (('A'<=T.charAt(i))&&(T.charAt(i)<='Z')) pos = T.charAt(i)-'A' ;
                else pos=26;
                
                int first=pos*L ;
                           
                for(int k=first ; k<first+L ; k++) 
                    System.out.println(letters[j].charAt(k)); }
            
            System.out.println() ; }
    }
	
}
