import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len==1)
            return s;
        String maxString = "";
        ArrayList<String> palindromes = new ArrayList<>();
        Set<String> palin = new HashSet<String>();
        for(int i = 0; i<s.length(); i++){
            palin.add(s.substring(i,i+1));
        }

        for(int k = 2; k<=len; k++){

            for(int i = 0; i<=len-k; i++){
                int start = i;
                int end = i+k-1;

                if(start<end){
                    String check;
                    if(k==2)
                        check = s.substring(start,end);
                    else
                        check = s.substring(start+1,end);
                    if(s.charAt(start)==s.charAt(end)&& palin.contains(check)) {
                        palin.add(s.substring(start, end + 1));
                    }
                }

            }
        }

    for(String ele: palin){
        if(ele.length()>maxString.length())
            maxString=ele;
    }
    return maxString;
    }

    public static void main(String[] args){
        String s = "babda";
      System.out.println(longestPalindrome(s));
        //String s = "bbcd";
       // System.out.println(s.substring(0,1));
    }
}