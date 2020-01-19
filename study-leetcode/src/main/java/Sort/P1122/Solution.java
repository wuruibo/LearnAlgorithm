package Sort.P1122;

import java.util.*;

/**
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * Constraints:
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> data= new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            Integer integer=arr1[i];
            data.put(integer,data.getOrDefault(integer,0)+1);
        }

        List<Integer> result= new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            if (data.containsKey(arr2[i])) {
                for (Integer integer = 0; integer < data.get(arr2[i]); integer++) {
                    result.add(arr2[i]);
                }
                data.put(arr2[i],-1);
            }
        }
        List<Integer> temp=new ArrayList<>();
        Iterator<Map.Entry<Integer,Integer>> iterator=data.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,Integer> entry=iterator.next();
            Integer value=entry.getValue();
            while (value-->0) {
                temp.add(entry.getKey());
            }

        }
        temp.sort(Comparator.naturalOrder());
        for (int i = 0; i < temp.size(); i++) {
            result.add(temp.get(i));
        }
        int[] resultInt=new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultInt[i]=result.get(i);
        }
        return resultInt;
    }

    public static void main(String[] args) {
        int[] arr1={2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2={2,42,38,0,43,21};
        System.out.println(new Solution().relativeSortArray(arr1,arr2));
    }
}