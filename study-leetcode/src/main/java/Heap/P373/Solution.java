package Heap.P373;

import java.util.*;

class Solution {
    //[1,7,11] [2,4,6]转换为合并k个有序链表问题  leetcode 23 合并K个有序链表
    //(1,2) (1,4) (1,6)
    //(7,2) (7,4) (7,6)
    //(11,2) (11,4) (11,6)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //step1 定义一个小顶堆
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(a->a[0]+a[1]));
        List<List<Integer>> result=new ArrayList();
        //step2 将每种情况下的首个元素压入堆
        for(int i=0;i<Math.min(nums1.length,k);i++){
            priorityQueue.offer(new int[]{nums1[i],nums2[0],0});
        }
        //step3 找到前k个元素
        while(k>0 && !priorityQueue.isEmpty()){
            int[] cur=priorityQueue.poll();
            k--;
            List<Integer> curList= Arrays.asList(cur[0],cur[1]);;
            result.add(curList);
            if(cur[2]==nums2.length-1){
                continue;
            }
            priorityQueue.offer(new int[]{cur[0],nums2[cur[2]+1],cur[2]+1});

        }
        return result;
    }
}