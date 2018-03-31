/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.easy;

import java.util.*;
import java.io.*;
import java.math.*;
/**
 *
 * @author chris
 */
public class MIMEType {
    
    
        public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        
        Map<String, String> ExtList = new HashMap<String, String>();
        
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.    
            ExtList.put(EXT.toLowerCase(), MT);
        }
        
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            int pos = FNAME.lastIndexOf('.');
            
            if ( (pos>=0) && (ExtList.containsKey(FNAME.substring(pos+1).toLowerCase())))
                System.out.println(ExtList.get(FNAME.substring(pos+1).toLowerCase()));
            else  System.out.println("UNKNOWN");  
        }
        }
    
}
