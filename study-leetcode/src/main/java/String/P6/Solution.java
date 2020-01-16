package String.P6;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows<=1) {
            return s;
        }
        //step1 初始化字符串数组
        List<StringBuilder> temp= new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            temp.add(i,new StringBuilder());
        }
        //step2 开始循环加入 定义当前字符需要插入字符串数组的位置
        int index=0,distance=1;
        for (int i = 0; i < s.length(); i++) {
            temp.get(index).append(s.charAt(i));
            if (index==0) {
                distance=1;
            }
            if (index==numRows-1) {
                distance=-1;
            }
            index+=distance;
        }
        //step3 组合这个字符串数组
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < temp.size(); i++) {
            result.append(temp.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("AB",1));
        System.out.println(new Solution().convert("PAYPALISHIRING",4));
    }
}