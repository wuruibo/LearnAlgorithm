package P287;

/**
 * 快慢指针
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
        int finder = 0;
        while(true){
            finder = nums[finder];
            slow = nums[slow];
            if(slow == finder)
                break;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] ints={2,1,1};
        new UsingFastSlowPointer().findDuplicate(ints);
    }
}
