package training.community;
import java.util.*;

/**
 *
 * @author thales
 */

public class TuringΜachine {
    
    private static int[] tape ;
    
    private static class rule {
        public String state ;
        public int write ;
        public int direc ;
        
        rule(int w , int d , String s) {
            state = s ; write = w ; direc = d ; } }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        
        int T = in.nextInt();
        tape = new int[T] ;
        
        int pos = in.nextInt();
        if (in.hasNextLine()) in.nextLine();
        
        Map<String, Integer> state = new HashMap<String, Integer>();
        
        String presState = in.nextLine();
        int N = in.nextInt();
        rule[][] rules = new rule[N][S] ;       
        if (in.hasNextLine()) in.nextLine();
        
        for (int i = 0; i < N; i++) { 
            String STATEACTIONS = in.nextLine();
            Scanner s = new Scanner(STATEACTIONS).useDelimiter(":");
            String st = s.next() ;
            state.put(st, i) ;
            String rls = s.next() ;
            s = new Scanner(rls).useDelimiter(";");
            
            for(int j=0 ; j<S ; j++) { 
                Scanner rl = new Scanner(s.next()) ;
                int symbol = rl.nextInt() , d ; 
                char dir = rl.next().charAt(0) ;
                if (dir=='L') d=-1 ; else d=1 ;
                String stat = rl.next() ;
                rules[i][j] = new rule(symbol,d,stat) ;
                rl.close() ; }
            s.close() ; }
        
        int steps = 0 ;
        boolean left=false , right=false , halt = false ;
        
        while(((!left)&&(!right)&&(!halt))) {
            steps++ ;
            int sym = tape[pos] ; 
            int st = state.get(presState) ;
            presState = rules[st][sym].state ;
            tape[pos] = rules[st][sym].write ;
            pos += rules[st][sym].direc ;
            if (pos<0) left=true ;
            else if (pos==T) right=true ;
            else if (presState.equals("HALT")) halt = true ; }
        
        
        System.out.println(steps) ;
        System.out.println(pos) ;
        for(int i=0 ; i<T ; i++)
            System.out.print(tape[i]) ;
        System.out.println(); }
}
