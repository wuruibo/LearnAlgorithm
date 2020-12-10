package BinarySearch.P658;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0,r=arr.length-1;
        while (r - l > k-1) {
            if (Math.abs(arr[l]-x)<=Math.abs(arr[r]-x)) {
                r--;
            }else {
                l++;
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList()).subList(l,r+1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findClosestElements(new int[]{1}, 1, 1));
        System.out.println(new Solution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(new Solution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 1));
        System.out.println(new Solution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }
}