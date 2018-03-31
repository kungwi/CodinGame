package training.community;
import java.util.*;

public class TheHighestBuilding {
    private static char[][] board = new char[20][200] ;
    private static int nb=-1 , W , H ;
    private static int[] st = new int[50] , en = new int[50] ;

    private static void mark(int i , int j , int n) {
        board[i][j]='#' ;
        if (j<st[n]) st[n]=j ;
        if (j>en[n]) en[n]=j ;
        if (i>0&&board[i-1][j]=='*') mark(i-1,j,n) ;  
        if (j>0&&board[i][j-1]=='*') mark(i,j-1,n) ;
        if (i<H&&board[i+1][j]=='*') mark(i+1,j,n) ;
        if (j<W&&board[i][j+1]=='*') mark(i,j+1,n) ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        W = in.nextInt() ; H = in.nextInt();
        in.nextLine();
        int i ;
        for (i=0 ; i<H ; i++) {
            String ROW = in.nextLine();
            for(int k=0 ; k<ROW.length() ; k++)
                if (ROW.charAt(k)=='#') board[i][k]='*' ;
                else board[i][k]=' ' ; }
        
        for(i=0 ; i<H ; i++) {
            boolean found = false ; 
            for (int j=0 ; j<W ; j++)
                if (board[i][j]=='*') {
                    found=true ;
                    nb++ ; st[nb]=W ; en[nb]=-1; 
                    mark(i,j,nb) ; }
            if (found) break ; }  
        
        for(int k=0 ; k<=nb ; k++) {
            for(int l=i ; l<H ; l++) {
                int fin=en[k] ;
                while(board[l][fin]==' ') fin-- ;
                for(int j=st[k] ; j<=fin ; j++) System.out.print(board[l][j]) ;
                System.out.println(); }
            if (k<nb) System.out.println(); } }    
}
