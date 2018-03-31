package training.community;
import java.util.*;

public class SlidingPuzzle {
    
    private static int[][] board = new int[15][15] ; 
    private static int H , W , ans=20 ;
    
    private static boolean solvedQ() {
        int n=1 ;     
        for(int i=0 ; i<H ; i++)
            for(int j=0 ; j<W ; j++) {
                if (i==H-1&&j==W-1) break ;
                if (board[i][j]!=n) return false ;
                n++ ; }
        return true ; }
    
    private static void solve(int x , int y , int moves) {
        if (solvedQ()) { if (moves<ans) ans=moves ; return ; }
        if (moves==10||moves>=ans-1) return ;
    
        if (x>0) { 
            int temp=board[x-1][y] ;
            board[x][y]=temp ; board[x-1][y]=0 ;
            solve(x-1,y,moves+1) ;
            board[x-1][y]=temp ; board[x][y]=0 ; }
        if (y>0) { 
            int temp=board[x][y-1] ;
            board[x][y]=temp ; board[x][y-1]=0 ;
            solve(x,y-1,moves+1) ;
            board[x][y-1]=temp ; board[x][y]=0 ; }
        if (x<H-1) { 
            int temp=board[x+1][y] ;
            board[x][y]=temp ; board[x+1][y]=0 ;
            solve(x+1,y,moves+1) ;
            board[x+1][y]=temp ; board[x][y]=0 ; }
        if (y<W-1) { 
            int temp=board[x][y+1] ;
            board[x][y]=temp ; board[x][y+1]=0 ;
            solve(x,y+1,moves+1) ;
            board[x][y+1]=temp ; board[x][y]=0 ; } 
    return ; }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        H = in.nextInt(); W = in.nextInt();
        in.nextLine();
        int bx=0 , by=0 ;   
        for (int i = 0; i < H; i++) {
            String line = in.nextLine();
            Scanner partial = new Scanner(line) ;
            for(int j=0 ; j<W ; j++) {
                String num = partial.next() ;
                if (num.charAt(0)=='.') { board[i][j]=0 ; bx=i ; by=j ; }
                else {
                    int val=num.charAt(0)-'0' ;
                    for(int k=1 ; k<num.length() ; k++) 
                        val = 10*val+num.length()-'0' ;
                    board[i][j] = val ; } } }
            
        solve(bx,by,0) ;    
        System.out.println(ans); }    
}
