package training.community;
import java.util.*;

public class ChessMovesOnFENPosition {
    
    private static char[][] board = new char[8][8] ;
    
    private static void FENtoBoard(String str) {
        StringBuilder s = new StringBuilder(str) ;
        for(int k=0 ; k<s.length() ; k++) 
            if (s.charAt(k)=='/') s.replace(k, k+1, " ") ;
        
        Scanner partial = new Scanner(s.toString()) ;
        String line ;

        for(int i=0 ; i<8 ; i++) {
            line = partial.next() ;
            int j=0 , y=0 ;
            while(j<line.length()) {
                if (line.charAt(j)>='1'&&line.charAt(j)<='8') {
                    int val=line.charAt(j)-'0' ;
                    for(int k=y ; k<y+val ; k++) board[i][k]='.' ;
                    y+=val ; }
                else { board[i][y]=line.charAt(j) ; y++ ; }   
                j++ ; } } }
    
    private static String strToFEN() {
        String fen = "" ;
        for(int i=0 ; i<8 ; i++) {
            String line = "" ; int j=0 ;
    
            while(j<8) {
                int val=0 ; while((j<8)&&(board[i][j]=='.')) { val++ ; j++ ;}
                if (val>0) line += val ;
                else { line += board[i][j] ; j++ ; } }
    
        if (i==0) fen=line ; else fen += "/"+line ; }
        return fen ;    }

    private static boolean kingQ(int x , int y) { 
        return board[x][y]=='k'||board[x][y]=='K' ; }

    private static boolean pawnQ(int x , int y) { 
        return board[x][y]=='p'||board[x][y]=='P' ; }
    
    private static int abs(int x) {
        if (x>0) return x ; else return -x ;}
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String B = in.nextLine();
        FENtoBoard(B) ;
        boolean capture ;
        int N = in.nextInt();
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String M = in.nextLine();
            int stx , sty , enx , eny ;
            sty = M.charAt(0)-'a' ; stx=8-M.charAt(1)+'0' ;
            eny = M.charAt(2)-'a' ; enx=8-M.charAt(3)+'0' ;
        
            if (board[enx][eny]=='.') capture = false ; else capture = true ;
            board[enx][eny]=board[stx][sty] ; board[stx][sty] = '.' ;
        
            if (kingQ(enx,eny)&&(abs(sty-eny)==2)) { 
                if (eny==6) { 
                    board[enx][5]=board[enx][7]; board[enx][7]='.'; }
                else {
                    board[enx][3]=board[enx][0]; board[enx][0]='.'; } }            
            else  if (!capture&&pawnQ(enx,eny)&&(abs(sty-eny)==abs(stx-enx))) {    
                if (enx>stx) board[enx-1][eny]='.';
                else  board[enx+1][eny]='.'; }
            else if (pawnQ(enx,eny)&&(enx==0||enx==7)) board[enx][eny] = M.charAt(4) ; }

        System.out.println(strToFEN()) ; }   
}
