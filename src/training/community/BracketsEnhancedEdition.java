package training.community;
import java.util.*;

/**
 *
 * @author thales
 */
public class BracketsEnhancedEdition {
    
    private static boolean evaluateQ(String s) {
        Stack<Character> pars = new Stack<Character>() ;
        
        while(!pars.empty()) pars.pop() ;
    
        for(int i=0 ; i<s.length() ; i++) {
            switch ( s.charAt(i) ) {
                case '(' : 
                    if (!pars.empty()&&(pars.peek()=='('||pars.peek()==')')) pars.pop() ;
                    else pars.push(s.charAt(i)) ;
                    break ;
                case ')' :
                    if (!pars.empty()&&(pars.peek()=='('||pars.peek()==')')) pars.pop() ;
                    else pars.push(s.charAt(i)) ;
                    break ;
                case '<' : 
                    if (!pars.empty()&&(pars.peek()=='<'||pars.peek()=='>')) pars.pop() ;
                    else pars.push(s.charAt(i)) ;
                    break ;
                case '>' : 
                    if (!pars.empty()&&(pars.peek()=='<'||pars.peek()=='>')) pars.pop() ;
                    else pars.push(s.charAt(i)) ;
                    break ;            
                case '{' : 
                    if (!pars.empty()&&(pars.peek()=='{'||pars.peek()=='}')) pars.pop() ;
                    else pars.push(s.charAt(i)) ;
                    break ;            
                case '}' : 
                    if (!pars.empty()&&(pars.peek()=='{'||pars.peek()=='}')) pars.pop() ;
                    else pars.push(s.charAt(i)) ;
                    break ;            
                case '[' : 
                    if (!pars.empty()&&(pars.peek()=='['||pars.peek()==']')) pars.pop() ;
                    else pars.push(s.charAt(i)) ;
                    break ;            
                case ']' : 
                    if (!pars.empty()&&(pars.peek()=='['||pars.peek()==']')) pars.pop() ;
                    else pars.push(s.charAt(i)) ;
                    break ;            
                default:  break; }  }
            
    if (pars.empty()) return true ; 
    else return false ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) in.nextLine();
        
        for (int i = 0; i < N; i++) {
            String expression = in.nextLine();
            boolean res = evaluateQ(expression) ;
            if (res) System.out.println("true");
            else System.out.println("false"); }
    }
}
