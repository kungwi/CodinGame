package training.easy;

import java.util.*;
import java.io.*;
import java.math.*;

public class HorseRacingDuals {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] num = new int[N] ;
        for (int i = 0; i < N; i++) {
            num[i] = in.nextInt();
        }

        Arrays.sort(num);
        int dif=num[N-1]-num[0] ;
       
        for (int i = 0; i < N-1 ; i++) 
            if (num[i+1]-num[i]<dif) dif=num[i+1]-num[i] ;        

        System.out.println(dif);
    }
	
}
