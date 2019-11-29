package WaitingCollect.P12;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer,String> sample= new HashMap<>();
    private Integer[] integers={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    {
        sample.put(1,"I");
        //构造C结尾 I X开头
        sample.put(4,"IV");
        sample.put(5,"V");
        //构造X结尾 I开头
        sample.put(9,"IX");
        sample.put(10,"X");
        //构造C结尾 X开头
        sample.put(40,"XL");
        sample.put(50,"L");
        //构造C结尾 X开头
        sample.put(90,"XC");
        sample.put(100,"C");
        //构造D结尾 C开头
        sample.put(400,"CD");
        sample.put(500,"D");
        //构造M结尾 C开头
        sample.put(900,"CM");
        sample.put(1000,"M");
    }
    public String intToRoman(int num) {
        StringBuilder result=new StringBuilder();
        while (num!=0){
            for (int i = 0; i < integers.length; i++) {
                while (num/integers[i]!=0){
                    num-=integers[i];
                    result.append(sample.get(integers[i]));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
        System.out.println(new Solution().intToRoman(4));
        System.out.println(new Solution().intToRoman(9));
        System.out.println(new Solution().intToRoman(58));
        System.out.println(new Solution().intToRoman(1994));
    }
}