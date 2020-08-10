package Contest.Contest24.Problem5;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        //前缀和
        int[] subSums=new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            subSums[i]=subSums[i-1]+nums[i-1];
        }
        //统计前缀和中为target的子串
        int before=-1,count=0;
        Map<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < subSums.length; i++) {
            int subTarget=subSums[i]-target;
            if (map.containsKey(subTarget) && map.get(subTarget)>=before) {
                count++;
                before=i;
            }
            map.put(subSums[i],i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
        System.out.println(new Solution().maxNonOverlapping(new int[]{-1,3,5,1,4,2,-9}, 6));
        System.out.println(new Solution().maxNonOverlapping(new int[]{-2,6,6,3,5,4,1,2,8}, 10));
        System.out.println(new Solution().maxNonOverlapping(new int[]{0,0,0}, 0));
    }
}