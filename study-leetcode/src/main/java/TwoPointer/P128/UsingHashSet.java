package TwoPointer.P128;

import java.util.HashSet;
import java.util.Set;

/**
 * using hashset
 * 通过hashset存储
 * [100, 4, 200, 1, 3, 2]
 * 4
 * @autor yeqiaozhu.
 * @date 2019-11-26
 */
public class UsingHashSet {
    private Set<Integer> hashSet= new HashSet<>();
    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        //将nums填入hashset 其实一开始想用数组的 （权衡一下空间和时间的话是用hashset）
        for (int num : nums) {
            hashSet.add(num);
        }
        //循环 定位到hashset中的某个节点 开始往前后遍历remove 搜寻到当前连续串中的最大串儿
        int tempMax=0,max=1;
        for (int num : nums) {
            int left=num,right=num+1;
            while (hashSet.remove(left--)){tempMax++;}
            while (hashSet.remove(right++)){tempMax++;}
            max=Math.max(tempMax,max);
            tempMax=0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints={100, 4, 200, 1, 3, 2};
        System.out.println(new UsingHashSet().longestConsecutive(ints));
        int[] ints1={100};
        System.out.println(new UsingHashSet().longestConsecutive(ints1));

        int[] ints2={1,2,0,1};
        System.out.println(new UsingHashSet().longestConsecutive(ints2));
    }
}
