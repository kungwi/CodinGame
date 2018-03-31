package training.community;
import java.util.*;

public class Maze {
    
    private static class point implements Comparable<point>{
        public int x ; 
        public int y ; 
        
        @Override
        public int compareTo(point p2) {
            if (this.y<p2.y) return -1 ;
            else if (p2.y<this.y) return 1 ;
            else return Integer.compare(this.x, p2.x); } }
    
    public static void main(String args[]) {
        Stack<point> solve = new Stack <> () ;
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int X = in.nextInt();
        int Y = in.nextInt();
        int exits = 0 ;
        char[][] maze = new char[25][25]  ;
        point[] exlist = new point[100] ;
        in.nextLine() ;
        for (int i=0 ; i<H ; i++) {
            String R = in.nextLine();
            for(int k=0 ; k<W ; k++)
                maze[i][k] = R.charAt(k) ; }
        
        point start = new point() , temp = new point() ; 
        start.x = X ; 
        start.y = Y ;
        solve.push(start) ;
        maze[X][Y] = 'x' ;

        while(!solve.empty()) { 
            temp = solve.pop() ;
        
            if ((temp.x==0)||(temp.x==H-1)||(temp.y==0)||(temp.y==W-1)) {
                exlist[exits] = new point() ;
                exlist[exits].x = temp.x ; exlist[exits].y = temp.y ; 
                exits++ ; }
        
            if (temp.x>0&&maze[temp.x-1][temp.y]=='.') {
                point next = new point() ;
                next.x = temp.x - 1 ; next.y = temp.y ;
                maze[next.x][next.y]='x' ;
                solve.push(next) ; }

            if (temp.y>0&&maze[temp.x][temp.y-1]=='.') {
                point next = new point() ;
                next.x = temp.x ; next.y = temp.y - 1 ;
                maze[next.x][next.y]='x' ;
                solve.push(next) ; } 

            if (temp.x<H-1&&maze[temp.x+1][temp.y]=='.') {
                point next = new point() ;
                next.x = temp.x + 1 ; next.y = temp.y ;
                maze[next.x][next.y]='x' ;
                solve.push(next) ; }

            if (temp.y<W-1&&maze[temp.x][temp.y+1]=='.') {
                point next = new point() ;
                next.x = temp.x ; next.y = temp.y + 1 ;
                maze[next.x][next.y]='x' ;
                solve.push(next) ; } }

        point[] exlist2 = new point[exits] ;
        for(int i=0 ; i<exits ; i++) exlist2[i] = exlist[i] ;
        Arrays.sort(exlist2) ;
        System.out.println(exits) ;
        for(int i=0 ; i<exits ; i++) 
            System.out.println(exlist2[i].y + " " + exlist2[i].x) ; }    
}
