package training.community;
import java.util.*;

public class TheExperienceForCreatingPuzzles {

    private static int expLevel(int lev) { 
        return (int)(lev*Math.sqrt(lev)*10+0.00001) ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int level = in.nextInt();
        int xp = in.nextInt();
        int N = in.nextInt();

        int need=xp , exper=N*300 ;
        while(exper>=need) {
            level++ ;
            exper -= need ;
            need = expLevel(level) ; }

        System.out.println(level) ;
        System.out.println(need-exper) ; }    
}
