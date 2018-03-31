package training.community;
import java.util.*;

public class CGFungeInterpreter {

    private static char[][] prog = new char[20][100] ;
    private static char dir='r' ;  
    private static int x=0 , y=0 , ascii=0 ;

    private static void movepr(int s) {
        switch(dir) {
            case 'r' : y+=s ; break ;
            case 'u' : x-=s ; break ;
            case 'l' : y-=s ; break ;
            case 'd' : x+=s ; break ;
            default: } }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String line = in.nextLine();
            for(int j=0 ; j<line.length() ; j++) 
                prog[i][j] = line.charAt(j) ; }
        
        int val1=0 , val2=0 ;
        Stack <Integer> prst = new Stack <Integer> ();
        while(!prst.empty()) prst.pop() ;
        
        while(prog[x][y]!='E') {
            if (prog[x][y]=='"') { ascii = (ascii+1)%2 ; movepr(1) ; }
            else if (ascii==1) { prst.push((int) prog[x][y]) ; movepr(1) ; }
            else
                switch (prog[x][y]) {
                    case ' ' : movepr(1) ; break ;
                    case '>' : y++ ; dir='r' ; break ;
                    case '^' : x-- ; dir='u' ; break ;
                    case '<' : y-- ; dir='l' ; break ;
                    case 'v' : x++ ; dir='d' ; break ;
                    case 'S' : movepr(2) ; break ;
                    case 'E' : break ;
                    case 'P' : prst.pop() ; movepr(1) ; break ;
                    case 'X' : val1 = prst.pop() ;
                               val2 = prst.pop() ;
                               prst.push(val1) ;
                               prst.push(val2) ;
                               movepr(1) ; break ;
                    case 'D' : int val ; val = prst.peek() ;
                               prst.push(val) ;
                               movepr(1) ; break ;    
                    case 'C' : int temp = prst.pop() ;    
                               System.out.print((char) temp) ;
                               movepr(1) ; break ;
                    case 'I' : val1 = prst.pop() ;
                               System.out.print(val1) ; 
                               movepr(1) ; break ;
                    case '+' : val1 = prst.pop() ;
                               val2 = prst.pop() ;
                               prst.push(val1+val2) ;
                               movepr(1) ; break ;                       
                    case '-' : val1 = prst.pop() ;
                               val2 = prst.pop() ;
                               prst.push(val2-val1) ;
                               movepr(1) ; break ;                       
                    case '*' : val1 = prst.pop() ;
                               val2 = prst.pop() ;
                               prst.push(val1*val2) ;
                               movepr(1) ; break ;                       
                    case '_' : val1 = prst.pop() ;
                               if (val1!=0) dir='l' ; else dir='r' ;
                               movepr(1) ; break ;
                    case '|' : val1 = prst.pop() ;
                               if (val1!=0) dir='u' ; else dir='d' ;
                               movepr(1) ; break ;
                    default : prst.push(prog[x][y]-'0') ;
                               movepr(1) ; } } }    
}
