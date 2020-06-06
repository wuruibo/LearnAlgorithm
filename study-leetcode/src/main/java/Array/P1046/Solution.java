package Array.P1046;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        return recursive(stones)[0];
    }
    private int[] recursive(int[] arr){
        if (arr.length==0) return new int[1];
        if (arr.length==1) return new int[]{arr[0]};
        //找出第一大的数的下标
        int max=0,mIndex=0,sMax=0,sIndex=0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]>=max) {
                max=arr[i];
                mIndex=i;
            }
        }
        arr[mIndex]=-1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j]>=sMax) {
                sMax=arr[j];
                sIndex=j;
            }
        }
        arr[sIndex]=-1;
        int[] temp=max!=sMax?new int[arr.length-1]:new int[arr.length-2];

        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=-1) temp[index++]=arr[i];
        }
        if (max!=sMax) temp[index]=max-sMax;
        return recursive(temp);
    }

    public static void main(String[] args) {
        int[] ints={2,7,4,1,8,1};
        System.out.println(new Solution().lastStoneWeight(ints));

        int[] ints1={3,1};
        System.out.println(new Solution().lastStoneWeight(ints1));
    }
}