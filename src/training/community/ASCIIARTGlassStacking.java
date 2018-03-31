package training.community;
import java.util.*;

public class ASCIIARTGlassStacking {
    private static char[][] pyramid = new char[30][50] ;
    
    private static void printGlass(int i , int j) {
        for(int k=j ; k<j+5 ; k++) pyramid[i][k]='*' ;
        for(int k=j+1 ; k<j+4 ; k++) pyramid[i-3][k]='*' ;
        pyramid[i-1][j+1] = pyramid[i-1][j+3] = '*' ;
        pyramid[i-2][j+1] = pyramid[i-2][j+3] = '*' ;    
    return ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        int n=1 , sm=0 ;
        while(sm + n <= N) { sm += n ; n++ ; } n-- ;
        int width = 6*n-1 , height=4*n ;
        
        for(int i=0 ; i<height ; i++) 
            for(int j=0 ; j<width ; j++)
                pyramid[i][j] = ' ' ;

        for(int l=n ; l>0 ; l--)
            for(int k=1 ; k<=l ; k++)
                printGlass(l*4-1,6*(k-1)+3*(n-l)) ;

        String answer = "" ;
        for(int i=0 ; i<height ; i++) {
            for(int j=0 ; j<width ; j++)
                answer += pyramid[i][j] ;
            answer += "\n" ; } 
        System.out.print(answer) ; }    
}
