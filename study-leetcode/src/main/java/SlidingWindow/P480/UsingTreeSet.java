package SlidingWindow.P480;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 *
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
 * @autor yeqiaozhu.
 * @date 2019-12-26
 */
public class UsingTreeSet {


    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k==0) {
            return new double[0];
        }

        //step1 定义两个treeSet 一个left升序 一个right降序
        Comparator<Integer> comparator=(a, b)->nums[a]==nums[b]?(Integer.compare(a,b)):Integer.compare(nums[a],nums[b]);

        TreeSet<Integer> left=new TreeSet<>(comparator);
        TreeSet<Integer> right=new TreeSet<>(comparator);
        Supplier<Double> getMeDian=()->left.size()==right.size()?((double) nums[right.first()]+ (double) nums[left.last()])/2.0:nums[left.last()]/1.0;
        //step2 先插入第一个窗口
        k=k>nums.length?nums.length:k;
        for (int i = 0; i < k; i++) {
            left.add(i);
            right.add(left.pollLast());
            if (left.size()<right.size()) {
                left.add(right.pollFirst());
            }
        }
        //step3 获取第一个窗口的median
        int time=nums.length-k+1,index=0;
        double[] result=new double[time];
        result[index]=getMeDian.get();
        index++;
        //step4 后续窗口继续划动
        for (int j = 1; j < time; j++) {
            //1. 删除前面的元素
            if (!left.remove(j-1)) {
                right.remove(j-1);
            }
            //2. 追加后面的元素
            left.add(j+k-1);
            right.add(left.pollLast());
            if (left.size()<right.size()) {
                left.add(right.pollFirst());
            }
            result[index]=getMeDian.get();
            index++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums={-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        Arrays.stream(new UsingTreeSet().medianSlidingWindow(nums, 6)).forEach(integer-> System.out.print(integer+" "));
        System.out.println();
        Arrays.stream(new UsingTreeSet().medianSlidingWindow(nums, 1)).forEach(integer-> System.out.print(integer+" "));
        System.out.println();
        Arrays.stream(new UsingTreeSet().medianSlidingWindow(nums, 0)).forEach(integer-> System.out.print(integer+" "));
    }
}