package training.community;
import java.util.*;

public class ChessCavalry {
    
    private static class point {
        public int x ; 
        public int y ; 
        public int ds ; }
 
    public static void main(String args[]) {
        char[][] board = new char[10][10] ;
        point st = new point() , en = new point() ;
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        Queue<point> solve = new LinkedList<point>();
        
        for (int i = 0; i < H; i++) {
            String ROW = in.next();
            for(int j=0 ; j<W ; j++) {
                if (ROW.charAt(j)=='.') board[i][j]='.' ;
                else if (ROW.charAt(j)=='B') {
                    st.x = i ; st.y = j ; st.ds = 0 ;
                    board[i][j] = '#' ; }
                else if (ROW.charAt(j)=='E') {
                    en.x = i ; en.y = j ; en.ds = -1 ;
                    board[i][j] = '.' ; }
                else board[i][j]='#' ; } }

        while(!solve.isEmpty()) solve.poll(); 
        solve.add(st) ;

        while(!solve.isEmpty()) {
            point temp=solve.peek() ; solve.poll() ; 
            int i=temp.x , j=temp.y ;
        
            if ((i==en.x)&&(j==en.y)) { en.ds = temp.ds ; break ; }
        
            if ((i>0)&&(j>1)&&(board[i-1][j-2]=='.')) {
                point next = new point() ; 
                board[i-1][j-2]='#' ;
                next.x=i-1 ; next.y=j-2 ; next.ds=temp.ds+1 ;
                solve.add(next) ;}
            
            if ((i>1)&&(j>0)&&(board[i-2][j-1]=='.')) {
                point next = new point() ; 
                board[i-2][j-1]='#' ;
                next.x=i-2 ; next.y=j-1 ; next.ds=temp.ds+1 ;
                solve.add(next) ;}
        
            if ((i>1)&&(j<W-1)&&(board[i-2][j+1]=='.')) {
                point next = new point() ; 
                board[i-2][j+1]='#' ;
                next.x=i-2 ; next.y=j+1 ; next.ds=temp.ds+1 ;
                solve.add(next) ;}

            if ((i>0)&&(j<W-2)&&(board[i-1][j+2]=='.')) {
                point next = new point() ; 
                board[i-1][j+2]='#' ;
                next.x=i-1 ; next.y=j+2 ; next.ds=temp.ds+1 ;
                solve.add(next) ;}

            if ((i<H-1)&&(j<W-2)&&(board[i+1][j+2]=='.')) {
                point next = new point() ; 
                board[i+1][j+2]='#' ;
                next.x=i+1 ; next.y=j+2 ; next.ds=temp.ds+1 ;
                solve.add(next) ;}

            if ((i<H-2)&&(j<W-1)&&(board[i+2][j+1]=='.')) {
                point next = new point() ; 
                board[i+2][j+1]='#' ;
                next.x=i+2 ; next.y=j+1 ; next.ds=temp.ds+1 ;
                solve.add(next) ;}

            if ((i<H-2)&&(j>0)&&(board[i+2][j-1]=='.')) {
                point next = new point() ; 
                board[i+2][j-1]='#' ;
                next.x=i+2 ; next.y=j-1 ; next.ds=temp.ds+1 ;
                solve.add(next) ;}

            if ((i<H-1)&&(j>1)&&(board[i+1][j-2]=='.')) {
                point next = new point() ; 
                board[i+1][j-2]='#' ;
                next.x=i+1 ; next.y=j-2 ; next.ds=temp.ds+1 ;
                solve.add(next) ;} }
        
        if (en.ds<0) System.out.println("Impossible") ;
        else System.out.println(en.ds) ; }   
}
