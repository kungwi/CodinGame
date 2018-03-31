package training.community;
import java.util.*;

public class Othello {

    private static int[][] board = new int[8][8] ;
    private static int bl , wh ;
    private static boolean valid = false ;

    private static void countBoard() {
        wh=bl=0 ;
        for(int i=0 ;i<8 ; i++) 
            for(int j=0 ; j<8 ; j++)
                if (board[i][j]==1) bl++ ;
                else if (board[i][j]==0) wh++ ; }

    private static void checkMove(int x , int y, int c) {
        board[x][y] = c ;
        int j , opc=(c+1)%2 ;

        if (x>1&&y>1&&board[x-1][y-1]==opc) { 
            int k=1 ;
            while(x-k>0&&y-k>0&&board[x-k-1][y-k-1]==opc) k++ ;
            if (x-k>0&&y-k>0&&board[x-k-1][y-k-1]==c) {
                valid=true ;
                for(j=1 ; j<=k ; j++) board[x-j][y-j]=c ; } }

        if (x>1&&board[x-1][y]==opc) { 
            int k=1 ;
            while(x-k>0&&board[x-k-1][y]==opc) k++ ;
            if (x-k>0&&board[x-k-1][y]==c) {
                valid=true ;
                for(j=1 ; j<=k ; j++) board[x-j][y]=c ; } }

        if (x>1&&y<6&&board[x-1][y+1]==opc) { 
            int k=1 ;
            while(x-k>0&&y+k<7&&board[x-k-1][y+k+1]==opc) k++ ;
            if (x-k>0&&y+k<7&&board[x-k-1][y+k+1]==c) {
                valid=true ;
                for(j=1 ; j<=k ; j++) board[x-j][y+j]=c ; } }

        if (y<6&&board[x][y+1]==opc) { 
            int k=1 ;
            while(y+k<7&&board[x][y+k+1]==opc) k++ ;
            if (y+k<7&&board[x][y+k+1]==c) {
                valid=true ;
                for(j=1 ; j<=k ; j++) board[x][y+j]=c ; } }

        if (x<6&&y<6&&board[x+1][y+1]==opc) { 
            int k=1 ;
            while(x+k<7&&y+k<7&&board[x+k+1][y+k+1]==opc) k++ ;
            if (x+k<7&&y+k<7&&board[x+k+1][y+k+1]==c) {
                valid=true ;
                for(j=1 ; j<=k ; j++) board[x+j][y+j]=c ; } }

        if (x<6&&board[x+1][y]==opc) { 
            int k=1 ;
            while(x+k<7&&board[x+k+1][y]==opc) k++ ;
            if (x+k<7&&board[x+k+1][y]==c) {
                valid=true ;
                for(j=1 ; j<=k ; j++) board[x+j][y]=c ; } }

        if (x<6&&y>1&&board[x+1][y-1]==opc) { 
            int k=1 ;
            while(x+k<7&&y-k>0&&board[x+k+1][y-k-1]==opc) k++ ;
            if (x+k<7&&y-k>0&&board[x+k+1][y-k-1]==c) {
                valid=true ;
                for(j=1 ; j<=k ; j++) board[x+j][y-j]=c ; } }

        if (y>1&&board[x][y-1]==opc) { 
            int k=1 ;
            while(y-k>0&&board[x][y-k-1]==opc) k++ ;
            if (y-k>0&&board[x][y-k-1]==c) {
                valid=true ;
                for(j=1 ; j<=k ; j++) board[x][y-j]=c ; } } }
   
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            String row = in.nextLine();
            for (int k=0 ; k<8 ; k++) 
                if (row.charAt(k)=='-') board[i][k]=2 ;
                else if (row.charAt(k)=='W') board[i][k]=0 ; 
                else board[i][k]=1 ; }
        
        int col ;
        String colour = in.next();
        String move = in.next();
        int mx=move.charAt(1)-1-'0' , my=move.charAt(0)-'a' ;
        if (colour.charAt(0)=='W') col=0 ; else col=1 ;

        if (board[mx][my]<2) System.out.println("NOPE") ;
        else {
            checkMove(mx,my,col) ;
        
            if (valid) {
                countBoard() ;
                System.out.println(wh + " " + bl) ; }
            else System.out.println("NULL") ; } }    
}
