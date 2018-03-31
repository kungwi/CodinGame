package training.community;
import java.util.*;

public class LangtonsAnt {
    
    private static char[] d = {'N' , 'E' , 'S' , 'W'} ;
    private static int w , h ;
    private static char[][] board = new char[500][500] ;
    
    private static void printBoard() {
        for(int i=0 ; i<h ; i++) {
            for(int j=0 ; j<w ; j++)
                System.out.print(board[i][j]) ;
            System.out.println() ; } }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        w = in.nextInt(); h = in.nextInt();
        int x = in.nextInt() , y = in.nextInt() , dir=0 ;
        in.nextLine();
        char direc = in.nextLine().charAt(0);
        for(int k=0 ; k<4 ; k++) 
            if (d[k]==direc) { dir=k ; break ; }
        int T = in.nextInt();
        in.nextLine();
        for (int i=0 ; i<h ; i++) {
            String C = in.nextLine();
            for(int j=0 ; j<w ; j++) 
                board[i][j]=C.charAt(j) ; }
        
        for(int i=0 ; i<T ; i++) {
            if (board[x][y]=='#') { 
                dir = (dir+1)%4 ;
                board[x][y]='.' ; }
            else {
                dir-- ; if (dir<0) dir=3 ;
                board[x][y]='#' ; }
        
            if (dir==0) x-- ;
            else if (dir==1) y++ ;
            else if (dir==2) x++ ;
            else if (dir==3) y-- ; }    
        
        printBoard() ; }    
}
