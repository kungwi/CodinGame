package training.community;
import java.util.*;

public class ConnectFour {
    
    private static int[][] board = new int[10][10] ;

    private static boolean wonQ(int p) {
        int i,j ;
        boolean res=false ;

        for(i=0 ; i<6 ; i++)
            for(j=0 ; j<7 ; j++)
                if (board[i][j]==p) {
                    if (i<3) {
                        res=true ;
                        for(int k=1 ; k<=3 ; k++)
                            if (board[i+k][j]!=p) { res=false ; break ; } 
                        if (res) return res ; }
                    if (j<4) {
                        res=true ;
                        for(int k=1 ; k<=3 ; k++)
                            if (board[i][j+k]!=p) { res=false ; break ; } 
                        if (res) return res ; }
                    if (i<3&&j<4) {
                        res=true ;
                        for(int k=1 ; k<=3 ; k++)
                            if (board[i+k][j+k]!=p) { res=false ; break ; } 
                        if (res) return res ; }
                    if (i<3&&j>2) {
                        res=true ;
                        for(int k=1 ; k<=3 ; k++)
                            if (board[i+k][j-k]!=p) { res=false ; break ; } 
                        if (res) return res ; } } 
    return false ; }

    private static void makeMove(int col , int p) {
        int k=5 ; while(k>=0&&board[k][col]!=0) k-- ;    
        if (k>=0) board[k][col]=p ; }    
    
    private static void deleteMove(int col) {
        int k=0 ; while(board[k][col]==0) k++ ;
        board[k][col]=0 ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            String line = in.next();
            for(int j=0 ; j<line.length() ; j++)
                if (line.charAt(j)=='.') board[i][j]=0 ;
                else board[i][j]=line.charAt(j)-'0' ; }
        
        for(int p=1 ; p<=2 ; p++) {
            boolean found=false , first=true ;
            for(int col=0 ; col<7 ; col++) {
                makeMove(col,p) ;
                if (wonQ(p)) {
                    if (!first) System.out.print(" ") ;
                    first=false ;
                    System.out.print(col) ;
                    found=true ; }
                deleteMove(col) ; }
            if (!found) System.out.println("NONE") ;
            else System.out.println() ; } }    
}
