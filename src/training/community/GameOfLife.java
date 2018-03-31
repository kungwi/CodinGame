/*           
    for(int i=0 ; i<height ; i++) {
        for(int j=0 ; j<width ; j++) 
            cout << nex[i][j] ; 
        cout << endl ; }
 */
package training.community;
import java.util.*;

public class GameOfLife {
    
    private static int[][] board = new int[105][105], nex = new int[105][105] ;
    private static int height , width ;

    private static int val(int i , int j) {
        int sum=0 , k , l ;
        if (i>0&&j>0&&board[i-1][j-1]==1) sum++ ;
        if (i>0&&board[i-1][j]==1) sum++ ;    
        if (i>0&&j<width-1&&board[i-1][j+1]==1) sum++ ;
        if (j<width-1&&board[i][j+1]==1) sum++ ;
        if (i<height-1&&j<width-1&&board[i+1][j+1]==1) sum++ ;  
        if (i<height-1&&board[i+1][j]==1) sum++ ;
        if (i<height&&j>0&&board[i+1][j-1]==1) sum++ ;    
        if (j>0&&board[i][j-1]==1) sum++ ;
    return sum ; }    

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        width = in.nextInt();
        height = in.nextInt();
        for (int i = 0; i < height; i++) {
            String line = in.next();
            for (int j=0 ; j<width ; j++)
                board[i][j] = line.charAt(j)-'0' ; }

        for(int i=0 ; i<height ; i++) 
            for(int j=0 ; j<width ; j++) {
                int ng = val(i,j) ;
                if (board[i][j]==1&&ng<2) nex[i][j]=0 ;
                else if (board[i][j]==1&&ng<4) nex[i][j]=1 ;
                else if (board[i][j]==1) nex[i][j]=0 ;
                else if (ng==3) nex[i][j]=1 ;
                else nex[i][j]=0; }  
        
        String answer = "" ;
        for(int i=0 ; i<height ; i++) {
            for(int j=0 ; j<width ; j++) 
                answer += nex[i][j] ; 
            answer += "\n" ; }
        
        System.out.println(answer) ; }    
}
