package Contest.Contest32.Problem1;

/**
 * 输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出：3
 * 示例 3：
 *
 * 输入：logs = ["d1/","../","../","../"]
 * 输出：0
 */
class Solution {
    public int minOperations(String[] logs) {
        int start=0;
        for (int i = 0; i < logs.length; i++) {
            String log=logs[i];
            boolean back=log.equals("../"),current=log.equals("./"),next=!(back || current);
            if (back && start!=0) {
                start--;
            }else if (next){
                start++;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(new Solution().minOperations(new String[]{"d1/","../","../","../"}));
    }
}