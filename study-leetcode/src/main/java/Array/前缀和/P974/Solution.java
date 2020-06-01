package Array.前缀和.P974;

import java.util.*;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
/*    public int subarraysDivByK(int[] A, int K) {
        int result=0;
        for (int i = 0; i < A.length; i++) {
            int count=0;
            for (int j = i; j < A.length; j++) {
                count+=A[j];
                if (count%K==0) {
                    result++;
                }
            }
        }
        return result;
    }*/

    /**
     * 还是要利用前缀和
     *
     * 前缀和(preSum[j]-preSum[i])%K==0
     * 转换为 preSum[j]%K == preSum[i]%K
     *
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        //step1 用hash存储前缀和%K（余数） 索引是余数 值是计算数量多少个
        int[] hash=new int[K];
        hash[0]=1;
        int result=0;
        for (int i = 0,preDiv=0; i < A.length; i++) {
            //这个是前缀和的余数
            preDiv=(preDiv+A[i])%K;
            //这个是当前前缀和余数前的同等余数
            if (preDiv < 0) preDiv += K;

            result+=hash[preDiv];
            //这个是将当前前缀和的余数加到指定位置
            hash[preDiv]++;
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] A={2,1,3,4,2,1};
        List<Integer> result= new ArrayList<>();
        result.add(2);
        result.add(1);
        result.add(3);
        result.add(4);
        result.add(2);
        result.add(1);
        new Solution().testIterator(result);
        System.out.println(result.toString());
    }
    private void testIterator(List<Integer> before){

        Iterator<Integer> iterator=before.iterator();
        Set<Integer> set = new HashSet<>();
        //能找到order_pick_detail记录的走新的逻辑 找不到的走老逻辑
        while (iterator.hasNext()) {
            Integer integer=iterator.next();
            //去重 直接remove掉同样的orderId
            if (set.add(integer)) {
                if (integer==2  || integer==4 || integer==1) {
                    iterator.remove();
                }
            }else {
                iterator.remove();
            }
        }
    }
}