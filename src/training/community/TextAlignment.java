package training.community;
import java.util.*;

public class TextAlignment {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String alignment = in.nextLine();
        int N = in.nextInt() , mxLen=0 ;
        in.nextLine();
        
        String[] text = new String[15] ;
        for (int i = 0; i < N; i++) {
            text[i] = in.nextLine();
            if (text[i].length()>mxLen) mxLen=text[i].length() ; }

        if (alignment.compareTo("LEFT")==0) {
            for(int i=0 ; i<N ; i++) System.out.println(text[i]); }
        else if (alignment.compareTo("RIGHT")==0) {
            for(int i=0 ; i<N ; i++) { 
                for(int k=0 ; k<mxLen-text[i].length() ; k++) 
                    System.out.print(" ");
                System.out.println(text[i]); } }
        else if (alignment.compareTo("CENTER")==0) {
            for(int i=0 ; i<N ; i++) { 
                for(int k=0 ; k<(mxLen-text[i].length())/2 ; k++) 
                    System.out.print(" ");
                System.out.println(text[i]); } }
        else if (alignment.compareTo("JUSTIFY")==0) {
            for(int i=0 ; i<N ; i++) {
                int cb=0 , b=mxLen-text[i].length() ;
                for(int k=0 ; k<text[i].length() ; k++) 
                    if (text[i].charAt(k)==' ') cb++ ;
                b+=cb ;
                if (cb==0) { 
                    System.out.println(text[i]);
                    for(int k=0 ; k<mxLen-text[i].length() ; k++) 
                        System.out.print(" "); }
                else {      
                    Scanner partial = new Scanner(text[i]) ;
                    String wrd = partial.next() ; 
                    System.out.print(wrd);
                    int cnt=1 ;
                    while(cnt<=cb) {
                        int bl=cnt*b/cb - (cnt-1)*b/cb ;
                        for(int p=0 ; p<bl ; p++) System.out.print(" ");
                        wrd = partial.next() ; 
                        System.out.print(wrd);
                        cnt++ ; }
                    System.out.println();  } } } }    
}
