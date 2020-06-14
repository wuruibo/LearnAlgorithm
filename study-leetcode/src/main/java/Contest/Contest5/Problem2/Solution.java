package Contest.Contest5.Problem2;

import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> hashMap= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer count=hashMap.getOrDefault(arr[i],0)+1;
            hashMap.put(arr[i],count);
        }
        Iterator<Integer> iterator=hashMap.values().iterator();
        List<Integer> result=new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        result.sort(Integer::compareTo);
        //根据排序后的结果进行贪心
        Integer count=result.size(),tempSum=0;
        for (int i = 0; i < result.size(); i++,count--) {
            tempSum+=result.get(i);
            if (tempSum>k) {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a={5,5,4};
        System.out.println(new Solution().findLeastNumOfUniqueInts(a, 1));

        int[] b={4,3,1,1,3,3,2};
        System.out.println(new Solution().findLeastNumOfUniqueInts(b, 3));
    }
}