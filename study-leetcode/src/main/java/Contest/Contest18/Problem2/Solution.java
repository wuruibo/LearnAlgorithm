package Contest.Contest18.Problem2;

/**
 * 灯泡开关 IV
 *
 * 初始的开灯情况是{0,0,0,0,0}全黑 假设target为{1,0,1,0,0}
 * 碰到i=0位置 0!=1开灯 {1,1,1,1,1} current=1;
 * 碰到i=1位置 1!=0关灯 {1,0,0,0,0} current=0;
 * 碰到i=2位置 0!=1开灯 {1,0,1,1,1} current=1;
 * 碰到i=3位置 1!=0关灯 {1,0,1,0,0} current=0;
 * 碰到i=4位置 0==0不操作 {1,0,1,0,0} current=0;
 */
class Solution {
    public int minFlips(String target) {
        char current='0';
        int count=0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i)!=current) {
                current=target.charAt(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minFlips("10100"));
    }
}