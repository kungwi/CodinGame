package training.easy;

import java.util.*;
import java.io.*;
import java.math.*;

public class TheDescent {
	
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            
            int ind = -1 ;
            int height = 0;
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                if (mountainH>height) { height = mountainH ; ind = i ; }
            }

            System.out.println(ind); // The index of the mountain to fire on.
        }
    }

}
