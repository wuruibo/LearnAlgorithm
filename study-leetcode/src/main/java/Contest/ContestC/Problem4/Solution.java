package Contest.ContestC.Problem4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个数组 nums1 和 nums2 。
 *
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 *
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 * 示例 2：
 *
 * 输入：nums1 = [3,-2], nums2 = [2,-6,7]
 * 输出：21
 * 解释：从 nums1 中得到子序列 [3] ，从 nums2 中得到子序列 [7] 。
 * 它们的点积为 (3*7) = 21 。
 * 示例 3：
 *
 * 输入：nums1 = [-1,-1], nums2 = [1,1]
 * 输出：-1
 * 解释：从 nums1 中得到子序列 [-1] ，从 nums2 中得到子序列 [1] 。
 * 它们的点积为 -1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 100
 *  
 *
 * 点积：
 *
 * 定义 a = [a1, a2,…, an] 和 b = [b1, b2,…, bn] 的点积为：
 *
 *
 *
 * 这里的 Σ 指示总和符号。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null) return 0;
        Map<Integer,List<List<Integer>>> firstMap= new HashMap<>();
        Map<Integer,List<List<Integer>>> secondMap= new HashMap<>();
        backTracking(0,nums1.length,nums1,new ArrayList<>(),firstMap);
        backTracking(0,nums2.length,nums2,new ArrayList<>(),secondMap);

        int len=Math.min(nums1.length,nums2.length),max=Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            List<List<Integer>> first=firstMap.get(i+1);
            List<List<Integer>> second=secondMap.get(i+1);

            for (int j = 0; j < first.size(); j++) {
                List<Integer> left=first.get(j);
                for (int k = 0; k < second.size(); k++) {
                    List<Integer> right=second.get(k);
                    int count=0;
                    for (int m = 0; m < left.size(); m++) {
                        count+=left.get(m)*right.get(m);
                    }
                    max=Math.max(count,max);
                }
            }
        }
        return max;
    }
    private void backTracking(int start, int end,int[] nums, List<Integer> temp, Map<Integer,List<List<Integer>>> result){
        if (start>end) return;
        for (int i = start; i < end; i++) {
            temp.add(nums[i]);
            List<List<Integer>> list= result.getOrDefault(temp.size(), new ArrayList<>());
            list.add(new ArrayList<>(temp));
            result.put(temp.size(),list);
            backTracking(i+1,end,nums,temp,result);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a= {2,1,-2,5};
        int[] b= {3,0,-6};
        System.out.println(new Solution().maxDotProduct(a, b));

        int[] a1= {3,-2};
        int[] b1= {2,-6,7};
        System.out.println(new Solution().maxDotProduct(a1, b1));


        int[] a2= {-1,-1};
        int[] b2= {1,1};
        System.out.println(new Solution().maxDotProduct(a2, b2));
    }
}