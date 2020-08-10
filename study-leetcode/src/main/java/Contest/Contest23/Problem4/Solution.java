package Contest.Contest23.Problem4;

import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> countMap= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
        }
        List<Integer> greedy= new ArrayList<>();
        Iterator<Map.Entry<Integer,Integer>> iterator=countMap.entrySet().iterator();
        while (iterator.hasNext()) {
            greedy.add(iterator.next().getValue());
        }
        Collections.sort(greedy,Comparator.reverseOrder());

        //开始贪心
        int count=0,target=arr.length/2,temp=arr.length;
        for (int i = 0; i < greedy.size(); i++) {
            temp-=greedy.get(i);
            count++;
            if (temp<=target) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println(new Solution().minSetSize(new int[]{7,7,7,7,7,7}));
        System.out.println(new Solution().minSetSize(new int[]{1,9}));
        System.out.println(new Solution().minSetSize(new int[]{1000,1000,3,7}));
        System.out.println(new Solution().minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
}