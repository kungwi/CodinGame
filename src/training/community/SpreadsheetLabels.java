package training.community;
import java.util.*;
import java.math.*;

public class SpreadsheetLabels {
    
    private static char[] label = new char[150] ;
    private static int nl ;
    
    private static BigInteger stringToNum(String s) {
        BigInteger val = BigInteger.ZERO ;
        int pos=0 ; 
        while(pos<s.length()) { 
            val = val.multiply(BigInteger.TEN).add(BigInteger.valueOf(s.charAt(pos)-'0')) ; 
            pos++ ; } 
        return val ; }
    
    private static void toString(BigInteger n) {
        nl=0 ;  
        BigInteger num=n ;
        while(num.compareTo(BigInteger.ZERO)>0) { 
            label[nl]= (char)(num.subtract(BigInteger.ONE).mod(BigInteger.valueOf(26L)).intValue()+'A') ;
            num = num.subtract(BigInteger.ONE).divide(BigInteger.valueOf(26L)) ;
            nl++ ; } }

    private static BigInteger toNum(String s) {
        BigInteger res=BigInteger.ZERO ;
        int pos = 0 ;
        while(pos<s.length()) { 
            res = res.multiply(BigInteger.valueOf(26)).add(BigInteger.valueOf(s.charAt(pos)+1-'A')) ;
            pos++ ;  }
        return res ; }
   
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String lab = in.next();
            if (lab.charAt(0)>='0'&&lab.charAt(0)<='9') {
                toString(stringToNum(lab)) ;
                if (i>0) System.out.print(" ") ;
                for(int k=nl-1 ; k>=0 ; k--) 
                    System.out.print(label[k]) ; }
            else {
                if (i>0) System.out.print(" ") ;
                System.out.print(toNum(lab)) ; } }
        System.out.println() ; }
}
