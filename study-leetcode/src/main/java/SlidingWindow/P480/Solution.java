package SlidingWindow.P480;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 *
 *
 */
class Solution {
    List<Integer> sorted= new LinkedList<>();
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k==0) {
            return new double[0];
        }
        //先初始化第一个窗口
        k=k>nums.length?nums.length:k;
        int time=nums.length-k+1,index=0;
        double[] result=new double[time];

        for (int j = 0; j < k; j++) {
            addNode(nums,nums[j]);
        }
        result[index]=getMedian();
        index++;
        //之后每划动一次 消除最前面的元素 继续增加一个元素
        for (int i = 1; i < time; i++) {
            //remove掉前面的元素
            for (int t = 0; t < sorted.size(); t++) {
                if (sorted.get(t)==nums[i-1]) {
                    sorted.remove(t);
                    break;
                }
            }
            addNode(nums,nums[i+k-1]);
            result[index]=getMedian();
            index++;
        }

        return result;

    }
    private double getMedian(){
        int mid=sorted.size()/2;
        //为了避免int越界 需要特殊处理加号

        return (sorted.size()&1)==0?sorted.get(mid-1)+(sorted.get(mid)-sorted.get(mid-1))/2.0:sorted.get(mid);
    }
    private void addNode(int[] nums,int target){
        int start=0,end=sorted.size()-1;

        while (start<=end){
            int mid=(start+end)/2;

            if (sorted.get(mid)<target) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }

        int index=start<end?end:start;
        sorted.add(index,target);
    }

    public static void main(String[] args) {
        int[] nums={1,4,2,3};
        Arrays.stream(new Solution().medianSlidingWindow(nums, 2)).forEach(integer-> System.out.print(integer+" "));
        System.out.println();
        Arrays.stream(new Solution().medianSlidingWindow(nums, 1)).forEach(integer-> System.out.print(integer+" "));
        System.out.println();
        Arrays.stream(new Solution().medianSlidingWindow(nums, 0)).forEach(integer-> System.out.print(integer+" "));
    }
}