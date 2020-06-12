import java.util.HashMap;

public class Solution {
    public static int firstUniqChar(String s) {
        if(s.length()==0)
            return -1;
        if(s.length()==1)
            return 0;

        HashMap<Character, Integer> schar = new HashMap<Character, Integer>();
        for(int i = 0;i<s.length();i++){
            if(!schar.containsKey(s.charAt(i)))
                schar.put(s.charAt(i),1);
            else {
                schar.put(s.charAt(i),schar.get(s.charAt(i))+1);
            }
        }
        System.out.println("Hasmap: " + schar);
    int min = s.length();
        for(char i : schar.keySet()){
            if(schar.get(i)>1)
                continue;
            int temp = s.indexOf(i);
            if(temp<min)
                min = temp;
        }
        return min;
    }

    public static void main(String[] args){

        System.out.println(firstUniqChar("d"));

        int x = 2000;
        int rightMost = x>>31;

        System.out.println(rightMost);

    }
}