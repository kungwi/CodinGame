package training.community;
import java.util.*;

public class TheseRomansAreCrazy {

    private static int num(char c){
        int value=0;
        switch(c){
            case 'I': value = 1; break;
            case 'V': value = 5; break;
            case 'X': value = 10; break;
            case 'L': value = 50; break;
            case 'C': value = 100; break;
            case 'D': value = 500; break;
            case 'M': value = 1000; break;
            case '0': value = 0; break;
            default: value = -1; }
    return value; }

    private static int RomanToDec(String s) {
        int val=0 , i=0 ;    
        
        while(i<s.length()-1) {    
            if (num(s.charAt(i))>=num(s.charAt(i+1))) val+= num(s.charAt(i)) ;
            else {
                val+=(num(s.charAt(i+1)) - num(s.charAt(i))) ; i++ ; }
            i++ ; }
    return val ; }

    private static String DecToRoman(int n) {
        String rom = "" ;    
    
        while (n!=0) {
            if (n>=1000) {
                int k = n/1000 ;
                for(int i=0 ; i<k ; i++) rom += 'M' ;
                n=n%1000 ; }
            else if (n>=500) {
                if (n<900) {
                    rom += 'D' ; n-=500 ; }
                else {
                    rom += 'C' ; rom += 'M' ;
                    n -= 900 ; } }
            else if(n>=100){
                if(n<400) {
                    int k = n/100 ;
                    for(int i=0 ; i<k ; i++) rom += 'C' ;
                    n = n%100 ; }
                else {
                    rom += 'C' ; rom += 'D' ;
                    n -= 400 ; } }
            else if (n>=50) {
                if (n<90) {
                    rom += 'L' ; n-=50 ; }
                else {
                    rom += 'X' ; rom += 'C' ;
                    n -= 90 ; } }
            else if (n>=10) {
                if (n<40) {
                    int k = n/10 ;
                    for(int i=0 ; i<k ; i++) rom += 'X' ;
                    n = n%10 ; }
                else {
                    rom += 'X' ; rom += 'L' ;
                    n -= 40 ; } }
            else if (n>=5) {
                if (n<9) {
                    rom += 'V' ; n-=5 ; }
                else {
                    rom += 'I' ; rom += 'X' ;   
                    n -= 9 ; } }
            else if (n>=1) {
                if (n<4) {
                    for(int i=0 ; i<n ; i++) rom += 'I' ;
                    n = 0 ; }
                else {
                    rom += 'I' ; rom += 'V' ;
                    n -= 4 ; } } }
        return rom ; }    

public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String rom1 = in.next();  rom1 += '0' ;
        String rom2 = in.next();  rom2 += '0' ;
        
        System.out.println(DecToRoman(RomanToDec(rom1)+RomanToDec(rom2))); }
}
