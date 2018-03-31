package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class MicroAssembly {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[] r = new int[4] ;
        for(int i=0 ; i<4 ; i++) r[i]=in.nextInt() ;
        int n = in.nextInt();
        if (in.hasNextLine()) in.nextLine();
        
        String[] prog = new String[n] ;
        for (int i=0 ; i<n ; i++) prog[i] = in.nextLine();

        int prev=-1 , pres=0 ;
        while((prev!=pres)&&(pres<n)) { 
            prev = pres ; 
            Scanner instruction = new Scanner(prog[pres]) ;
            String com = instruction.next() , srcSt ;
            int dst , src , src2 ;
            switch (com) {
                case "MOV" : dst = instruction.next().charAt(0)-'a' ;
                             srcSt = instruction.next() ;
                             if (srcSt.charAt(0)>='a') src = r[srcSt.charAt(0)-'a'] ;
                             else {
                                 Scanner s = new Scanner(srcSt) ; 
                                 src = s.nextInt() ;
                                 s.close() ; }
                             r[dst] = src ;
                             pres++ ;
                             break ;
                case "ADD" : dst = instruction.next().charAt(0)-'a' ;
                             srcSt = instruction.next() ;
                             if (srcSt.charAt(0)>='a') src = r[srcSt.charAt(0)-'a'] ;
                             else {
                                 Scanner s = new Scanner(srcSt) ; 
                                 src = s.nextInt() ;
                                 s.close() ; }
                             srcSt = instruction.next() ;
                             if (srcSt.charAt(0)>='a') src2 = r[srcSt.charAt(0)-'a'] ;
                             else {
                                 Scanner s = new Scanner(srcSt) ; 
                                 src2 = s.nextInt() ;
                                 s.close() ; }
                             r[dst] = src + src2 ;
                             pres++ ;
                             break ;
                case "SUB" : dst = instruction.next().charAt(0)-'a' ;
                             srcSt = instruction.next() ;
                             if (srcSt.charAt(0)>='a') src = r[srcSt.charAt(0)-'a'] ;
                             else {
                                 Scanner s = new Scanner(srcSt) ; 
                                 src = s.nextInt() ;
                                 s.close() ; }
                             srcSt = instruction.next() ;
                             if (srcSt.charAt(0)>='a') src2 = r[srcSt.charAt(0)-'a'] ;
                             else {
                                 Scanner s = new Scanner(srcSt) ; 
                                 src2 = s.nextInt() ;
                                 s.close() ; }
                             r[dst] = src - src2 ;
                             pres++ ;
                             break ;
                case "JNE" : int temp = instruction.nextInt() ;
                             srcSt = instruction.next() ;
                             if (srcSt.charAt(0)>='a') src = r[srcSt.charAt(0)-'a'] ;
                             else {
                                 Scanner s = new Scanner(srcSt) ; 
                                 src = s.nextInt() ;
                                 s.close() ; }
                             srcSt = instruction.next() ;
                             if (srcSt.charAt(0)>='a') src2 = r[srcSt.charAt(0)-'a'] ;
                             else {
                                 Scanner s = new Scanner(srcSt) ; 
                                 src2 = s.nextInt() ;
                                 s.close() ; }
                             if (src!=src2) pres = temp ;
                             else pres++ ;
                             break ; 
                   default : break ; } }
        
        System.out.println(""+r[0]+" "+r[1]+" "+r[2]+" "+r[3]) ; }
}
