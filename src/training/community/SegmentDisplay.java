package training.community;
import java.util.*;

public class SegmentDisplay {

private static boolean[][] mat = new boolean[400][400] ;
private static int[][] digit = { {1,1,1,1,1,1,0},{0,0,1,1,0,0,0},{0,1,1,0,1,1,1},
                                 {0,1,1,1,1,0,1},{1,0,1,1,0,0,1},{1,1,0,1,1,0,1}, 
                                 {1,1,0,1,1,1,1},{0,1,1,1,0,0,0},{1,1,1,1,1,1,1},
                                 {1,1,1,1,1,0,1}} ;
private static int[] ndig = new int[20] , ndigr = new int[20] ;
private static int n=0 ;
 
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong() ;
        while(N>0) { ndigr[n++]=(int)(N%10) ; N/=10 ; }
        for(int i=0 ; i<n ; i++) ndig[i]=ndigr[n-1-i] ;
        
        in.nextLine();
        String C = in.nextLine();
        int S = in.nextInt();
        int len = n*(S+3)-1 ;

        for(int i=0 ; i<=len ; i++)
            for(int j=0 ; j<=2*S+3 ; j++)
                mat[j][i]=false ;
    
        // first line
        for(int i=0 ; i<n ; i++) 
            if (digit[ndig[i]][1]==1) 
                for(int j=(S+3)*i+1; j<=(S+3)*i+S ; j++) mat[0][j] = true ;

        // middle line                 
        for(int i=0 ; i<n ; i++) 
            if (digit[ndig[i]][6]==1) 
                for(int j=(S+3)*i+1; j<=(S+3)*i+S ; j++) mat[S+1][j] = true ;     
            
        // end line                 
        for(int i=0 ; i<n ; i++) 
            if (digit[ndig[i]][4]==1) 
                for(int j=(S+3)*i+1; j<=(S+3)*i+S ; j++) mat[2*S+2][j] = true ;   

        // first middle
        for(int k=1 ; k<=S ; k++) 
            for(int i=0 ; i<n ; i++) {
                if (digit[ndig[i]][0]==1) mat[k][(S+3)*i]=true ; 
                if (digit[ndig[i]][2]==1) mat[k][(S+3)*i+S+1]=true ; }
            
        // second middle
        for(int k=S+2 ; k<=2*S+1 ; k++) 
            for(int i=0 ; i<n ; i++) {
                if (digit[ndig[i]][5]==1) mat[k][(S+3)*i]=true ;
                if (digit[ndig[i]][3]==1) mat[k][(S+3)*i+S+1]=true ; }

        int[] limits = new int[25] ;
        for(int k=0 ; k<=2*S+2 ; k++) {
            int pos=n*(S+3)-1 ;
            while (!mat[k][pos]) pos-- ;
            limits[k] = pos ; }
        
        for(int k=0 ; k<=2*S+2 ; k++) {
            for(int i=0 ; i<=limits[k] ; i++)
                if (mat[k][i]) System.out.print(C); 
            else System.out.print(" ");
        System.out.println(); } 
    }    
}
