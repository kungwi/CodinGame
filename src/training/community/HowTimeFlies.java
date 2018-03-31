package training.community;
import java.util.*;

public class HowTimeFlies {
    
    private static class date {
        public int day ; public int month ; public int year ; }
    
    private static int[] days = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
    
    private static date strToDate(String st) {
        Scanner partial = new Scanner(st.replace('.',' ')) ;
        date res = new date() ; 
        res.day = partial.nextInt() ;
        res.month = partial.nextInt() ;
        res.year = partial.nextInt() ;
        return res ;}

    private static boolean leapQ(int y) {
        if (y%4!=0) return false ;
        if (y%400==0) return true ;
        if (y%100==0) return false ;
        return true ; }

    private static int daysToEnd(date st) {
        int res=0 ;    
        for(int k=st.month ; k<=12 ; k++) { 
            res += days[k] ;
            if ((k==2)&&leapQ(st.year)) res++ ; }   
        res = res - st.day ;
        return res ; }
    
    private static int daysFromBeg(date en) {
        int res=0 ;    
        for(int k=1 ; k<en.month ; k++) {
            res += days[k] ; 
            if ((k==2)&&leapQ(en.year)) res++ ; }
        res = res + en.day ;
        return res ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String BEGIN = in.next();
        String END = in.next();
        date start = strToDate(BEGIN) ;
        date end = strToDate(END) ;

        int ndays = 0 ;
        if (start.year<end.year) { 
            ndays = daysToEnd(start)+daysFromBeg(end) ; 
            for(int y=start.year+1 ; y<end.year ; y++) 
                if (leapQ(y)) ndays+=366 ; else ndays+=365 ; }
        else if (start.month<end.month) {
            for(int y=start.month+1 ; y<end.month ; y++) {
                ndays+=days[y] ;
                if (y==2&&leapQ(start.year)) ndays++ ; }
            ndays+=end.day ; ndays+=days[start.month]-start.day ;
            if (start.month==2&&leapQ(start.year)) ndays++ ; }
        else ndays = end.day - start.day ;

        int YY=end.year-start.year ;
        if (start.month>end.month) YY-- ;
        else if (start.month==end.month&&start.day>end.day) YY-- ;
        int MM ;
        if (end.month>start.month) {
            MM = end.month-start.month ;
            if (start.day>end.day) MM-- ; }
        else if (end.month==start.month) {
            if (start.day>end.day) MM = 11 ;
            else MM=0 ; }
        else { 
            MM = 12-start.month+end.month ; 
            if (start.day>end.day) MM-- ; }
        
        String out = "" ;
        if (YY>0) {
            out += YY + " year" ; 
            if (YY>1) out += "s" ;
            out += ", " ; }
        if (MM>0) {
            out += MM + " month" ; 
            if (MM>1) out += "s" ;
            out += ", " ; }
        System.out.print(out) ;
        System.out.println("total " + ndays + " days") ; }    
}
