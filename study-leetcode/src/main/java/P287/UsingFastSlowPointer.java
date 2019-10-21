package P287;

/**
 * 快慢指针法
 * @autor yeqiaozhu.
 * @date 2019-10-21
 */
public class UsingFastSlowPointer {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow)
                break;
        }
        return nums[slow];
    }

    public static void main(String[] args) {
        int[] ints={1,3,4,2,2};
        new UsingFastSlowPointer().findDuplicate(ints);
    }
}
