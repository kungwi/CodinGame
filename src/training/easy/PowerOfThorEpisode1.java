package training.easy;
import java.util.*;

/**
 *
 * @author thales
 */

public class PowerOfThorEpisode1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            if ((lightX>initialTX)&&(lightY>initialTY)) { 
                System.out.println("SE") ; 
                initialTX++ ; initialTY++ ; }
            else if ((lightX>initialTX)&&(lightY<initialTY)) { 
                System.out.println("NE") ;
                initialTX++ ; initialTY-- ; }
            else if ((lightX<initialTX)&&(lightY<initialTY)) { 
                System.out.println("NW") ;
                initialTX-- ; initialTY-- ; }
            else if ((lightX<initialTX)&&(lightY>initialTY)) {  
                System.out.println("SW") ;
                initialTX-- ; initialTY++ ; }
            else if ((lightX==initialTX)&&(lightY<initialTY))  
                System.out.println("N") ;
            else if ((lightX==initialTX)&&(lightY>initialTY))  
                System.out.println("S") ;
            else if ((lightX>initialTX)&&(lightY==initialTY))  
                System.out.println("E") ;
            else if ((lightX<initialTX)&&(lightY==initialTY))  
                System.out.println("W") ; } }  
}
