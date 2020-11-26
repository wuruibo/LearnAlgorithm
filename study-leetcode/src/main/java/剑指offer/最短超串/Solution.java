package 剑指offer.最短超串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 */
class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer,Integer> hash= new HashMap<>(16);
        Set<Integer> set= Arrays.stream(small).boxed().collect(Collectors.toSet());
        int counter=small.length,min=Integer.MAX_VALUE;
        int[] result=new int[]{};
        for (int r = 0,l=0; r < big.length; r++) {
            hash.put(big[r],hash.getOrDefault(big[r],0)+1);
            if (set.contains(big[r]) && hash.get(big[r])==1) {
                counter--;
            }
            //如果当前窗口counter==0表示满足条件可以移动l
            while (counter==0){
                if (r-l+1<min) {
                    min=Math.min(min,r-l+1);
                    result=new int[]{l,r};
                }
                hash.put(big[l],hash.getOrDefault(big[l],0)-1);
                if (set.contains(big[l]) && hash.get(big[l])==0) {
                    counter++;
                }
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestSeq(new int[]{7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7}, new int[]{1,5,9}));
        System.out.println(new Solution().shortestSeq(new int[]{1,2,3}, new int[]{4}));
        System.out.println(new Solution().shortestSeq(new int[]{1,2,3}, new int[]{1,2,3}));
    }
}