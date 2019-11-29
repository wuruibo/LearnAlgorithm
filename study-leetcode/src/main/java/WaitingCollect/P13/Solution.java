package WaitingCollect.P13;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Character,Integer> sample= new HashMap<>();
    {
        sample.put('I',1);
        sample.put('V',5);
        sample.put('X',10);
        sample.put('L',50);
        sample.put('C',100);
        sample.put('D',500);
        sample.put('M',1000);
    }
    public int romanToInt(String s) {
        if (s==null || s.length()==0) {
            return 0;
        }
        int value=sample.get(s.charAt(0)),preValue=0;
        for (int i = 1; i < s.length(); i++) {
            if (sample.get(s.charAt(i-1))>=sample.get(s.charAt(i))) {
                preValue=value;
                value=sample.get(s.charAt(i))+value;
            }else {
                value=sample.get(s.charAt(i))-sample.get(s.charAt(i-1))+preValue;
            }
        }

        return value;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("IV"));
        System.out.println(new Solution().romanToInt("IX"));
        System.out.println(new Solution().romanToInt("LVIII"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}