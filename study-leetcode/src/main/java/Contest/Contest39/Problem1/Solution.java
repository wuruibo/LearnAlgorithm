package Contest.Contest39.Problem1;

import java.util.Arrays;

/**
 * 检查两个字符串数组是否相等
 */
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String first=Arrays.stream(word1).reduce((a,b)->a+b).get();
        String second=Arrays.stream(word2).reduce((a,b)->a+b).get();
        if (first.length()!=second.length()) {
            return false;
        }else {
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i)!=second.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}