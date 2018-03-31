package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class TheHungryDuckPart2 {

    private static int mx(int a , int b) {
    if (a>b) return a ; else return b ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int[][] lake = new int[H][W] ;
         
        for (int i = 0; i < H; i++) 
            for (int j = 0; j < W; j++)
                lake[i][j] = in.nextInt();
            
        for(int i=1 ; i<H ; i++) lake[i][0] += lake[i-1][0] ;
        for(int i=1 ; i<W ; i++) lake[0][i] += lake[0][i-1] ;

        for (int i = 1; i < H; i++) 
            for (int j = 1; j < W; j++)
                lake[i][j] += mx(lake[i-1][j],lake[i][j-1]) ;
        
        System.out.println(lake[H-1][W-1]); }
}
