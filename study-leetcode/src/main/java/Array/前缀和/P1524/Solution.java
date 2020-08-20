package Array.前缀和.P1524;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和+状态压缩
 */
class Solution {
    public int longestAwesome(String s) {
        Map<Integer,Integer> subIndex= new HashMap<>();
        //最初的状态 当status为0的时候 设置index=-1
        subIndex.put(0,-1);
        int status=0,max=0;
        for (int i = 0; i < s.length(); i++) {
            //step1 计算当前位置的状态压缩值status
            status^=1<<(s.charAt(i)-'0');
            //step2 判断当前状态压缩值之前是否出现过
            if (subIndex.containsKey(status)) {
                max=Math.max(max,i-subIndex.get(status));
            }else {
                subIndex.put(status,i);
            }
            //step3 判断当前状态压缩值之前是否存在与它只相差一个1的状态值
            for (int j = 0; j < 10; j++) {
                int status1 = status ^ (1 << j);
                if (subIndex.containsKey(status1)) {
                    max=Math.max(max,i-subIndex.get(status1));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestAwesome("3242415"));
        System.out.println(new Solution().longestAwesome("12345678"));
        System.out.println(new Solution().longestAwesome("213123"));
        System.out.println(new Solution().longestAwesome("00"));
    }
}