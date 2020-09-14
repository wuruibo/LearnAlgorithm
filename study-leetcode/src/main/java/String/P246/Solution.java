package String.P246;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 *
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = "69"
 * 输出: true
 * 示例 2:
 *
 * 输入: num = "88"
 * 输出: true
 * 示例 3:
 *
 * 输入: num = "962"
 * 输出: false
 * 示例 4：
 *
 * 输入：num = "1"
 * 输出：true
 */
class Solution {
    private int[][] array={{0,0},{1,1},{6,9},{9,6},{8,8}};
    public boolean isStrobogrammatic(String num) {
        Map<String,String> arrayMap=Arrays
                .stream(array)
                .collect(Collectors
                        .toMap(object->String.valueOf(object[0]),
                                object->String.valueOf(object[1])));
        for (int i = 0; i < 10; i++) {
            String key=String.valueOf(i);
            if (!arrayMap.containsKey(key)) {
                arrayMap.put(String.valueOf(i),"");
            }
        }
        StringBuilder afterReplace=new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            String key=String.valueOf(num.charAt(i));
            afterReplace.append(arrayMap.get(key));
        }
        return num.equals(afterReplace.reverse().toString());
    }

    /**
     * 双指针写法
     * @param num
     * @return
     */
    public boolean isStrobogrammaticDoublePointer(String num) {
        //满足要求的数字对
        Map<Character, Character> map = new HashMap<>(16);
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        //双指针初始化
        int left = 0, right = num.length() - 1;
        while(left <= right){
            //不满足要求的数字
            if(map.get(num.charAt(left)) == null || map.get(num.charAt(right)) == null)
            {
                return false;
            }
            //check一下是否真的中心对称
            if(map.get(num.charAt(left)) != num.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isStrobogrammatic("69"));
        System.out.println(new Solution().isStrobogrammatic("88"));
        System.out.println(new Solution().isStrobogrammatic("962"));
        System.out.println(new Solution().isStrobogrammatic("1"));
        System.out.println(new Solution().isStrobogrammatic("0"));
    }
}