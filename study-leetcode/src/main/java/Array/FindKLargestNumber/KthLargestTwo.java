package Array.FindKLargestNumber;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-09
 */
public class KthLargestTwo {
    private final int k;
    private final ArrayList<Integer> array = new ArrayList<>();

    public KthLargestTwo(int k, int[] nums) {
        this.k = k;
        int numsLength = nums.length;

        for (int i = 0; i < numsLength; i++) {
            if (i > k-1) {
                Collections.sort(array);
                add(nums[i]);
            } else {
                array.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (array.size() < k) {
            array.add(val);
        } else if (val > array.get(0)) {
            array.set(0, val);
        }
        Collections.sort(array);
        return array.get(0);
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {-10,1,3,1,4,10,3,9,4,5,1};
        KthLargestTwo kthLargest = new KthLargestTwo(7, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(2));   // returns 5
        System.out.println(kthLargest.add(3));  // returns 5
        System.out.println(kthLargest.add(1));   // returns 8
        System.out.println(kthLargest.add(2));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
        System.out.println(kthLargest.add(5));   // returns 8
        System.out.println(kthLargest.add(5));   // returns 8
        System.out.println(kthLargest.add(6));   // returns 8
        System.out.println(kthLargest.add(7));   // returns 8
        System.out.println(kthLargest.add(7));   // returns 8
        System.out.println(kthLargest.add(8));   // returns 8
        System.out.println(kthLargest.add(2));   // returns 8
        System.out.println(kthLargest.add(3));   // returns 8
        System.out.println(kthLargest.add(1));   // returns 8
        System.out.println(kthLargest.add(1));   // returns 8
        System.out.println(kthLargest.add(1));   // returns 8
        System.out.println(kthLargest.add(10));   // returns 8
        System.out.println(kthLargest.add(11));   // returns 8
        System.out.println(kthLargest.add(5));   // returns 8
    }
}
