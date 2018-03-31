package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class MondayTuesdayHappyDays {
    
    private static String[] months = { "Jan" , "Feb" , "Mar" , "Apr" , 
                                       "May" , "Jun" , "Jul" , "Aug" , 
                                       "Sep" , "Oct" , "Nov" , "Dec" } ;
    private static int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31} ;
    private static String[] weekDays = { "Monday", "Tuesday", "Wednesday", 
                                "Thursday", "Friday", "Saturday" , "Sunday" } ;
    
    private static int DaysFromStart(String month , int day, int leap) {
        int ans=day , i ;
        for(i=0 ; i<12 ; i++) 
            if (months[i].equals(month)) break ;
            else { 
                ans += monthDays[i] ;
                if (i==1) ans += leap ; }    
    return ans ; }
    
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int leapYear = in.nextInt();
        String sourceDayOfWeek = in.next();
        String sourceMonth = in.next();
        int sourceDayOfMonth = in.nextInt();
        String targetMonth = in.next();
        int targetDayOfMonth = in.nextInt();
        
        int source = DaysFromStart(sourceMonth , sourceDayOfMonth , leapYear) ;
        int target = DaysFromStart(targetMonth , targetDayOfMonth , leapYear) ;
        int dif=(700+target-source)%7 , i ;
             
        for(i=0 ; i<7 ; i++) if (weekDays[i].equals(sourceDayOfWeek)) break ;
        
        System.out.println(weekDays[(i+dif)%7]) ; }
    
}
