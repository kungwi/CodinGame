package training.community;
import java.util.*;

public class AsciiGraph {
    private static char[][] graph = new char[50][50] ;
    private static int[][] point = new int[25][2] ;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int xmin=25 , xmax=-25 , ymin=25 , ymax=-25 ;
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            point[i][0]=x ; point[i][1]=y ;
            if (x<xmin) xmin=x ;
            if (x>xmax) xmax=x ;
            if (y<ymin) ymin=y ;
            if (y>ymax) ymax=y ; }

        if (xmin>0) xmin=-1 ; else xmin-- ;  
        if (ymin>0) ymin=-1 ; else ymin-- ; 
        if (xmax<0) xmax=1 ; else xmax++ ;  
        if (ymax<0) ymax=1 ; else ymax++ ; 
        
        int width=xmax+1-xmin ;
        int height=ymax+1-ymin ;
        int ory = height-1+ymin , orx = -xmin ;

        for(int i=0 ; i<height ; i++)
            for(int j=0 ; j<width ; j++)
                graph[i][j]='.' ;
        
        for(int i=0 ; i<height ; i++) graph[i][orx]='|' ;  
        for(int i=0 ; i<width ; i++) graph[ory][i]='-' ;
        graph[ory][orx] = '+' ;

        for(int i=0 ; i<N ; i++) 
            graph[height-1+ymin-point[i][1]][point[i][0]-xmin]='*' ;
        
        String answer = "" ; 
        for(int i=0 ; i<height ; i++) {
            for(int j=0 ; j<width ; j++)
                answer += graph[i][j] ;
            answer += "\n" ; }    
        System.out.print(answer) ; }
}