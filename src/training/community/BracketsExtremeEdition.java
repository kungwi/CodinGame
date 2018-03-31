/*
    for(int i=0 ; i<ex.size() ; i++) {
        if (ex[i]=='['||ex[i]=='{'||ex[i]=='(') br.push(ex[i]) ;
        else if (ex[i]==']') { 
            if (!br.empty()&&br.top()=='[') br.pop() ;
            else { valid=false ; break ; } }
        else if (ex[i]==')') { 
            if (!br.empty()&&br.top()=='(') br.pop() ;
            else { valid=false ; break ; } }
        else if (ex[i]=='}') { 
            if (!br.empty()&&br.top()=='{') br.pop() ;
            else { valid=false ; break ; } } }
 */
package training.community;
import java.util.*;

public class BracketsExtremeEdition {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String ex = in.next();

        Stack<Character> br = new Stack<Character>();
        boolean valid=true ;
        
        for(int i=0 ; i<ex.length() ; i++) {
            if (ex.charAt(i)=='['||ex.charAt(i)=='{'||ex.charAt(i)=='(') 
                br.push(ex.charAt(i)) ;
            else if (ex.charAt(i)==']') { 
                if (!br.empty()&&br.peek()=='[') br.pop() ;
                else { valid=false ; break ; } }
            else if (ex.charAt(i)==')') { 
                if (!br.empty()&&br.peek()=='(') br.pop() ;
                else { valid=false ; break ; } }
            else if (ex.charAt(i)=='}') { 
                if (!br.empty()&&br.peek()=='{') br.pop() ;
                else { valid=false ; break ; } } }
        
        if (!br.empty()) valid = false ;  
        System.out.println(valid);
    }    
}
