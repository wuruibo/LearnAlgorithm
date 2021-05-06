package Contest.Contest53.Problem2;

/**
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 *
 *
 * 输入：n = 4
 * 输出：2
 * 解释：最初，perm = [0,1,2,3]
 * 第 1 步操作后，perm = [0,2,1,3]
 * 第 2 步操作后，perm = [0,1,2,3]
 * 所以，仅需执行 2 步操作
 */
class Solution {
    public int reinitializePermutation(int n) {
        int[] array=new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i]=i;
        }
        int count=0;
        while (true){
            int[] result=recursive(array);
            count++;
            if (result[n-2]==n-2) {
                break;
            }else {
                array=result;
            }
        }
        return count;
    }
    private int[] recursive(int[] pre){
        int[] result=new int[pre.length];
        for (int i = 0; i < result.length; i++) {
            if(i%2==0){
                result[i]=pre[i/2];
            }else {
                result[i]=pre[pre.length/2+(i-1)/2];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reinitializePermutation(4));
        System.out.println(new Solution().reinitializePermutation(6));
    }

}