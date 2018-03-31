package training.easy;

import java.util.*;
import java.io.*;
import java.math.*;

public class Defibrillators {
	
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in) ;
        String LON = in.next() ;
        String LAT = in.next() ;
        
        Scanner lonIn = new Scanner(LON.replace(',' , '.')) ;
        Scanner latIn = new Scanner(LAT.replace(',' , '.')) ;
        
        double lon = lonIn.nextFloat()*Math.acos(-1)/180 ;
        double lat = latIn.nextFloat()*Math.acos(-1)/180 ;
               
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        double bestDist = 999999999999.9 ;
        String answer = "" ;
        
        for (int i = 0; i < N; i++) {
            
            String DEFIB = in.nextLine();
            String temp=DEFIB.substring(DEFIB.indexOf(';')+1) ;
            String name = temp.substring(0, temp.indexOf(';')) ;
            String temp2=temp.substring(temp.indexOf(';')+1) ;
            String temp3 = temp2.substring(temp2.indexOf(';')+1) ;
            String coords = temp3.substring(temp3.indexOf(';')+1) ;
            
            Scanner coordsIn = new Scanner(coords.replace(';',' ').replace(',','.'));
            double lonx = coordsIn.nextFloat()*Math.acos(-1)/180 ;
            double laty = coordsIn.nextFloat()*Math.acos(-1)/180 ;
            
            double x = (lon-lonx)*Math.cos((lon+lonx)/2.) ;
            double y = lat-laty ;
            double dist = Math.sqrt(x*x + y*y)*6371.0 ;
                       
            if (dist<bestDist) { bestDist=dist ; answer = name ; }
            
        }

        System.out.println(answer);
    }


}
