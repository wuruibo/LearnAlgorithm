package 解题群.铃盛软件;

import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    private int[] nums2;
    private Map<Integer,Integer> map1;
    private Map<Integer,Integer> map2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2=nums2;
        map1=countMap(nums1);
        map2=countMap(nums2);
    }
    
    public void add(int index, int val) {
        int num=nums2[index];
        nums2[index]+=val;
        if(map2.containsKey(num) && map2.get(num)!=0){
            map2.put(num,map2.get(num)-1);
        }
        map2.put(nums2[index],map2.getOrDefault(nums2[index],0)+1);
    }
    
    public synchronized int count(int tot) {
        return map1.entrySet().stream().map(entry->{
            int key1=entry.getKey();
            int value1=entry.getValue();
            int value2=map2.getOrDefault(tot-key1,0);
            return value1*value2;
        }).reduce((a,b)->a+b).get();
    }
    private Map<Integer,Integer> countMap(int[] nums){
        Map<Integer,Integer> map=new HashMap(10000);
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return map;
    }

}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */