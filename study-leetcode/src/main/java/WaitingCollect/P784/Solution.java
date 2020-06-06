package WaitingCollect.P784;

import java.util.ArrayList;
import java.util.List;

/**
 * 单纯采用递归的方式做
 * using recursive
 */
class Solution {
    public List<String> letterCasePermutation(String S) {
        if(S.length()==1){
            //如果是字母
            List<String> list=new ArrayList<>(2);
            list.add(S);
            if(S.charAt(0)>64 && S.charAt(0)<91){
                list.add(Character.toString(S.charAt(0)).toLowerCase());
            }else if(S.charAt(0)>90){
                list.add(Character.toString(S.charAt(0)).toUpperCase());
            }
            return list;
        }
        List<String> subList=letterCasePermutation(S.substring(0,S.length()-1));
        int subLength=subList.size();
        char nextChar=S.charAt(S.length()-1);

        if(nextChar>64 && nextChar<91){
            for (int i = 0; i < subLength; i++) {
                subList.add(subList.get(i).concat(Character.toString(nextChar)));
            }
            for (int i = 0; i < subLength; i++) {
                subList.set(i,subList.get(i).concat(Character.toString(nextChar).toLowerCase()));
            }
        }else if (nextChar>90){
            for (int i = 0; i < subLength; i++) {
                subList.add(subList.get(i).concat(Character.toString(nextChar)));
            }
            for (int i = 0; i < subLength; i++) {
                subList.set(i,subList.get(i).concat(Character.toString(nextChar).toUpperCase()));
            }

        }else {
            for (int i = 0; i < subLength; i++) {
                subList.set(i,subList.get(i).concat(Character.toString(nextChar)));
            }
        }
        return subList;
    }

    public static void main(String[] args) {
/*        String string=new String("123456");
        System.out.println(string.substring(0,string.length()-1));*/

        List<String> strings=new Solution().letterCasePermutation("a1b2");
        strings.forEach(s -> System.out.println(s));
    }
}