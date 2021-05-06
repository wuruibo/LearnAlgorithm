package 力扣春季杯.Problem3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * 输入：nums = [100,100,100,-250,-60,-140,-50,-50,100,150]
 *
 * 输出：1
 *
 * 解释：初始血量为 1。至少需要将 nums[3] 调整至访问顺序末尾以满足要求。
 */
class Solution {
    public int magicTower(int[] nums) {
        int all= Arrays.stream(nums).sum()+1;
        if (all<=0){
            return -1;
        }
        Queue<Integer> queue=new LinkedList<>();
        int sum=1,r=0,min=Integer.MAX_VALUE,count=0;
        while (r<nums.length || !queue.isEmpty()){
            int cur=r<nums.length?nums[r]:queue.poll();
            sum+=cur;
            min=Math.min(min,cur);
            if (sum<0){
                //如果把最小的踢出去之后还不能保证大于0 就直接失败 否则继续往后走
                sum-=min;
                queue.offer(min);
                if (sum<0){
                    return -1;
                }else {
                    if (r < nums.length) {
                        r++;
                    }
                    count++;
                }
            }else {
                //如果当前位置可以满足条件那就优先r往后走 走不动了之后从queue中索取
                if (r < nums.length) {
                    r++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Optional.ofNullable(null);
        System.out.println(new Solution().magicTower(new int[]{100, 100, 100, -250, -60, -140, -50, -50, 100, 150}));
        System.out.println(new Solution().magicTower(new int[]{-200,-300,400,0}));
        System.out.println(new Solution().magicTower(new int[]{-200,-300,400,0,400,-500,-400,600}));
    }
}