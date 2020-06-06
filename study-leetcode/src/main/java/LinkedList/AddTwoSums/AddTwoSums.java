package LinkedList.AddTwoSums;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个数组中找出满足给定和的元素
 * @autor yeqiaozhu.
 * @date 2019-04-28
 */
public class AddTwoSums {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++) {
                if (nums[i]+nums[j] ==target) {
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度n
     * 空间复杂度n
     * 通过hash算法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumUsingHash(int[] nums, int target){
        HashMap hashMap=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int value=target-nums[i];
            if(hashMap.containsKey(value) && (int)hashMap.get(value)!=i){
                return new int[]{i, (int) hashMap.get(value)};
            }
        }
        return new int[2];
    }
    public int[] twoSumUsingHashOneCircle(int[] nums,int target){
        Map<Integer,Integer> hashMap=new HashMap();
        for(int i=0;i<nums.length;i++){
            int value=target-nums[i];
            if(hashMap.containsKey(value) && hashMap.get(value)!=i){
                return new int[]{i, hashMap.get(value)};
            }
            hashMap.put(nums[i],i);
        }
        return new int[2];
    }
    public static void main(String[] args) {
        int[] nums={3,2,4};
        System.out.println(new AddTwoSums().twoSum(nums,6));
        System.out.println(new AddTwoSums().twoSumUsingHash(nums,6));
        System.out.println(new AddTwoSums().twoSumUsingHashOneCircle(nums,6));
    }
}
