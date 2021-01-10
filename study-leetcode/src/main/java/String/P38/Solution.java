package String.P38;

/**
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 */
class Solution {
    public String countAndSay(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        //递归内容
        StringBuffer ans = new StringBuffer();
        int i = 0;
        String res = countAndSay(n - 1);
        int len = res.length();
        while(i<len){
            int count = 1;
            while(i<len-1&&res.charAt(i)==res.charAt(i+1)){
                count++;
                i++;
            }
            ans.append(count).append(res.charAt(i));
            i++;
        }
        //返回值
        return ans.toString();
    }
}
