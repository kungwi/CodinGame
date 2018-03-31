package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class TimerForClashOfCode {
    
    private static int secFromString(String time){
        Scanner r = new Scanner(time).useDelimiter(":") ;
        return r.nextInt()*60+r.nextInt() ; }
 
    private static int timeDelay(int p) {
        int pw = 1 , n = p ;
        while (n>1) { pw *= 2 ; n-- ; }
        return 256/pw ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) in.nextLine();
        int startTime=0 ; 
        
        for (int i = 0; i < n; i++) {
            int timeStamp = secFromString(in.nextLine()) ;
            if (timeStamp<startTime) break ;
            if (i>5) { startTime=timeStamp ; break ; }
            startTime = timeStamp - timeDelay(i+1) ;
            if (startTime<0) startTime=0 ;
        }

        if (n==0) System.out.println("NO GAME");
        else { 
            int min = startTime/60 ;
            int sec = startTime%60 ;
            System.out.print(""+min+":");
            if (sec<10) System.out.print("0");
            System.out.println(sec); } }   
}
