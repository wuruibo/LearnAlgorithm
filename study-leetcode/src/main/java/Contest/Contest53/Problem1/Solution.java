package Contest.Contest53.Problem1;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set=new HashSet();
        int count=0;
        for(int i=0;i<word.length();i++){
            StringBuilder temp=new StringBuilder();
            //1.成功截取字符串
            while(i<word.length() && word.charAt(i)>='0' && word.charAt(i)<='9'){
                temp.append(word.charAt(i));
                i++;
            }
            //2.去除字符串前置的零
            while (temp.length()>1 && temp.charAt(0)=='0'){
                temp.deleteCharAt(0);
            }
            if(temp.length()>0 && set.add(temp.toString())){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(new Solution().numDifferentIntegers("a1b01c001"));
        System.out.println(new Solution().numDifferentIntegers("a0b00c"));
    }
}