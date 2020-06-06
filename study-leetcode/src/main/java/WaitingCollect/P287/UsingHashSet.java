package WaitingCollect.P287;

import java.util.HashSet;
import java.util.Set;

/**
 * @autor yeqiaozhu.
 * @date 2019-10-18
 */
public class UsingHashSet {
    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints={1,3,4,2,2};
        new UsingHashSet().findDuplicate(ints);
    }
}
