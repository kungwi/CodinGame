package training.community;
import java.util.*;

public class SnakeEncoding {

    private static char[][] board = new char[25][25] ;
    private static int N ;

    private static void step() {
        char next , prev ;
        if (N%2==1) prev=board[0][N-1] ; else prev=board[N-1][N-1] ;

        for(int j=0 ; j<N ; j++) {
            if (j%2==1) {
                next=board[N-1][j] ; 
                for(int i=N-1 ; i>0 ; i--) board[i][j]=board[i-1][j] ;
                board[0][j]=prev ;
                prev=next ; } 
            else { 
                next=board[0][j] ; 
                for(int i=0 ; i<N-1 ; i++) board[i][j]=board[i+1][j] ;
                board[N-1][j]=prev ;
                prev=next ; } } }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int X = in.nextInt();
        X=X%(N*N) ;
        for (int i = 0; i < N; i++) {
            String LINE = in.next();
            for(int k=0 ; k<N ; k++) board[i][k] = LINE.charAt(k) ; }
        
        for(int i=0 ; i<X ; i++) step() ;
        
        String answer = "" ;
        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<N ; j++)
                answer += board[i][j] ;
            answer += "\n" ; }

        System.out.print(answer); }    
}
