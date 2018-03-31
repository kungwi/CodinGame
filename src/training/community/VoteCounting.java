package training.community;
import java.util.*;

public class VoteCounting {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        
        String[] name = new String[20] ;
        int[] nvotes = new int[20] , yes = new int[20] , no = new int[20] ;

        for (int i = 0; i < N; i++) {
            String personName = in.next();
            int nbVote = in.nextInt();
            name[i] = personName ; 
            nvotes[i] = nbVote ; }
        
        for (int i=0 ; i<N ; i++) yes[i]=no[i]=0 ;
        
        for (int i = 0; i < M; i++) {
            String voterName = in.next();
            String voteValue = in.next();
            int k ;
            for (k=0 ; k<N ; k++) 
                if (voterName.compareTo(name[k])==0) break ;
            nvotes[k]-- ; 
            if (voteValue.compareTo("Yes")==0) yes[k]++ ; 
            else if (voteValue.compareTo("No")==0) no[k]++ ; }

        int y=0 , n=0 ;
        for (int i=0 ; i<N ; i++) {
            if (nvotes[i]>=0) { y+=yes[i] ; n+=no[i] ; } }

        System.out.println(y+" "+n); }
}
