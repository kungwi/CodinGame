package training.community;
import java.util.*;

/**
 *
 * @author thales
 */
public class SandpileAddition {
    
    private static int fours = 0 ;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) in.nextLine();
        
        int[][] board = new int[n][n] ;
        
        for(int k=0 ; k<2 ; k++) {
            for (int i = 0; i < n; i++) {
                String row = in.nextLine();
                for(int j=0 ; j<n ; j++) {
                    board[i][j] += row.charAt(j) - '0' ; 
                    if (k*board[i][j]>3) fours++ ; } } }
        
        while(fours>0) {
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) 
                    while (board[i][j]>3) { 
                        board[i][j] -= 4 ;
                        if (board[i][j]<4) fours-- ;
                        if (i>0) { 
                            board[i-1][j]++ ; 
                            if (board[i-1][j]==4) fours++ ; }
                        if (j>0) { 
                            board[i][j-1]++ ; 
                            if (board[i][j-1]==4) fours++ ; }
                        if (i<n-1) { 
                            board[i+1][j]++ ; 
                            if (board[i+1][j]==4) fours++ ; }
                        if (j<n-1) { 
                            board[i][j+1]++ ; 
                            if (board[i][j+1]==4) fours++ ; } 
                        if (fours==0) break ; }  
                if (fours==0) break ; } }
        
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n-1 ; j++)
                System.out.print(board[i][j]);
            System.out.println(board[i][n-1]) ; } }
    
}
