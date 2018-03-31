package training.community;
import java.util.*;

public class DDCGMapper {
    
    public static void main(String args[]) {
        char[][] output = new char[100][4] ;
        for(int i=0 ; i<100 ; i++)
            for(int j=0 ; j<4 ; j++)
                output[i][j] = '0' ;
        
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String pattern = in.next();
            int tempo = in.nextInt();
            for(int k=tempo-1 ; k<L ; k+=tempo)
                for(int l=0 ; l<4 ; l++)
                    if (pattern.charAt(l)=='X') output[k][l]='X' ; }

        for(int i=L-1 ; i>=0 ; i--) {
            for(int j=0 ; j<4 ; j++)
                System.out.print(output[i][j]) ;
        System.out.println(); }
    }    
}

