package training.community;
import java.util.*;

public class DrawingPolygons {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int px=in.nextInt() , py=in.nextInt() , fx , fy , sm=0 ;
        fx = px ; fy = py ;
        for (int i = 1; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            sm += (x-px)*(y+py) ;
            px = x ; py=y ; }

        sm += (fx-px)*(fy+py) ;
        if (sm>0) System.out.println("CLOCKWISE") ;
        else System.out.println("COUNTERCLOCKWISE") ; }    
}
