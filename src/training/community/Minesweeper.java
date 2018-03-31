package training.community;
import java.util.*;

public class Minesweeper {
    
    private static int mines , h , w , empty=0 ;
    private static int[][] board = new int[30][30] ;

    private static int cmines(int i , int j) {
        int res=0 ;    
        if (i>0&&board[i-1][j]<0) res++ ;
        if (i>0&&j<w-1&&board[i-1][j+1]<0) res++ ;
        if (j<w-1&&board[i][j+1]<0) res++ ;
        if (i<h-1&&j<w-1&&board[i+1][j+1]<0) res++ ;
        if (i<h-1&&board[i+1][j]<0) res++ ;
        if (i<h-1&&j>0&&board[i+1][j-1]<0) res++ ;    
        if (j>0&&board[i][j-1]<0) res++ ;
        if (i>0&&j>0&&board[i-1][j-1]<0) res++ ;
    return res ; }

    private static int crmines(int i , int j) {
        int res=0 ;    
        if (i>0&&board[i-1][j]==-1) res++ ;
        if (i>0&&j<w-1&&board[i-1][j+1]==-1) res++ ;
        if (j<w-1&&board[i][j+1]==-1) res++ ;
        if (i<h-1&&j<w-1&&board[i+1][j+1]==-1) res++ ;
        if (i<h-1&&board[i+1][j]==-1) res++ ;
        if (i<h-1&&j>0&&board[i+1][j-1]==-1) res++ ;    
        if (j>0&&board[i][j-1]==-1) res++ ;
        if (i>0&&j>0&&board[i-1][j-1]==-1) res++ ;
    return res ; }

    private static void put_mines(int i , int j) {
        if (i>0&&board[i-1][j]<-1) {mines--; board[i-1][j]=-1; empty--;}
        if (i>0&&j<w-1&&board[i-1][j+1]<-1) {mines--; board[i-1][j+1]=-1; empty--;}
        if (j<w-1&&board[i][j+1]<-1) {mines--; board[i][j+1]=-1; empty--;}
        if (i<h-1&&j<w-1&&board[i+1][j+1]<-1) {mines--; board[i+1][j+1]=-1; empty--;}
        if (i<h-1&&board[i+1][j]<-1) {mines--; board[i+1][j]=-1; empty--;}   
        if ((i<h-1)&&(j>0)&&(board[i+1][j-1]<-1)) { 
            mines-- ; board[i+1][j-1]=-1 ; empty-- ; }    
        if (j>0&&board[i][j-1]<-1) {mines-- ; board[i][j-1]=-1 ; empty-- ; }
        if (i>0&&j>0&&board[i-1][j-1]<-1) {mines-- ; board[i-1][j-1]=-1 ; empty-- ; }
    return ; }

    private static void mark_blanks(int i , int j) {
        if (i>0&&board[i-1][j]<-1) {board[i-1][j]=0; empty--;}
        if (i>0&&j<w-1&&board[i-1][j+1]<-1) {board[i-1][j+1]=0; empty--;}
        if (j<w-1&&board[i][j+1]<-1) {board[i][j+1]=0; empty--;}
        if (i<h-1&&j<w-1&&board[i+1][j+1]<-1) {board[i+1][j+1]=0; empty--;}
        if (i<h-1&&board[i+1][j]<-1) {board[i+1][j]=0; empty--;}
        if (i<h-1&&j>0&&board[i+1][j-1]<-1) {board[i+1][j-1]=0; empty--;}    
        if (j>0&&board[i][j-1]<-1) {board[i][j-1]=0; empty--;}
        if (i>0&&j>0&&board[i-1][j-1]<-1) {board[i-1][j-1]=0; empty-- ;}
    return ; }
    
    private static void solve() {
        for(int i=0 ; i<h ; i++)
            for(int j=0 ; j<w ; j++) {
                if (board[i][j]>0) {
                    if (crmines(i,j)==board[i][j]) mark_blanks(i,j) ;
                    else if (cmines(i,j)==board[i][j]) put_mines(i,j) ; } } }
    
    private static void put_all() {
        for(int i=0 ; i<h ; i++) 
            for(int j=0 ; j<w ; j++)    
                if (board[i][j]==-2) {
                board[i][j]=-1 ; mines-- ; } }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        h = in.nextInt();
        w = in.nextInt();
        mines = in.nextInt();
        in.nextLine();
        for (int i = 0; i < h; i++) {
            String line = in.nextLine();
            for(int j=0 ; j<w ; j++) {
                if (line.charAt(j)=='.') board[i][j]=0 ;
                else if (line.charAt(j)=='?') { board[i][j]=-2 ; empty++ ; }
                else board[i][j]=line.charAt(j)-'0' ; } }
        
        while(mines>0) { solve() ; if (empty==mines) put_all() ; }
        
        for (int i=0 ; i<w ; i++) 
            for(int j=0 ; j<h ; j++) 
                if (board[j][i]==-1) System.out.println(i+" "+j) ;  }    
}