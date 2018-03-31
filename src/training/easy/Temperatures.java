package training.easy;

import java.util.*;
import java.io.*;
import java.math.*;

public class Temperatures {

	    public static void main(String args[]) {
	        Scanner in = new Scanner(System.in);
	        
	        int n = in.nextInt(); // the number of temperatures to analyse
	        int result ;
	        if (n>0) result = in.nextInt() ;
	        else result = 0 ;
	        for (int i = 1; i < n; i++) {
	            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
	            if (Math.abs(t)>Math.abs(result)) continue ;
	            if ((t>=0)||(Math.abs(t)<Math.abs(result))) result = t ; }

	        System.out.println(result) ; }

}
