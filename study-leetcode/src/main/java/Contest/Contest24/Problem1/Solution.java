package Contest.Contest24.Problem1;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        Integer count=0,length=2000,result=1;
        for (int i = 1; i <= length; i++) {
            if (!set.contains(i)) {
                count++;
            }
            if (count==k) {
                result=i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthPositive(new int[]{2}, 1));
        System.out.println(new Solution().findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(new Solution().findKthPositive(new int[]{1,2,3,4}, 2));
    }
}