package training.community;
import java.util.*;

public class MiniSudokuSolver {

    static int[][] sud = new int[4][4] , cp = new int[4][4] ;
    static boolean solved=false ;

    private static void solve(int n) {
        int i=0 , j=0 , p , k ;
        
        for(p=n ; p<16 ; p++) {
            i=p/4 ; j=p%4 ;
            if (sud[i][j]==0) break ; }
        
        if (p==16) { solved=true ; return ; }
        
        boolean[] cand = {true, true, true, true, true} ;
        for(k=0 ; k<4 ; k++) {
            if (k==i) continue ;
            cand[sud[k][j]] = false ; }
        for(k=0 ; k<4 ; k++) {
            if (k==j) continue ;
            cand[sud[i][k]] = false ; }          
 
        if (i>1&&j>1) {
            cand[sud[2][2]]=cand[sud[2][3]]=cand[sud[3][2]]=cand[sud[3][3]]=false; }
        else if (i>1&&j<2) {
            cand[sud[2][0]]=cand[sud[2][1]]=cand[sud[3][0]]=cand[sud[3][1]]=false; }   
        else if (i<2&&j>1) {
            cand[sud[0][2]]=cand[sud[0][3]]=cand[sud[1][2]]=cand[sud[1][3]]=false; }   
        else if (i<2&&j<2) {
            cand[sud[0][0]]=cand[sud[0][1]]=cand[sud[1][0]]=cand[sud[1][1]]=false; }   

        for(k=1 ; k<5 ; k++) 
            if (cand[k]&&!solved) { 
                sud[i][j]=k ;
                solve(p+1) ;
                if (solved) break ;
                sud[i][j]=0 ; } }
    
    public static void main(String args[]) {
        int i , j ;  
        String line ;
        Scanner in = new Scanner(System.in) ;
        for(i=0 ; i<4 ; i++) {
            line = in.next() ;
            for(j=0 ; j<4 ; j++)
                sud[i][j] = cp[i][j] = line.charAt(j)-'0' ; }
        
        solve(0) ;   

        for(i=0 ; i<4 ; i++) {
            for(j=0 ; j<4 ; j++) 
                System.out.print(sud[i][j]) ;
            System.out.println() ; } }    
}
