package Array.前缀和.P523;

import java.util.HashSet;

/**
 * 方法二：哈希表
 * 思路：
 * 在方法一中我们利用前缀和数组来求解问题，对于子数组 nums[i:j]nums[i:j] (不包含下标 j )，其区间和为 sum[j] - sum[i]sum[j]−sum[i] (其中 sum 为预处理得到的前缀和数组)，
 *
 * 我们要判断的是 (sum[j] - sum[i])\%k(sum[j]−sum[i])%k 是否等于 0。
 * 根据 modmod 运算的性质，我们知道 (sum[j] - sum[i])\%k = sum[j]\%k - sum[i]\%k(sum[j]−sum[i])%k=sum[j]%k−sum[i]%k。
 * 故若想 (sum[j] - sum[i])\%k = 0(sum[j]−sum[i])%k=0，则必有 sum[j]\%k = sum[i]\%ksum[j]%k=sum[i]%k。
 * 算法：
 * 每当我们计算出一个前缀和 sum[j]sum[j] 时，我们判断哈希表中是否存在键值为 sum[j]\%ksum[j]%k，若存在则有 sum[j]\%k=sum[i]\%ksum[j]%k=sum[i]%k，我们返回 {True}True。
 * 由于我们需要控制子数组长度大于等 2，因此每次计算出的 sum[j]\%ksum[j]%k 的值，我们不能立即放入字典中，而是引入一个中间变量 cachecache 缓存我们的值，待下一次计算时再加入字典，以保证满足条件的子数组长度至少为 22。
 * 对 k=0k=0 的情形，我们需要特判。
 * Java
 *
 *
 * 作者：KLEA
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-qiu-he-by-lenn123/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class UsingHash {
    public boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length, cache = 0;
        int[] sum = new int[N+1];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + nums[i];
            int res = k == 0 ? sum[i+1] : sum[i+1] % k;
            if (set.contains(res)) return true;
            set.add(cache);
            cache = res;
        }

        return false;
    }
}
