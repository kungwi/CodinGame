package training.community;
import java.util.*;

public class QuarternionMultiplication {
    
    private static boolean numQ(char c) { return (c>='0'&&c<='9') ; }
    private static int[][] q = new int[100][4] ;
    private static int n=0 ;
    private static int[] m = new int[4] ; 
    
    private static void stringToQuart(String str) {
        
        StringBuilder s = new StringBuilder(str) ;
        for(int k=s.length()-1 ; k>=0 ; k--)
            if (s.charAt(k)=='i'||s.charAt(k)=='j'||s.charAt(k)=='k')
                s.insert(k+1," ") ;
        
        int ipos=-1 ;
        for(int k=0 ; k<s.length() ; k++)
            if (s.charAt(k)=='i') { ipos=k ; break ; }
            if (ipos==-1) { s.insert(0,"0i "); ipos=1 ; }
        
        int jpos=-1 ;
        for(int k=0 ; k<s.length() ; k++)
            if (s.charAt(k)=='j') { jpos=k ; break ; }
            if (jpos==-1) { s.insert(ipos+1," 0j "); jpos=ipos+3 ; }
        
        int kpos=-1 ;
        for(int k=0 ; k<s.length() ; k++)
            if (s.charAt(k)=='k') { kpos=k ; break ; }
            if (kpos==-1) { s.insert(jpos+1," 0k "); kpos=jpos+3 ; }
        
        if (ipos==0) s.replace(ipos, ipos+1, "1") ;
        else if (!numQ(s.charAt(ipos-1))) s.replace(ipos, ipos+1, "1") ;
        else s.replace(ipos, ipos+1 , " ") ;

        if (!numQ(s.charAt(jpos-1))) s.replace(jpos, jpos+1, "1") ;
        else s.replace(jpos, jpos+1, " ") ;
 
        if (!numQ(s.charAt(kpos-1))) s.replace(kpos, kpos+1, "1") ;
        else s.replace(kpos, kpos+1, " ") ;
        
        Scanner partial = new Scanner(s.toString()) ;
        
        int count=0 , num ;
        while(partial.hasNext()) { 
            num = partial.nextInt() ; 
            q[n][count]=num ; count++ ; }
        
        if (count==3) q[n][3]=0 ; n++ ; } 
    
    private static void mult(int[] q1 , int[] q2) {
        m[0] = q1[1] * q2[2] - q1[2] * q2[1] + q1[0] * q2[3] + q1[3] * q2[0] ;  
        m[1] = q1[2] * q2[0] - q1[0] * q2[2] + q1[1] * q2[3] + q1[3] * q2[1] ;  
        m[2] = q1[0] * q2[1] - q1[1] * q2[0] + q1[2] * q2[3] + q1[3] * q2[2] ;    
        m[3] =-q1[0] * q2[0] - q1[1] * q2[1] - q1[2] * q2[2] + q1[3] * q2[3] ; }
    
    private static void printQuar(int q[]) {   
        boolean first=true ;          
        String quartenion = "" ;
        
        if (q[0]!=0) {
            first=false ;
            if (q[0]==1) quartenion += "i" ;
            else if (q[0]==-1) quartenion += "-i" ;
            else quartenion += q[0]+"i" ; }          

        if (q[1]!=0) {
            if (q[1]==1) 
                if (first) quartenion += "j" ;
                else quartenion += "+j" ;
            else if (q[1]==-1) quartenion += "-j" ;
            else { 
                if (q[1]>0) { 
                    if (first) quartenion +=q[1]+"j" ; 
                    else quartenion += "+"+q[1]+"j" ; } 
                else  quartenion += q[1]+"j" ; }
            first = false ; }  
    
        if (q[2]!=0) {
            if (q[2]==1) 
                if (first) quartenion += "k" ; 
                else quartenion += "+k" ;
            else if (q[2]==-1) quartenion += "-k" ;
            else { 
                if (q[2]>0) { 
                    if (first) quartenion +=q[2]+"k" ; 
                    else quartenion += "+"+q[2]+"k" ; } 
                else  quartenion += q[2]+"k" ; }
            first = false ; }
        
        if (q[3]!=0) {
            if (q[3]<0) quartenion +=q[3] ;
            else {
                if (!first) quartenion += "+" ;
                quartenion +=q[3] ; } }

        System.out.println(quartenion) ; }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        StringBuilder expr = new StringBuilder(in.nextLine()) ;
        
        for(int k=0 ; k<expr.length() ; k++) 
            if (expr.charAt(k)=='('||expr.charAt(k)==')') 
                expr.replace(k, k+1, " ") ;
    
        Scanner partial = new Scanner(expr.toString()) ;
        
        String quar ;
        while(partial.hasNext()) { 
            quar = partial.next() ;
            stringToQuart(quar) ; }
    
        mult(q[0],q[1]) ;
        int[] qtemp = new int[4] ; 
        for(int i=2 ; i<n ; i++) {
            for(int j=0 ; j<4 ; j++) qtemp[j]=m[j] ;
                mult(qtemp,q[i]) ; }

        printQuar(m) ; }    
}
