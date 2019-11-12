package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这里备注下几个字符对应的ascall码
 * A------->65
 * a------->97
 * 0------->48
 * using backtracking
 *
 */
class Solution {
    private static Map<Character,List<Character>> characterListMap= new HashMap<>();

    private List<String> result=new ArrayList<>();
    //初始化静态资源 存储为key value格式
    static {
        //统计当前26个字母
        int lowCharCount=0,size;
        for (int i = 2; i <= 9; i++) {
            List<Character> temp= new ArrayList<>();
            switch (i){
                case 7:size=4;break;
                case 9:size=4;break;
                default: size=3;break;
            }
            for (int j = 0; j < size; j++) {
                char character= (char) (j+97+lowCharCount);
                temp.add(character);
            }
            lowCharCount+=size;
            characterListMap.put((char)(i+48),temp);
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits!=null && digits.length()!=0) {
            backTracking(new StringBuilder(),digits,0);
        }
        return result;
    }
    public void backTracking(StringBuilder stringBuilder,String digits,Integer indexCharacter){
        if (stringBuilder.length()==digits.length()) {
            result.add(new String(stringBuilder));
            return;
        }
        //获取需要枚举的列表
        List<Character> subChars=characterListMap.get(digits.charAt(indexCharacter));
        Integer next=indexCharacter+1;
        for (int i = 0; i < subChars.size(); i++) {
            stringBuilder.append(subChars.get(i));
            backTracking(stringBuilder,digits,next);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(Character.getType('1'));
        Character test=1;
        System.out.println((char) 48);

        new Solution().letterCombinations("7");
    }
}