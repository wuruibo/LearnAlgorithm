package Contest.Contest38.Problem4;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int createSortedArray(int[] instructions) {
        List<Integer> list= new LinkedList<>();
        int result=0;
        for (int i = 0; i < instructions.length; i++) {
            int current=instructions[i];
            int left=binaryGetLeft(list,i-1,current);
            int right=binaryGetRight(list,i-1,current);
            //重新构建一下nums
            list.add(left,current);
            result+=Math.min(left,i-right);
            result%=1000000007;
        }
        return result;
    }
    private int binaryGetRight(List<Integer> list,int i,int target){
        int begin=0,end=i;
        while (begin <= end) {
            int mid=begin+((end-begin)>>1);
            if (target>=list.get(mid)) {
                begin=mid+1;
            }else {
                end=mid-1;
            }
        }
        return begin;
    }
    private int binaryGetLeft(List<Integer> list,int i,int target){
        int begin=0,end=i;
        while (begin <= end) {
            int mid=begin+((end-begin)>>1);
            if (target>list.get(mid)) {
                begin=mid+1;
            }else {
                end=mid-1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().createSortedArray(new int[]{1,5,6,2}));
        System.out.println(new Solution().createSortedArray(new int[]{1,2,3,6,5,4}));
        System.out.println(new Solution().createSortedArray(new int[]{1,3,3,3,2,4,2,1,2}));
    }
}