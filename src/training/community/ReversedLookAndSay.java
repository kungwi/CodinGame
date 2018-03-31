/*

bool validQ(string s) {
    if (s.size()%2) return false ;
    for(int i=1 ; i<s.size()-2 ; i+=2) 
        if (s[i]==s[i+2]) return false ;
return true ; }

string produce(string s) {
string res="" ;

for(int i=0 ; i<s.size()-1 ; i+=2) {
    int freq= s[i]-'0' ;
    for(int j=0 ; j<freq ; j++) 
        res.push_back(s[i+1]) ; }
return res ; }
    
int main() {
    string s , n ;
    getline(cin, s);
    
    while(validQ(s)) { 
        n=produce(s) ; 
        if (n==s) break ;
        else s=n ; }
        
    cout << s << endl ;
return 0 ; }
 */
package training.community;
import java.util.*;

/**
 *
 * @author thales
 */
public class ReversedLookAndSay {

    private static boolean validQ(String s) {
    if (s.length()%2==1) return false ;
    for(int i=1 ; i<s.length()-2 ; i+=2) 
        if (s.charAt(i)==s.charAt(i+2)) return false ;
    return true ; }
    
    private static String produce(String s) {
        String res = "" ;
        for(int i=0 ; i<s.length()-1 ; i+=2) {
            int freq = s.charAt(i)-'0' ;
            for(int j=0 ; j<freq ; j++) 
                res += s.charAt(i+1) ; }
        return res ; }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        
        while(validQ(s)) { 
            String n = produce(s) ; 
            if (n.equals(s)) break ;
            else s=n ; }
        
        System.out.println(s) ; }    
}
