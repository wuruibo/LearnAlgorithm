package WaitingCollect.P560;


import java.util.HashMap;
import java.util.Map;

/**
 * 采用map记录 key为[0,j]的和 value为和出现的次数
 * [i,j]为和为k的位置 那么sum(0,j)-k=sum(0,i)
 * @autor yeqiaozhu.
 * @date 2019-10-30
 */
public class UsingMap {
    Map<Integer,Integer> counts=new HashMap<>();
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        counts.put(0,1);
        for (int j = 0; j < nums.length; j++) {
            sum+=nums[j];
            //如果存在sum-k的值
            if (counts.containsKey(sum-k)) {
                count+=counts.getOrDefault(sum-k,0);
            }
            counts.put(sum,counts.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        new UsingMap().subarraySum(nums,3);
    }
}
