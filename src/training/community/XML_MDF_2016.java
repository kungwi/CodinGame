package training.community;
import java.util.*;

public class XML_MDF_2016 {
    
    public static void main(String args[]) {
        double[] weight = new double[26] ;
        Scanner in = new Scanner(System.in);
        String sequence = in.nextLine();
        Stack<Character> tags = new Stack<Character>() ;
        int depth ;
        for(int i=0 ; i<26 ; i++) weight[i] = 0. ;
        for(int k=0 ; k<sequence.length() ; k++)
            if (sequence.charAt(k)=='-') { 
                k++ ; depth=tags.size() ; 
                weight[sequence.charAt(k)-'a'] += 1./depth ; 
                tags.pop() ;  }
            else tags.push(sequence.charAt(k)) ;   

        double mx=0 ; int ind=0;    
        for(int i=0 ; i<26 ; i++) 
            if (weight[i]>mx) { mx=weight[i] ; ind=i ; }
        
        char c = (char)('a'+ind);
        System.out.println(c) ; }   
}
