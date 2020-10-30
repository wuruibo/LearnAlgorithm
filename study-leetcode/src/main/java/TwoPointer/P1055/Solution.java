package TwoPointer.P1055;

/**
 * 这个解法十分直观和易于理解。
 * 在一个target字符串的遍历中针对每个当前字符寻找source字符串中的匹配字符：若找到匹配字符，则移动 t 索引到下一位置，继续寻找target字符串中的下一个字符。
 * s 索引不再小于source字符串的长度时，说明一轮source字符串的遍历已结束，相当于对source字符串进行了一次截取子字符串，那么子序列数量增加1。
 * 当target字符串遍历完成时，便可对子序列数量进行统计，得到最小的子序列数量。
 *
 * 可以参考P392双指针判断是否是子序列
 */
class Solution {
    public int shortestWay(String source, String target) {
        int[] sourceHash=new int[26];
        for (char c : source.toCharArray()) {
            sourceHash[c-'a']++;
        }
        int s=0,t=0,count=0;
        while (t < target.length()) {
            if (sourceHash[target.charAt(t)-'a']==0) {
                return -1;
            }
            //如果s碰到和t位置相等的时候 t才挪动一下位置
            if (source.charAt(s)==target.charAt(t)) {
                t++;
            }
            s++;
            if (s==source.length()) {
                count++;
                s=0;
            }
        }
        return s==0?count:count+1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestWay("abc", "abcbc"));
        System.out.println(new Solution().shortestWay("abc", "acdbc"));
    }
}
