package training.easy;

import java.util.*;

public class ChuckNorris {
	
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        String bin = "" ;
        
        for (char c : MESSAGE.toCharArray()) { 
        	String temp = Integer.toBinaryString(c).toString() ; 
        	for(int i=0 ; i<7-temp.length() ; i++) bin += "0" ;
        	bin += temp ;
        	}
        
        String answer = "" ;
        int i=0 ;
        while(i<bin.length()) {
        	char c = bin.charAt(i) ;
        	if (c=='0') answer += "0" ;
        	answer += "0 " ;
        	while(i<bin.length()&&bin.charAt(i)==c) {
        		i++ ; answer += "0" ; } 
        	if (i<bin.length()) answer += " ";	}
      
        System.out.println(answer); }

}
