package training.medium;

import java.util.*;
import java.io.*;
import java.math.*;

public class MayanCalculation {

	private static String[] number = new String[20] ;
	
	private static int mayan_to_dec(String num) {
	    for(int i=0 ; i<20 ; i++)
	        if (num==number[i]) return i ;
	    return -1 ;
	}
	
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        for (int i = 0; i < H; i++) {
            String numeral = in.next();
            for(int k=0 ; k<20 ; k++) number[k] += numeral.substring(k*L,L) ;
        }
        
        int S1 = in.nextInt();
        for (int i = 0; i < S1; i++) {
            String num1Line = in.next();
        }
        int S2 = in.nextInt();
        for (int i = 0; i < S2; i++) {
            String num2Line = in.next();
        }
        String operation = in.next();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("result");
    }
	
}

/*
    
    long long numb1[100] , numb2[100] , ln1=0 , ln2=0 ;
    
    long long S1;
    cin >> S1; cin.ignore();
    long long nnum1 = S1/H ;
    long long num1=0 ;
    for (long long i=0; i<nnum1 ; i++) {
        string num1Line="" ;
        for(long long k=0 ; k<H ; k++) {
            string temp ;
            cin >> temp ;
            num1Line += temp.substr(0,L) ;
        }
        long long dig = mayan_to_dec(num1Line) ;
        numb1[ln1]=dig ; ln1++;
        num1 = num1*20 + dig ;
    }
    for(long long i=ln1 ; i<100 ; i++) numb1[i]=0;
    
    long long S2;
    cin >> S2; cin.ignore();
    long long nnum2 = S2/H ;
    long long num2=0 ;
    for (long long i = 0; i < nnum2; i++) {
        string num2Line = "" ;
         for(long long k=0 ; k<H ; k++) {
            string temp ;
            cin >> temp ;
            num2Line += temp.substr(0,L) ;
        }
        long long dig = mayan_to_dec(num2Line) ;
        numb2[ln2]=dig ; ln2++;
        num2 = num2*20 + dig ;
    }
    for(long long i=ln2 ; i<100 ; i++) numb2[i]=0;
    
    cerr << num1 << " " << num2 << endl ;
    
    string operation;
    cin >> operation; cin.ignore();
    
    long long result[100] , lnr=0;
    long long answer ;
    if (operation=="+") { 
        answer = num1 + num2 ;
        long long carry=0;
        lnr = (ln1>ln2)?ln1:ln2 ;
    }
    else if (operation=="-") answer = num1 - num2 ;
    else if (operation=="*") answer = num1 * num2 ;
    else if (operation=="/") answer = num1 / num2 ;


    long long digits[30] , ld=0 ;
    while(answer>0) { digits[ld]=answer%20 ; ld++ ; answer=answer/20 ; }
    if (ld==0) { digits[0]=0 ; ld=1 ;}
    
    for(long long k=ld-1 ; k>=0 ; k--) {
        for(long long i=0 ; i<L*H ; i++) {
            cout << number[digits[k]][i] ;
            if ((i+1)%L==0) cout << endl ;
        }    
    }
}

*/